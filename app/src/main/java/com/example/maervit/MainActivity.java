package com.example.maervit;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public  void Odfot (View v) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());


        setContentView(scannerView);
        scannerView.startCamera();



    }

    @Override
    public void onPause(){
        super.onPause();
        scannerView.startCamera();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(com.google.zxing.Result result) {
            String resultCodeString = result.getText();
            long resultCode = Long.parseLong(resultCodeString);
            long liner = 884851041913L;
            if (resultCode == liner){
                Toast.makeText(MainActivity.this, "prave si naskenoval liner", Toast.LENGTH_LONG).show();
                openMainActivity2();
            }else{
                Toast.makeText(MainActivity.this, "neurcene", Toast.LENGTH_SHORT).show();
            }


            setContentView(R.layout.activity_main);
            scannerView.stopCamera();
        }
    }
    public void openMainActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent );
    }
}
