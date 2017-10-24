package com.sy_studio.the.gugudan_SangYeol;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;


public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    Context mContext;


    private YouTubePlayerView ytpv;
    private YouTubePlayer ytp;
    final String serverKey = "AIzaSyD-ie2ywfIybH6zkUAiFpTGvMrdLb_sTtQ";
    private YouTubePlayerView youtubeplayer;
    private android.widget.EditText eturl;
    private android.widget.Button search;
    private android.widget.ListView searchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ytpv = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
        ytpv.initialize(serverKey, this);


    }

    @Override
    public void onInitializationFailure(
            com.google.android.youtube.player.YouTubePlayer.Provider arg0,
            YouTubeInitializationResult arg1) {
        Toast.makeText(this, "Initialization Fail", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onInitializationSuccess(
            com.google.android.youtube.player.YouTubePlayer.Provider arg0,
            YouTubePlayer arg1, boolean arg2) {
        ytp = arg1;

        Intent gt = getIntent();
        ytp.loadVideo(gt.getStringExtra("id"));

    }

}
