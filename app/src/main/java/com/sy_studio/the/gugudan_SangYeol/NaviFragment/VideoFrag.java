package com.sy_studio.the.gugudan_SangYeol.NaviFragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.sy_studio.the.gugudan_SangYeol.Data.VideoData;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.DrawableManager;
import com.sy_studio.the.gugudan_SangYeol.YoutubeActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by the on 2017-10-17.
 */

public class VideoFrag extends Fragment {

    private boolean interceptPlay = true;

    public static YouTubePlayer youtubePlayer;
    static DrawableManager DM = new DrawableManager();
    final String serverKey = "AIzaSyD-ie2ywfIybH6zkUAiFpTGvMrdLb_sTtQ";
    ArrayList<VideoData> sdata = new ArrayList<VideoData>();
    AsyncTask<?, ?, ?> Task;
    private ListView youtubeListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_video, container, false);
        this.youtubeListView = (ListView) view.findViewById(R.id.youtubeListView);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();


//        YouTubePlayerSupportFragment supportFragment =
//                (YouTubePlayerSupportFragment) (getChildFragmentManager().findFragmentById(R.id.youtubeFrag));
//        supportFragment.initialize(serverKey, new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
//                youtubePlayer = youTubePlayer;
//                youtubePlayer.cueVideo("ZN6aso7870c");
//
//
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        });


    }

    private void setValues() {
        Task = new Task().execute();


    }

    private class Task extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                paringJsonData(getUtube());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            ListView youtubeListView = (ListView) getActivity().findViewById(R.id.youtubeListView);

            YoutubeAdapter mAdapter = new YoutubeAdapter(getActivity(),
                    R.layout.youtube_list_item, sdata);

            youtubeListView.setAdapter(mAdapter);

        }
    }

    public JSONObject getUtube() {

        HttpGet httpGet = new HttpGet(
                "https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCAZrFlkKqpTqn8ZISJ616xg&key=" + serverKey
        );
        // part(snippet), q(검색값) , key(서버키)
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void paringJsonData(JSONObject jsonObject) throws JSONException {
        sdata.clear();

        JSONArray contacts = jsonObject.getJSONArray("items");

        for (int i = 0; i < contacts.length(); i++) {
            JSONObject c = contacts.getJSONObject(i);
            //String vodid = c.getJSONObject("id").getString("videoId");
            String title = c.getJSONObject("snippet").getString("title");
            String changString = "";
            try {
                changString = new String(title.getBytes("8859_1"), "utf-8");

            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String date = c.getJSONObject("snippet").getString("publishedAt") // 등록날짜
                    .substring(0, 10);
            String imgUrl = c.getJSONObject("snippet")
                    .getJSONObject("thumbnails").getJSONObject("default")
                    .getString("url"); // 썸내일 이미지 URL값

            Log.d("Youtube", "제목 : " + title);
            sdata.add(new VideoData("", changString, imgUrl, date));

        }
    }

    public class YoutubeAdapter extends ArrayAdapter<VideoData> {
        private ArrayList<VideoData> items;
        VideoData fInfo;

        public YoutubeAdapter(Context context, int textViewResourseId,
                              ArrayList<VideoData> items) {
            super(context, textViewResourseId, items);
            this.items = items;
        }

        public View getView(int position, View convertView, ViewGroup parent) {// listview

            // 출력
            View v = convertView;
            fInfo = items.get(position);

            LayoutInflater vi = (LayoutInflater) (getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE));

            v = vi.inflate(R.layout.youtube_list_item, null);
            ImageView img = (ImageView) v.findViewById(R.id.img);

            String url = fInfo.getUrl();

            String sUrl = "";
            String eUrl = "";
            sUrl = url.substring(0, url.lastIndexOf("/") + 1);
            eUrl = url.substring(url.lastIndexOf("/") + 1, url.length());
            try {
                eUrl = URLEncoder.encode(eUrl, "EUC-KR").replace("+", "%20");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String new_url = sUrl + eUrl;

            DM.fetchDrawableOnThread(new_url, img);  //비동기 이미지 로더

            v.setTag(position);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (Integer) v.getTag();

                    Intent intent = new Intent(getActivity(),
                            YoutubeActivity.class);
                    intent.putExtra("id", items.get(pos).getVideoId());
                    startActivity(intent);
                }
            });

            ((TextView) v.findViewById(R.id.title)).setText(fInfo.getTitle());
            ((TextView) v.findViewById(R.id.date)).setText(fInfo
                    .getPublishedAt());

            return v;
        }
    }


    private void setupEvents() {
    }

    private void bindView() {

    }


}
