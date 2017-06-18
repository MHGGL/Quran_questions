package com.pooya11.quran_question;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class ListTestActivity extends AppCompatActivity {
    public static int NumberTest;
    public static String NameTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);

    }

    public void btn_back_activity(View view) {
        finish();
    }

    public void btn_seven(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,new SevenFragment())
                .commit();
    }

    public void btn_eight(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,new EightFragment())
                .commit();
    }

    public void btn_nine(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,new NineFragment())
                .commit();
    }
}
