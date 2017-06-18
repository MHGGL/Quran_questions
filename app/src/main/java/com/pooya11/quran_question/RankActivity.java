package com.pooya11.quran_question;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class RankActivity extends Activity {
    TextView txt_name,txt_number_false,txt_number_true,txt_number_test;
    int[] marks;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        BarChart chart = (BarChart) findViewById(R.id.chart);
        txt_name = (TextView)findViewById(R.id.txt_name_test);
        txt_number_false = (TextView)findViewById(R.id.txt_number_false);
        txt_number_true = (TextView)findViewById(R.id.txt_number_true);
        txt_number_test = (TextView)findViewById(R.id.txt_number_test);
        show_mark();
        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;
        marks = QuestionsActivity.mark();
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

    public void framelayout_chart(View view) {
        startActivity(new Intent(this,chartActivity.class));
    }
    public void show_mark(){
        txt_number_test.setText("تعداد سوالات آرمون : 8");
        txt_number_false.setText(marks[0]+"تعداد جواب های غلط : ");
        txt_number_true.setText(marks[1]+"تعداد جواب های درست : ");
        txt_name.setText(ListTestActivity.NameTest+"نام آزمون : ");
    }

    public void share_mark(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody="به شما پیشنهاد می کنم که حتما این برنامه را دانلود کنید."+"\n"+marks[1]+"تعدا جواب های درست :"+"\n"+marks[0]+"تعداد جواب های غلط :"+"تعداد سوالات آزمون : 8\n"+"\n"+ListTestActivity.NameTest+"سلام دوستان \n من برنامه آزمونک قرآن پایه متوسطه را از بازار دانلود و آزمون دادم و نمره ام به شرح زیر شد:\nنام آزمون :";
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"نمره من در آزمونک قرآن پایه متوسطه");
        sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(sharingIntent,"اشتراک گذاری نمره با ..."));
    }

    public void back_to_home(View view) {
        marks[0]=0;
        marks[1]=0;
        startActivity(new Intent(this,MainActivity.class));
    }
}
