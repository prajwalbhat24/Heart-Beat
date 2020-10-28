package com.example.heart_beat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Vibrator vibe ;
    CountDownTimer countDownTimer,countDownTimer1;
    Integer i=0;

    String link1="file:android_asset/beats.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        webView = (WebView)findViewById(R.id.webView);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(link1);

        countDownTimer1 = new CountDownTimer(3000, 1000) {
            @Override

            public void onTick(long millisUntilFinished) {


            }

            @Override
            public void onFinish() {
                countDownTimer1.cancel();
                startBeats();

            }
        }.start();




    }

    public void startBeats()
    {
        countDownTimer = new CountDownTimer(1000000, 215) {
            @Override

            public void onTick(long millisUntilFinished) {

                    i++;
                    if (i==1)
                    {
                        vibe.vibrate(13);
                    }
                   else if (i==2)
                    {
                        vibe.vibrate(13);
                    }


                    else if (i==10)
                    {
                        i=0;
                    }


            }

            @Override
            public void onFinish() {
                startBeats();

            }
        }.start();
    }
}