package com.jugal.rest_a_sure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv) ;
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        iv.startAnimation(myanim);
        final Intent i = new Intent(this, signup_ui.class);
        Thread timer =new Thread() {
            public void run () {
                try {
                    sleep(800);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                        startActivity(i);
                        finish();
                }
            }
        };
                timer.start();
    }
}
