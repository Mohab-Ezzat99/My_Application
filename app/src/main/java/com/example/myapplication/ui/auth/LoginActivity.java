package com.example.myapplication.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ui.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button login;
    Animation bottomanim, topanimation;
    TextView create;
    EditText email, password;
    FirebaseAuth fireAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //===========================================================
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        create = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        fireAuth = FirebaseAuth.getInstance();
        //===========================================================
        // Go to Create account activity
        create.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
        //===========================================================
        // Animation
        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        //load button and text to apply animation
        create = findViewById(R.id.signup);
        // Apply animation
        create.setAnimation(bottomanim);

        //===========================================================
        // Login Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling the function LoginVerify
                loginverfiy();
//                startActivity(new Intent(getBaseContext(), HomeActivity.class));
//                finish();
            }

            private void loginverfiy() {
                // get the text from edit text
                String emailtxt = email.getText().toString();
                String passtxt = password.getText().toString();
                // if email and password empty show toast
                if ((emailtxt.isEmpty()) && (passtxt.isEmpty())) {
                    Toast.makeText(LoginActivity.this, "Enter Email and Password !", Toast.LENGTH_SHORT).show();
                }
                // if only email edit text empty
                else if (emailtxt.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter Email !", Toast.LENGTH_SHORT).show();
                }
                // Patterns Email address Build-in Function to check if the email is in correct format or not // EX : ASDAD@AAA.com
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()) {
                    Toast.makeText(LoginActivity.this, "Enter Correct Email !", Toast.LENGTH_SHORT).show();
                }
                // if only pass edit text is empty or not
                else if (passtxt.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter Password !", Toast.LENGTH_SHORT).show();
                }
                // length function to check if number of characters of password is less that 6 or not
                else if (passtxt.length() < 6) {
                    Toast.makeText(LoginActivity.this, "Password must be at least 6 Characters !", Toast.LENGTH_LONG).show();
                }
                // Text Utils is like isEmpty Function to return nothing if both are empty
                if (TextUtils.isEmpty(emailtxt)) return;
                if (TextUtils.isEmpty(passtxt)) return;
                // firebase authentication sign in function and passing the email and password from edit text
                fireAuth.signInWithEmailAndPassword(emailtxt, passtxt)

                        // *if the email and password are the same with the firebase
                        //  * we use addOnCompleteListener to check if it's the correct or not
                        //* and if the task correct go to next activity

                        .addOnCompleteListener(task -> {
                            // if it's login successful
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Welcome! Login Successfully", Toast.LENGTH_LONG).show();
                                //Intent intent = new Intent(Login.this,ChooseActivity.class);
                                //startActivity(intent);
                                finish();

                            }
                            // Else password and email is not correct show toast with Failure
                            else {
                                Toast.makeText(LoginActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        });


    }


}
