package com.pooya11.quran_question;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EightFragment extends Fragment {


    public EightFragment() {
        // Required empty public constructor
    }
    Button one,two,three,four,five;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eight, container, false);
        one = (Button)view.findViewById(R.id.btn_eight_one);
        two = (Button)view.findViewById(R.id.btn_eight_two);
        three = (Button)view.findViewById(R.id.btn_eight_three);
        four = (Button)view.findViewById(R.id.btn_eight_four);
        five = (Button)view.findViewById(R.id.btn_eight_five);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListTestActivity.NumberTest = 1;
                ListTestActivity.NameTest = "EightFragment";
                startActivity(new Intent(getContext(),QuestionsActivity.class));
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListTestActivity.NumberTest=2;
                ListTestActivity.NameTest = "EightFragment";
                startActivity(new Intent(getContext(),QuestionsActivity.class));
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListTestActivity.NumberTest=3;
                ListTestActivity.NameTest = "EightFragment";
                startActivity(new Intent(getContext(),QuestionsActivity.class));
            }
        })
        ;
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListTestActivity.NumberTest=4;
                ListTestActivity.NameTest = "EightFragment";
                startActivity(new Intent(getContext(),QuestionsActivity.class));
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListTestActivity.NumberTest=5;
                ListTestActivity.NameTest = "EightFragment";
                startActivity(new Intent(getContext(),QuestionsActivity.class));
            }
        });

        return view;
    }

}
