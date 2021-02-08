package com.rtu.smartkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);
        TextView msg = (TextView)findViewById(R.id.msg);
        Button hi = (Button)findViewById(R.id.hi);
        Button en = (Button)findViewById(R.id.en);
        Button no =(Button)findViewById(R.id.number);
        Button w1=(Button)findViewById(R.id.wp);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "GoodUnicornRegular-Rxev.ttf");
        en.setTypeface(custom_font);
        msg.setTypeface(custom_font);
        no.setTypeface(custom_font);
        w1.setTypeface(custom_font);

        Typeface custom_font_hi = Typeface.createFromAsset(getAssets(), "GoodUnicornRegular-Rxev.ttf");
        hi.setTypeface(custom_font_hi);
        hi.setText("हिन्दी");

    }
    public void openWritepad(View v){

        Intent i = new Intent(MainActivity.this, DrawingActivity.class);
        startActivity(i);
    }
    public void openHindiCourse(View v){

        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        i.putExtra("Type","H");
        startActivity(i);
    }
    public void openEnglishCourse(View v){

        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        i.putExtra("Type","E");
        startActivity(i);
    }

    public void openNumberCourse(View v){

        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        i.putExtra("Type","N");
        startActivity(i);
    }
}