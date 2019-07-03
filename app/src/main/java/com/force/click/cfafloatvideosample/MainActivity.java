package com.force.click.cfafloatvideosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.AdFloatVideo;
import com.clickforce.ad.Listener.AdFloatVideoListener;

public class MainActivity extends AppCompatActivity {
    private String TAG = "ClickForce";
    private AdFloatVideo floatVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatVideo = (AdFloatVideo) this.findViewById(R.id.floatvideoAd);
        floatVideo.init(this);
        floatVideo.getAdFloatVideo(9694);
        floatVideo.outputDebugInfo = true;
        floatVideo.setOnAdFloatViewListener(new AdFloatVideoListener() {
            @Override
            public void onSuccessToAdFloatVideo() {
                Log.d(TAG,"onSuccessToAdFloatVideo");
                floatVideo.show();
            }

            @Override
            public void onFailToAdFloatVideo() {
                Log.d(TAG,"onFailToAdFloatVideo");
            }

            @Override
            public void onClickToAdFloatVideo() {
                Log.d(TAG,"onClickToAdFloatVideo");
            }

            @Override
            public void onCloseToAdFloatVideo() {
                Log.d(TAG,"onCloseToAdFloatVideo");
            }

            @Override
            public void onFloatVideoEnd() {
                Log.d(TAG,"onFloatVideoEnd");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (floatVideo != null){
            floatVideo.releaseAd();
        }
    }
}
