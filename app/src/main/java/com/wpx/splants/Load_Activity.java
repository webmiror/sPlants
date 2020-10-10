package com.wpx.splants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;



public class Load_Activity extends Activity {
    private Animation logoAnim;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        image = findViewById(R.id.logoFirst);
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        image.startAnimation(logoAnim);
        startMain();

    }

    private void startMain() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Log.d("Load_Activity", "run: 11");
                Intent i = new Intent(Load_Activity.this, MainActivity.class);
                startActivity(i);
            }
        }).start();
    }
}
