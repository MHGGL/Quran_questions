package com.pooya11.quran_question;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by acer on 5/10/2017.
 */


public class DBHelper{
    private Context context;
    public static SQLiteOpenHelper sqLiteOpenHelper;
    public DBHelper(){
        //constructor default
    }

    public DBHelper(Context context) {
        this.context = context;
        sqLiteOpenHelper = new SQLiteOpenHelper(context, "Questions", null, 1) {

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE SevenFragment(id INTEGER AUTO INCREMENT," +
                        " number_test INTEGER," +
                        " question TEXT, number_one TEXT," +
                        " number_two TEXT," +
                        " number_three TEXT," +
                        " number_four TEXT,"+
                        " number_true TEXT)");

                db.execSQL("CREATE TABLE EightFragment(id INTEGER AUTO INCREMENT," +
                        " number_test VARCHAR(255)," +
                        " question TEXT, number_one TEXT," +
                        " number_two TEXT," +
                        " number_three TEXT," +
                        " number_four TEXT,"+
                        " number_true TEXT)");

                db.execSQL("CREATE TABLE NineFragment(id INTEGER AUTO INCREMENT," +
                        " number_test VARCHAR(255)," +
                        " question TEXT, number_one TEXT," +
                        " number_two TEXT," +
                        " number_three TEXT," +
                        " number_four TEXT,"+
                        " number_true TEXT)");
                save_seven();
                save_eight();
                save_nine();
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            }
        };


        /**

         */
    }




    ContentValues contentValues;

    public void save_seven(){
        SQLiteDatabase sqLiteDatabasert = null;
        String [] Question = {"1- در عصر غیبت باید از چه کسانی پیروی کنیم؟",
        "2- وظایف منتظران از بیان امام رضا علیه السلام در کدام گزینه آمده است؟",
        "3- آبی که صاحب آن راضی نباشد وما از آن استفاده کنیم.............است",
        "4- یاران نزدیک امام زمان (عج) ..............",
        "5-(رسولان الهی با آوردن دلائل محکم مشرکین را به تفکر دعوت کرده واز پیروی از خرافات نهی می کردند) این\n" +
                "مطلب کدام ویژگی پیامبران را بیان می کند؟",
        "6- آب پاک در اختیار نداریم وبا گلاب وضو می گیریم .وضوی ما...............چون................",
        "7- آیه شریفه «ألا بذِکرِ اللهِ تطمئنُ القلوب» بیانگر کدام اثر از اثرات ایمان می باشد؟",
        "8- بیدارگر قرن لقب گدام بزرگوار است؟"};
        String [] number_one = {"الف) بزرگان دین",
        "الف) صبور بودن",
        "الف) مباح",
        "الف) 310 نفرند",
        "الف) استقامت و پایداری در راه خدا",
        "الف)باطل است – آّب مضاف است",
        "الف) رهایی از احساس بیهودگی",
        "الف) امام علی علیه السلام"};
        String [] number_two = {"",
        "ب) روحانیون با تقوی",
        "ب) خوش رفتاری",
        "ب) مضاف",
        "ب) 313 نفرند",
        "ب)پیروی نکردن از عقاید باطل",
        "ب) صحیح است - آّب مضاف نیست",
        "ب) توکل به خدا و دل بستن به او"};
        String [] number_three = {"ج) دانشمندان دینی",
        "ج) ترویج کارنیک",
        "ج) غصبی",
        "ج) تعدادشان مشخص نیست",
        "ج) تسلیم در برابر خدا",
        "ج) صحیح است- چون مجبوریم",
        "ج) دست یافتن به آرامش",
        "ج) امام حسین علیه السلام"};
        String [] number_four = {"د) فقیهان",
        "د) تمامی موارد",
        "د) مطلق",
        "د) 131 نفرند",
        "د) باور به سخنان خدا",
        "د) باطل است – آّ ب مطلق است",
        "د) رسیدن به لذت های دنیا",
        "د) امام خمینی"};
        try {
            sqLiteDatabasert = sqLiteOpenHelper.getWritableDatabase();
            for (int i = 0; i < 8; i++) {
                contentValues.put("question", Question[i]);
                contentValues.put("number_test", 1);
                contentValues.put("number_one", number_one[i]);
                contentValues.put("number_two", number_two[i]);
                contentValues.put("number_three", number_three[i]);
                contentValues.put("number_four", number_four[i]);
                sqLiteDatabasert.insert("seven_class", null, contentValues);
            }
        }finally {
            if (sqLiteDatabasert != null && sqLiteDatabasert.isOpen()) {
                sqLiteDatabasert.close();
            }
        }
    }





    ContentValues contentValues2;
    SQLiteDatabase sqLiteDatabase2 =null;
    public void save_eight(){

        String [] Question2 = {};
        String [] number_one2 = {};
        String [] number_two2 = {};
        String [] number_three2 = {};
        String [] number_four2 = {};
        try {
            sqLiteDatabase2 = sqLiteOpenHelper.getWritableDatabase();
            for (int i = 0; i < 8 ; i++) {
                contentValues2.put("question", Question2[i]);
                contentValues2.put("number_test", 1);
                contentValues2.put("number_one", number_one2[i]);
                contentValues2.put("number_two", number_two2[i]);
                contentValues2.put("number_three", number_three2[i]);
                contentValues2.put("number_four", number_four2[i]);
                sqLiteDatabase2.insert("eight_class", null, contentValues2);
            }
        }finally {
            if (sqLiteDatabase2 != null && sqLiteDatabase2.isOpen()) {
                sqLiteDatabase2.close();
            }
        }
    }






    ContentValues contentValues3;
    SQLiteDatabase sqLiteDatabase3 = null;
    public void save_nine(){

        String [] Question3 = {};
        String [] number_one3 = {};
        String [] number_two3 = {};
        String [] number_three3 = {};
        String [] number_four3 = {};
        try {
            sqLiteDatabase3 = sqLiteOpenHelper.getWritableDatabase();
            for (int i = 0; i < 8; i++) {
                contentValues3.put("question", Question3[i]);
                contentValues3.put("number_test", 1);
                contentValues3.put("number_one", number_one3[i]);
                contentValues3.put("number_two", number_two3[i]);
                contentValues3.put("number_three", number_three3[i]);
                contentValues3.put("number_four", number_four3[i]);
                sqLiteDatabase3.insert("eight_class", null, contentValues3);
            }
        }finally {
            if (sqLiteDatabase3 != null && sqLiteDatabase3.isOpen()) {
                sqLiteDatabase3.close();
            }
        }
    }
    static SQLiteDatabase sqLiteDatabasetv =null;
    public static String[]questions = new String[8];
    public static String[]number1 = new String[8];
    public static String[]number2 = new String[8];
    public static String[]number3 = new String[8];
    public static String[]number4 = new String[8];
    public static String[]number_true = new String[8];
    public static void getData(){
        sqLiteDatabasetv = sqLiteOpenHelper.getReadableDatabase();
        Log.e("errrtr", "onCreate:2er2er2er2 ");
        Cursor resultSet = sqLiteDatabasetv.rawQuery("Select question , number_one , number_two , number_three , number_four , number_true from "+ListTestActivity.NameTest+" where number_test = "+
                ListTestActivity.NumberTest,null);
        resultSet.moveToFirst();
        int count=0;
        while(count < 8){
            questions[count]=resultSet.getString(resultSet.getColumnIndex("question"));
            number1[count]=resultSet.getString(resultSet.getColumnIndex("number_one"));
            number2[count]=resultSet.getString(resultSet.getColumnIndex("number_two"));
            number3[count]=resultSet.getString(resultSet.getColumnIndex("number_three"));
            number4[count]=resultSet.getString(resultSet.getColumnIndex("number_four"));
            number_true[count]=resultSet.getString(resultSet.getColumnIndex("number_true"));
            count++;
        }
        resultSet.close();
    }

}
