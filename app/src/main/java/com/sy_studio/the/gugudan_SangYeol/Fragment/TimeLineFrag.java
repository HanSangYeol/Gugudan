package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.restfb.types.GraphResponse;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;

import org.json.JSONObject;

/**
 * Created by the on 2017-10-20.
 */

public class TimeLineFrag extends Fragment {

    AccessToken accessToken = AccessToken.getCurrentAccessToken();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_timeline, container, false);
        return view;

        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "feed.limit(7){picture,message}");
        request.setParameters(parameters);
        request.executeAsync();
    }
}
