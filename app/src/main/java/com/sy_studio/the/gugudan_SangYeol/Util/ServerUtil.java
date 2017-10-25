package com.sy_studio.the.gugudan_SangYeol.Util;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by the on 2017-09-07.
 */

public class ServerUtil {
    private static final String TAG = ServerUtil.class.getSimpleName();
    private final static String BASE_URL = "http://13.124.240.139/";


    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    // 페이스북 페이지 이미지 가져오기
    public static void get_facebook_img(final Context context, final int id , final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url =  "https://graph.facebook.com/v2.2/"+id+"?fields=attachments&fields=attachments&access_token="+ContextUtil.access_token;

//        기능을 사용하기 위해 필요한 데이터를 담는 부분.

//        Map<String, String> data = new HashMap<String, String>();
////        data.put("version", "1");
////        data.put("lat", "37.610465");
//        data.put("lon", "126.928954");

        AsyncHttpRequest.get(context, url,  null, true, new AsyncHttpRequest.HttpResponseHandler() {

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
    public static void get_facebook_data(final Context context,  final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url =  "https://graph.facebook.com/v2.10/245682955804231/feed?access_token=503180196705632%7CcAxq4j6NWTm2f4St3r-kyDg3EDQ";

//        기능을 사용하기 위해 필요한 데이터를 담는 부분.

//        Map<String, String> data = new HashMap<String, String>();
////        data.put("version", "1");
////        data.put("lat", "37.610465");
//        data.put("lon", "126.928954");

        AsyncHttpRequest.get(context, url,  null, true, new AsyncHttpRequest.HttpResponseHandler() {

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


    public static void FacebookAccessToken(final Context context,  final JsonResponseHandler handler) {
//        기능에 따라 매번 주소를 다르게 적어줘야함.
        String url =  "https://graph.facebook.com/oauth/access_token?client_id=503180196705632&client_secret=b2a05f31702a97e9685529300b5f9c71&grant_type=client_credentials";

//        기능을 사용하기 위해 필요한 데이터를 담는 부분.

//        Map<String, String> data = new HashMap<String, String>();
////        data.put("version", "1");
////        data.put("lat", "37.610465");
//        data.put("lon", "126.928954");

        AsyncHttpRequest.get(context, url,  null, true, new AsyncHttpRequest.HttpResponseHandler() {

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
        String url = BASE_URL + "insta/sign_in";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("userId", id);
        data.put("password", pw);

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
                               final String name, final String nickname, final String profileImgUrl,
                               final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/sign_up";


        Map<String, String> data = new HashMap<String, String>();
        data.put("userId", id);
        data.put("password", pw);
        data.put("name", name);
        data.put("nickname", nickname);
        data.put("profileImgURL", profileImgUrl);
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


    // 포스팅목록불러오기
    public static void get_all_postings(final Context context, final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/get_all_postings";
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

    // 이미지 올리기
    public static void makePosting(final Context context, final int id,
                                   final String content,
                                   Bitmap bitmap,
                                   final JsonResponseHandler handler) {
        String url = BASE_URL + "insta/make_posting";


        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id", id+"");
        data.put("content", content);
        AsyncHttpRequest.postWithImageFile(context, url, data, bitmap, "post", new AsyncHttpRequest.HttpResponseHandler() {

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
