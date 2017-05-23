package com.pooya11.quran_question;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ListView;

import static android.content.ContentValues.TAG;
import static com.pooya11.quran_question.DBHelper.number1;
import static com.pooya11.quran_question.DBHelper.number2;
import static com.pooya11.quran_question.DBHelper.number3;
import static com.pooya11.quran_question.DBHelper.number4;
import static com.pooya11.quran_question.DBHelper.questions;

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
        DBHelper db =new DBHelper(this);
        db.getData();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txt_question, questions);
        listView.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.radio_button_number_one, number1);
        listView.setAdapter(arrayAdapter1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.radio_button_number_two, number2);
        listView.setAdapter(arrayAdapter2);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.radio_button_number_three, number3);
        listView.setAdapter(arrayAdapter3);
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.radio_button_number_four, number4);
        listView.setAdapter(arrayAdapter4);
        }
        public static int[] mark(){
            int[] marks = new int[2];


            return marks;
        }

    }

