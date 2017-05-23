package com.pooya11.quran_question;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class chartActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        BarChart chart = (BarChart) findViewById(R.id.horizontalBarChart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;
        int[] marks = QuestionsActivity.mark();
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(Integer.parseInt(String.valueOf(marks[0])+"f"), 0);
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(Integer.parseInt(String.valueOf(marks[1])+"f"), 1);
        valueSet1.add(v1e2);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "غلط ها");
        barDataSet1.setColor(getColor(R.color.colorRed));
        BarDataSet barDataSet2 = new BarDataSet(valueSet1, "درست ها");
        barDataSet2.setColor(getColor(R.color.colorBlue));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("تعداد غلظ");
        xAxis.add("تعداد درست");
        return xAxis;
    }
}
