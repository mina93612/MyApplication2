package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_FEE = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float money =getIntent().getFloatExtra(getString(R.string.money) ,DEFAULT_FEE);
        Log.d(TAG,money+" ");
     //   Log.d("ResultActivity",money+"");
        TextView feeText = findViewById(R.id.money);
        int n = (int)(money+0.5f);
        feeText.setText(n+"");
    }
}
