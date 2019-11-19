package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float money =getIntent().getFloatExtra("MONEY",-1);
        Log.d("ResultActivity",money+"");
        TextView feeText = findViewById(R.id.money);
        int n = (int)(money+0.5f);
        feeText.setText(n+"");
    }
}
