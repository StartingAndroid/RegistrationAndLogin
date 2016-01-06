package com.startingandroid.registrationandlogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreenActivity extends Activity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        session = new Session(SplashScreenActivity.this);
        new Handler().postDelayed(new Runnable() {

            @SuppressLint("PrivateResource")
            @Override
            public void run() {
                if (session.getLoggedIn()) {
                    Intent i = new Intent(SplashScreenActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashScreenActivity.this,
                            LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }

        }, 4000);
    }

}
