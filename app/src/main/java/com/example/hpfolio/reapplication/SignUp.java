package com.example.hpfolio.reapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    TextView tvLogin;
    EditText etName, etEmail, etPassword, etPhone;
    Button btnSignUp;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseHelper = new DatabaseHelper(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(etName.getText().toString().length() > 0 & etEmail.getText().toString().length() > 0 & etPassword.getText().toString().length() > 0 & etPhone.getText().toString().length() > 0)) {

                    Toast.makeText(SignUp.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
//                    etEmail.requestFocus();

                }
               else if (etName.getText().toString().startsWith(" ") || etEmail.getText().toString().startsWith(" ") || etPassword.getText().toString().startsWith(" ") || etPhone.getText().toString().startsWith(" ")) {
                    Toast.makeText(SignUp.this, "Please insert correct information", Toast.LENGTH_SHORT).show();

                } else {
                    long user_data = databaseHelper.signup(etName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString(), etPhone.getText().toString());
                    if (user_data == -1) {
                        Toast.makeText(SignUp.this, "Error", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "Inserted", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }

}
