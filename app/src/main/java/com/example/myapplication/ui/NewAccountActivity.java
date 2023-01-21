package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class NewAccountActivity extends AppCompatActivity {

    EditText fullname, usernamee, email, passwordd;
    Button createnewaccount;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        mAuth = FirebaseAuth.getInstance();
        //==========================================================
        fullname = findViewById(R.id.fullname);
        usernamee = findViewById(R.id.usernamee);
        email = findViewById(R.id.email);
        passwordd = findViewById(R.id.passwordd);
        createnewaccount = findViewById(R.id.createnewaccount);
        //==========================================================
        createnewaccount.setOnClickListener(v -> {
            final String name = fullname.getText().toString();
            final String username = usernamee.getText().toString();
            final String emaill = email.getText().toString();
            String password = passwordd.getText().toString();

            if ((name.isEmpty()) || (username.isEmpty()) || (emaill.isEmpty()) || (password.isEmpty())) {
                Toast.makeText(NewAccountActivity.this, "Please Enter Full Date", Toast.LENGTH_SHORT).show();
            }
            // if email address doesn't match the email pattern --> example@abcd.com
            else if (!Patterns.EMAIL_ADDRESS.matcher(emaill).matches()) {
                Toast.makeText(NewAccountActivity.this, "Please Enter Correct Email", Toast.LENGTH_SHORT).show();

            }
            // if passwords less than 6 characters
            else if (password.length() < 6) {
                Toast.makeText(NewAccountActivity.this, "Password at least 6 characters", Toast.LENGTH_SHORT).show();

            }
            // Check if Edit text empty or not ( TextUtils works as isEmpty)
            if (TextUtils.isEmpty(name)) return;
            if (TextUtils.isEmpty(emaill)) return;
            if (TextUtils.isEmpty(username)) return;
            if (TextUtils.isEmpty(password)) return;
            // create and store new account with email and pass

            mAuth.createUserWithEmailAndPassword(emaill, password)
                    // OnCompleteListener for check if the task completed or not
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // set the data
                            UserModel userModel = new UserModel(name, emaill, username);
                            //Store Data in Real time data base
                            FirebaseDatabase.getInstance().getReference()
                                    //Return the id for user in Data base realtime
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    /*Check if the data had inserted into firebase or not
                                     * if it's inserted show toast and go to login activity to login
                                     * else show toast with failure
                                     */


                                    .setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(NewAccountActivity.this, "Sign Up Successfully", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(NewAccountActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            // if user doesn't sign up
                                            else {

                                                Toast.makeText(NewAccountActivity.this, "Sign Up Failed, Try Again!", Toast.LENGTH_LONG).show();


                                            }
                                        }
                                    });

                        } else {
                            // if the task doesn't complete

                            Toast.makeText(NewAccountActivity.this, "Sign Up Failed", Toast.LENGTH_LONG).show();

                        }
                    });

        });


    }
}
