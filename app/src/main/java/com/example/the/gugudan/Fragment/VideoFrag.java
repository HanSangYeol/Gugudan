package com.example.the.gugudan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.the.gugudan.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by the on 2017-10-17.
 */

public class VideoFrag extends Fragment {

    private YouTubePlayer youtubePlayer;
    final String serverKey = "AIzaSyCBz3h4zx5wLkUyMZGB-NiahwezMEH6Hs4";

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
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youtubePlayer = youTubePlayer;
                youtubePlayer.loadVideo("ZN6aso7870c");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
