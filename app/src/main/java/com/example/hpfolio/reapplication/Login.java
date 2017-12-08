package com.example.hpfolio.reapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SessionManagement sessionManagement;
    EditText etEmail, etPassword;
    Button btnLogin;
    boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        databaseHelper = new DatabaseHelper(this);
        sessionManagement= new SessionManagement(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!(etPassword.getText().toString().length() > 0 & etEmail.getText().toString().length() > 0)) {

                    Toast.makeText(Login.this, "Please fill all the fieds", Toast.LENGTH_SHORT).show();

                } else if (etEmail.getText().toString().startsWith(" ") || etPassword.getText().toString().startsWith(" ")) {
                    Toast.makeText(Login.this, "Please insert correct information", Toast.LENGTH_SHORT).show();

                } else {
                    Cursor user_data = databaseHelper.login(etEmail.getText().toString(), etPassword.getText().toString());
                    if (user_data.getCount() != 0) {
                        String user_name = null;
                        String user_phone = null;
                        while (user_data.moveToNext()) {

                            int user_name_index = user_data.getColumnIndex("user_name");
                            int user_phone_index = user_data.getColumnIndex("user_phone");

                            user_name = user_data.getString(user_name_index);
                            user_phone = user_data.getString(user_phone_index);

                            sessionManagement.set_userInformation(user_name,user_phone);
//                            Toast.makeText(Login.this,user_name+" "+user_phone,Toast.LENGTH_SHORT).show();
                        }

                        Intent intent = new Intent(Login.this, UserInformation.class);
                        sessionManagement.set_userLoggedIn(true);
//                        intent.putExtra("user_name", user_name);
//                        intent.putExtra("user_phone", user_phone);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(Login.this, "Please insert correct password", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }


}
