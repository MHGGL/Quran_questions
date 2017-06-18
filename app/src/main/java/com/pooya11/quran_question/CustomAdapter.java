package com.pooya11.quran_question;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by acer on 6/14/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private final String[] questions;
    private final Activity context;
    private final String[] number1;
    private final String[] number2;
    private final String[] number3;
    private final String[] number4;


    public CustomAdapter(Activity contexts,
                      String[] questions, String[]number1s,String[]number2s,String[]number3s,String[]number4s) {
        super(contexts , R.layout.list_item, questions);
        this.context = contexts;
        this.questions = questions;
        this.number1 = number1s;
        this.number2 = number2s;
        this.number3 = number3s;
        this.number4 = number4s;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt_question);
        RadioButton radioButton1 = (RadioButton) rowView.findViewById(R.id.radio_button_number_one);
        RadioButton radioButton2 = (RadioButton) rowView.findViewById(R.id.radio_button_number_two);
        RadioButton radioButton3 = (RadioButton) rowView.findViewById(R.id.radio_button_number_three);
        RadioButton radioButton4 = (RadioButton) rowView.findViewById(R.id.radio_button_number_four);
        txtTitle.setText(questions[position]);
        radioButton1.setText(number1[position]);
        radioButton2.setText(number2[position]);
        radioButton3.setText(number3[position]);
        radioButton4.setText(number4[position]);
        return rowView;
    }
}
