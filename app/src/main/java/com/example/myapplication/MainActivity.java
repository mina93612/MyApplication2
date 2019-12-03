package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edMonth = findViewById(R.id.month);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"OnStart");
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.


    public void calculation() {
        if (!TextUtils.isEmpty(edMonth.getText().toString())) {
            float degree = Float.parseFloat(edMonth.getText().toString());
            float money = 0;
            if (degree < 11) {
                money = 7.35f * degree;
            } else if (degree < 31) {
                money = 9.45f * degree - 21.0f;
            } else if (degree < 50) {
                money = 11.55f * degree - 84.0f;
            } else if (degree > 51) {
                money = 12.075f * degree - 110.25f;
            }
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.money), money);
            startActivity(intent);

//                           new AlertDialog.Builder(this)
//                               .setTitle("每月抄表費用")
//                               .setMessage("費用: " + money)
//                               .setPositiveButton("ok", null)
//                               .show();


        }
    }
}

     /*  if (!TextUtils.isEmpty(edNext.getText().toString())) {
            float degree = Float.parseFloat(edNext.getText().toString());
            float money = 0;
            if (degree < 21) {
                money = 7.35f * degree;
            } else if (degree < 61) {
                money = 9.45f * degree - 42.0f;
            } else if (degree < 100) {
                money = 11.55f * degree - 168.0f;
            } else if (degree > 101) {
                money = 12.075f * degree - 220.5f;
            }
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra(getString(R.string.money),money);
            startActivity(intent);
            /*
//            new AlertDialog.Builder(this)
//                    .setTitle("隔月抄表費用")
//                    .setMessage("費用: " + money)
//                    .setPositiveButton("ok", null)
//                    .show();
     }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
