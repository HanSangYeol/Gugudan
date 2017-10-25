package com.sy_studio.the.gugudan_SangYeol.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.sy_studio.the.gugudan_SangYeol.Data.User;

/**
 * Created by the on 2017-10-17.
 */

public class ContextUtil {

    public static String access_token;

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
