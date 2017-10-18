package com.example.the.gugudan.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.example.the.gugudan.Data.User;

/**
 * Created by the on 2017-10-17.
 */

public class ContextUtil {

    private static User loginUser = null;
    private static final String prefName = "Gugudan";

    private static final String USER_ID = "USER_ID";

    public static void login(Context context, User loginUser){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putString(USER_ID, loginUser.getId()).commit();
    }


    public static void logout(Context context){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putString(USER_ID,"").apply();
    }

    public static User getLoginUserData(Context context){
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        if(pref.getString(USER_ID,"").equals("")){
            loginUser=null;
        }
        else{
            loginUser = new User();
            loginUser.setId(pref.getString(USER_ID,""));
        }
        return loginUser;

    }
}
