package com.example.doorstep;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button LogIn_Button;
    private EditText LogIn_Email, LogIn_password;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        //set view now
        setContentView(R.layout.login);
        auth = FirebaseAuth.getInstance();
        LogIn_Email = findViewById(R.id.email_edit);
        LogIn_Email = findViewById(R.id.password_edit);
        LogIn_Button = findViewById(R.id.login2Home);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        LogIn_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //username
                String email = LogIn_Email.getText().toString();
                //password
                String password = LogIn_password.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter your email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                //authenticate user
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    //There was an error
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent = new Intent(Login.this, Home.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

    }
    public void NavigateSignUp(View v){
        Intent inent = new Intent(this, SignUp.class);
        startActivity(inent);
    }
    public void NavigateForgetPassword(View v){
        Intent inent = new Intent(this, ResetPassword.class);
        startActivity(inent);
    }



}
