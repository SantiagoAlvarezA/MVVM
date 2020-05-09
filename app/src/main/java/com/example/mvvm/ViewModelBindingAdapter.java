package com.example.mvvm;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class ViewModelBindingAdapter {

    @BindingAdapter("visible")
    public static void setVisibility(View v, boolean visibility) {
        if (visibility)
            v.setVisibility(View.VISIBLE);
        else
            v.setVisibility(View.GONE);
    }

    @BindingAdapter({"visible", "size"})
    public static void setSize(TextView tv, boolean visibility, float size) {
        if (visibility)
            tv.setVisibility(View.VISIBLE);
        else
            tv.setVisibility(View.GONE);
        tv.setTextSize(size);
    }
}
