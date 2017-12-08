package com.example.hpfolio.reapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivHomper;
    SessionManagement sessionManagement;
    boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sessionManagement = new SessionManagement(this);
        isLoggedIn = sessionManagement.get_userLoggenIn();

        ivHomper = (ImageView) findViewById(R.id.ivHomper);

        ivHomper.animate().alpha(0.1f).setDuration(3000);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isLoggedIn) {

                    Intent intent = new Intent(MainActivity.this, UserInformation.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, SignUp.class);
                    startActivity(intent);
                    finish();
                }
            }

        }, 3000);

    }
}
