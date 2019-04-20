package com.example.hopper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    // pulling out references to UI elements on login screen
    private EditText etSignupEmail;
    private EditText etSignupPassword;
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSignup;
    private Button btnFBSignup;
    private TextView tvExistLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etSignupEmail = findViewById(R.id.etSignupEmail);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        btnSignup = findViewById(R.id.btnSignup);
        btnFBSignup = findViewById(R.id.btnFBSignup);
        tvExistLogin = findViewById(R.id.tvExistLogin);
        tvExistLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                goLoginActivity();
            }
        });

    }

    private void goLoginActivity() {
        Log.d(TAG, "Navigating to Login Activity");
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
