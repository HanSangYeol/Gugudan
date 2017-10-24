package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sy_studio.the.gugudan_SangYeol.Data.VideoData;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.sy_studio.the.gugudan_SangYeol.Util.DrawableManager;

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
    AsyncTask<?, ?, ?> searchTask;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_video, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        YouTubePlayerSupportFragment supportFragment =
                (YouTubePlayerSupportFragment) (getChildFragmentManager().findFragmentById(R.id.youtubeFrag));
        supportFragment.initialize(serverKey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                youtubePlayer = youTubePlayer;
                youtubePlayer.cueVideo("ZN6aso7870c");
//                youtubePlayer.cuePlaylist("PLieD_nuzcjSc6iAjo06fX2zFIQX8GLVQO");


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


    }


}
