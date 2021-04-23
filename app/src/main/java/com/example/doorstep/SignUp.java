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

public class SignUp extends AppCompatActivity {

    EditText email, password, confirm_password;
    Button signup_btn;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        email = findViewById(R.id.email_edit);
        password = findViewById(R.id.passwordedit);
        confirm_password = findViewById(R.id.confirmPassword);
        auth = FirebaseAuth.getInstance();
        signup_btn = findViewById(R.id.SignUp2home);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = email.getText().toString();
                String password_text = password.getText().toString();
                String confirm_text = confirm_password.getText().toString();

                if(TextUtils.isEmpty(email_text)){
                    Toast.makeText(getApplicationContext(), "Please enter your Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if((TextUtils.isEmpty(password_text))||(password_text.length() == 0)){
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
                }
                if(!confirm_text.equals(password_text)){
                    Toast.makeText(getApplicationContext(), "Password not the same. Make sure you retype the same password", Toast.LENGTH_LONG).show();
                }else{
                    auth.createUserWithEmailAndPassword(email_text,password_text)
                            .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(SignUp.this, "Error",Toast.LENGTH_LONG).show();
                                    }else{
                                        startActivity(new Intent(SignUp.this, EditProfile.class));
                                        finish();
                                    }
                                }
                            });
                }

            }
        });

    }

    public void navigate_sign_in(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }



}
