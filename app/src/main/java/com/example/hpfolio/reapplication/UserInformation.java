package com.example.hpfolio.reapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserInformation extends AppCompatActivity {

    TextView tvUserName, tvUserPhone;
    ViewDialog viewDialog;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        sessionManagement = new SessionManagement(this);

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserPhone = (TextView) findViewById(R.id.tvUserPhone);

       ArrayList<String> myData =  sessionManagement.get_userInformation();
        String user_name = myData.get(0);
        String user_phone = myData.get(1);
//        Bundle bundle = getIntent().getExtras();
//
//        String user_name = bundle.getString("user_name");
//        String user_phone = bundle.getString("user_phone");


        tvUserName.setText(user_name);
        tvUserPhone.setText(user_phone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.app_bar_logout:



                Intent intent = new Intent(UserInformation.this, Login.class);
                sessionManagement.set_userLoggedIn(false);
                startActivity(intent);
                finish();


                break;
            case R.id.app_bar_rate:

                Toast.makeText(getApplication(), "rate", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }
}
