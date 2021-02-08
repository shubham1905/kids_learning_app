package com.rtu.smartkids;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.rtu.smartkids.draw.DrawingView;


public class DrawingActivity extends AppCompatActivity {
    DrawingView mDrawingView;
    private int mCurrentBackgroundColor;
    private int mCurrentColor;
    private int mCurrentStroke;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        mDrawingView = (DrawingView)findViewById(R.id.main_drawing_view);
                initDrawingView();

    }


    private void initDrawingView()
    {
        mCurrentBackgroundColor = ContextCompat.getColor(this, android.R.color.white);
        mCurrentColor = ContextCompat.getColor(this, android.R.color.black);
        mCurrentStroke = 10;

        mDrawingView.setBackgroundColor(mCurrentBackgroundColor);
        mDrawingView.setPaintColor(mCurrentColor);
        mDrawingView.setPaintStrokeWidth(mCurrentStroke);
    }

    public void clear(View v){
        mDrawingView.clearCanvas();
    }
    public void undo(View v){
        mDrawingView.undo();
    }
    public void redo(View v){
        mDrawingView.redo();
    }
}