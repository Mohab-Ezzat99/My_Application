package com.example.myapplication.ui.auth;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText et_fullName;
    TextInputEditText et_username, et_email, et_password;
    Button btn_createAccount;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        //==========================================================
        et_fullName = findViewById(R.id.fullname_pat_reg);
        et_username = findViewById(R.id.username_reg_pat);
        et_email = findViewById(R.id.pat_reg_email);
        et_password = findViewById(R.id.pat_reg_pass);
        btn_createAccount = findViewById(R.id.btn_sgn_up_pat_reg);
        //==========================================================
        btn_createAccount.setOnClickListener(v -> {
            final String name = et_fullName.getText().toString().trim();
            final String username = et_username.getText().toString().trim();
            final String email = et_email.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            if ((name.isEmpty()) || (username.isEmpty()) || (email.isEmpty()) || (password.isEmpty())) {
                Toast.makeText(SignupActivity.this, "Please Enter Full Date", Toast.LENGTH_SHORT).show();
            }
            // if email address doesn't match the email pattern --> example@abcd.com
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(SignupActivity.this, "Please Enter Correct Email", Toast.LENGTH_SHORT).show();

            }
            // if passwords less than 6 characters
            else if (password.length() < 6) {
                Toast.makeText(SignupActivity.this, "Password at least 6 characters", Toast.LENGTH_SHORT).show();
            }

            // create and store new account with email and pass
            mAuth.fetchSignInMethodsForEmail(email).addOnSuccessListener(signInMethodQueryResult -> mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task1 -> {
                if (task1.isSuccessful()) {
                    Toast.makeText(getBaseContext(), "Signup successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Error! " + task1.getException(), Toast.LENGTH_LONG).show();
            })).addOnFailureListener(e -> {
                Toast.makeText(getBaseContext(), "Error! " + e.getCause(), Toast.LENGTH_SHORT).show();
            });
        });


    }
}
