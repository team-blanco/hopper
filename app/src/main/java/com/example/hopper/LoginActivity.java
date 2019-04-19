package com.example.hopper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final String TEST = "Test";

    // pulling out references to UI elements on login screen
    private EditText etLoginEmail;
    private EditText etLoginPassword;
    private Button btnLogin;
    private Button btnFBLogin;
    private TextView tvExistSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnFBLogin = findViewById(R.id.btnFBLogin);
        tvExistSignup = findViewById(R.id.tvExistSignup);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = etLoginEmail.getText().toString();
                String password = etLoginPassword.getText().toString();
                login(email, password);
            }
        });
        tvExistSignup.setOnClickListener(new View.OnClickListener(){
            
            @Override
            public void onClick(View view){
                goRegisterActivity();
            }
        });
    }

    private void login(String email, String password) {
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    //TODO: Better error handling
                    Log.e(TAG, "Issue with Login");
                    e.printStackTrace();
                    return;
                }
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    
    private void goRegisterActivity() {
        Log.d(TAG, "Navigating to Register Activity");
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    }


}
