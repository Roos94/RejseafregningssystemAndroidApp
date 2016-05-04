package com.dtu.smmac.rejseafregningssystem.Activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

import com.dtu.smmac.rejseafregningssystem.Logic.API;
import com.dtu.smmac.rejseafregningssystem.R;

/**
 * Created by Roos on 04/05/16.
 */
public class Splash extends Activity {

    private ImageView img;
    private TextView titel, lille;
    private Intent i;
    private Thread timer;
    private Runnable r, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27;
    private int sleep;
    private MediaPlayer airplane;
    public static API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.i = new Intent(this, Login.class);

        this.img = (ImageView) findViewById(R.id.imageSplash);
        this.img.setImageResource(R.drawable.splash);

        this.titel = (TextView) findViewById(R.id.textSplah);
        this.titel.setText(R.string.app_name);

        this.lille = (TextView) findViewById(R.id.lilleSplash);
        this.lille.setText("Made by: SMMAC");

        this.sleep = 150;

        this.airplane = MediaPlayer.create(this, R.raw.airplane);
        this.airplane.start();

        setRunable();

        this.timer = new Thread(this.r);

        api = new API();

        this.timer.start();
    }

    public void setRunable()
    {
        this.r = new Runnable() {
            public void run() {
                setTimer();
            }
        };

        this.l1 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash2);
            }
        };

        this.l2 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash3);
            }
        };

        this.l3 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash4);
            }
        };

        this.l4 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash5);
            }
        };

        this.l5 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash6);
            }
        };

        this.l6 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash7);
            }
        };

        this.l7 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash8);
            }
        };

        this.l8 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash9);
            }
        };

        this.l9 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash10);
            }
        };

        this.l10 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash11);
            }
        };

        this.l11 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash12);
            }
        };

        this.l12 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash13);
            }
        };

        this.l13 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash14);
            }
        };

        this.l14 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash15);
            }
        };

        this.l15 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash16);
            }
        };

        this.l16 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash17);
            }
        };

        this.l17 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash18);
            }
        };

        this.l18 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash19);
            }
        };

        this.l19 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash20);
            }
        };

        this.l20 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash21);
            }
        };

        this.l21 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash22);
            }
        };

        this.l22 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash23);
            }
        };

        this.l23 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash24);
            }
        };

        this.l24 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash25);
            }
        };

        this.l25 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash26);
            }
        };

        this.l26 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash27);
            }
        };

        this.l27 = new Runnable() {
            public void run() {
                img.setImageResource(R.drawable.splash);
            }
        };
    }

    public void setTimer() {
        SystemClock.sleep(1000);

        runOnUiThread(this.l1);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l2);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l3);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l4);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l5);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l6);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l7);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l8);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l9);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l10);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l11);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l12);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l13);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l14);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l15);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l16);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l17);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l18);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l19);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l20);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l21);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l22);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l23);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l24);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l25);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l26);
        SystemClock.sleep(sleep);

        runOnUiThread(this.l27);
        SystemClock.sleep(sleep);

        startActivity(i);
        finish();
    }
}
