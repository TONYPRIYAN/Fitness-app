package com.example.shapeshift;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import android.widget.ProgressBar;

public class introp extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView textview;
    private float from;
    private float to;

    public introp(Context context,ProgressBar progressBar,TextView textView,float from,float to)
    {
        this.context = context;
        this.progressBar = progressBar;
        this.textview = textView;
        this.from = from;
        this.to = to;

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int)value);
        textview.setText((int)value + "%");

        if(value == to)
        {
            context.startActivity(new Intent(context, Login.class));
        }

    }
}