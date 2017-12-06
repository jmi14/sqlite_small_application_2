package com.example.hpfolio.reapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserInformation extends AppCompatActivity {

    TextView tvUserName,tvUserPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        tvUserName = (TextView)findViewById(R.id.tvUserName);
        tvUserPhone = (TextView)findViewById(R.id.tvUserPhone);

        Bundle bundle = getIntent().getExtras();
        String user_name = bundle.getString("user_name");
        String user_phone = bundle.getString("user_phone");

        tvUserPhone.setText(user_phone);
        tvUserName.setText(user_name);
    }
}
