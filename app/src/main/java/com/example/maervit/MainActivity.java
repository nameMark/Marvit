package com.example.maervit;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {

    boolean shouldStart =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler handler = new Handler();

        handler.postDelayed(run,1500);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            if(shouldStart = true) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }
    };

    @Override
    protected void onPause() {
        shouldStart = false;
        super.onPause();
        this.finish();
    }
}




