package com.sy_studio.the.gugudan_SangYeol.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.sy_studio.the.gugudan_SangYeol.Data.TimeLine;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by the on 2017-09-07.
 */

public class ServerUtil {
    private static final String TAG = ServerUtil.class.getSimpleName();
    private final static String BASE_URL = "http://192.168.20.78:8080/";


    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    // 페이스북 페이지 이미지 가져오기
    public static void get_facebook_img(final Context context, final String id, final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url = "https://graph.facebook.com/v2.10/" + id + "?fields=attachments&fields=attachments&access_token=" + ContextUtil.access_token;

        Log.d("url", url);

        AsyncHttpRequest.get(context, url, null, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    // 페이스북 페이지 게시글 가져오기
    public static void get_facebook_data(final Context context, final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url = "https://graph.facebook.com/v2.10/245682955804231/feed?access_token=" + ContextUtil.access_token;


        AsyncHttpRequest.get(context, url, null, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    public static void FacebookAccessToken(final Context context, final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url = "https://graph.facebook.com/oauth/access_token?client_id=503180196705632&client_secret=b2a05f31702a97e9685529300b5f9c71&grant_type=client_credentials";

        AsyncHttpRequest.get(context, url, null, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    // 로그인
    public static void sign_in(final Context context, String id, String pw, final JsonResponseHandler handler) {
        String url = BASE_URL + "mobile/get_login";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("login_id", id);
        data.put("pw", pw);

        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    // 회원 가입 기능
    public static void sign_up(final Context context, final String id,
                               final String pw,
                               final String name, final JsonResponseHandler handler) {
        String url = BASE_URL + "mobile/insert_sign_up";

        Map<String, String> data = new HashMap<String, String>();
        data.put("login_id", id);
        data.put("pw", pw);
        data.put("name", name);
        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    // 게시글목록불러오기
    public static void get_all_postings(final Context context, final JsonResponseHandler handler) {
        String url = BASE_URL + "mobile/get_all_postings";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();

        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    // 게시글 올리기
    public static void write_posting(final Context context,
                                     final String title,
                                     final String content,
                                     final int user_id,
                                     final JsonResponseHandler handler) {
        String url = BASE_URL + "mobile/write_posting";


        Map<String, String> data = new HashMap<String, String>();
        data.put("title", title);
        data.put("content", content);
        data.put("user_id", user_id + "");

        AsyncHttpRequest.post(context, url, data, true, new AsyncHttpRequest.HttpResponseHandler() {
            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

}
