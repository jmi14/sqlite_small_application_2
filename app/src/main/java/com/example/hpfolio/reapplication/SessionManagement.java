package com.example.hpfolio.reapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by HP FOLIO on 12/8/2017.
 */

public class SessionManagement {

    Context context;
    SharedPreferences sharedPreferences;
    public SessionManagement(Context context) {

        this.context= context;
        sharedPreferences = context.getSharedPreferences("com.example.hpfolio.reapplication",Context.MODE_PRIVATE);

    }

    public void set_userLoggedIn(boolean isLoggedin){

        sharedPreferences.edit().putBoolean("isLoggedIn",isLoggedin).apply();

    }

    public boolean get_userLoggenIn(){

       boolean isUserLoggedIn =  sharedPreferences.getBoolean("isLoggedIn",false);

        return isUserLoggedIn;
    }

    public void set_userInformation(String name,String phone){

        sharedPreferences.edit().putString("user_name",name).apply();
        sharedPreferences.edit().putString("user_phone",phone).apply();



    }

    public ArrayList<String> get_userInformation(){

       String user_name = sharedPreferences.getString("user_name","");
       String user_phone = sharedPreferences.getString("user_phone","");

        ArrayList<String> userData = new ArrayList<>();
        userData.add(user_name);
        userData.add(user_phone);

        return userData;
    }
}
