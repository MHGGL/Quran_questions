package com.pooya11.quran_question;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.id.list;
import static android.content.ContentValues.TAG;
import static com.pooya11.quran_question.DataAdd_Get.number1;
import static com.pooya11.quran_question.DataAdd_Get.number2;
import static com.pooya11.quran_question.DataAdd_Get.number3;
import static com.pooya11.quran_question.DataAdd_Get.number4;
import static com.pooya11.quran_question.DataAdd_Get.number_true;
import static com.pooya11.quran_question.DataAdd_Get.questions;

public class QuestionsActivity extends Activity {
    Chronometer chor;
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
         chor = (Chronometer)findViewById(R.id.chronometer5);
             new CountDownTimer(600000,0) {
            @Override
            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished/1000;
                chor.setText(String.valueOf(time));

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),RankActivity.class));
            }
        }.start();
        listView =(ListView)findViewById(R.id.list_view);
        listView.setBackgroundResource(R.drawable.item_list);
        DataAdd_Get dataAdd_get = new DataAdd_Get(this);
        dataAdd_get.getData();
        CustomAdapter adapter = new
                CustomAdapter(QuestionsActivity.this, questions, number1,number2,number3,number4);
        listView.setAdapter(adapter);
        }
        public static int[] mark(){
                int[] marks = new int[2];


            return marks;
        }

    }

