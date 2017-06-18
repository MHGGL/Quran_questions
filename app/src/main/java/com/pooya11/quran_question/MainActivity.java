package com.pooya11.quran_question;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.drm.DrmStore;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;

import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    View views;
    float aFloat=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn_my_marks);
        Button btn2 = (Button)findViewById(R.id.btn_developer);
        Button btn3 = (Button)findViewById(R.id.btn_tests);
        Button btn4 = (Button)findViewById(R.id.btn_exit);
        Animation animation
                = AnimationUtils.loadAnimation(this, R.anim.animation);
        Animation animation2
                = AnimationUtils.loadAnimation(this, R.anim.animation_back);
        btn.startAnimation(animation);
        btn2.startAnimation(animation2);
        btn3.startAnimation(animation);
        btn4.startAnimation(animation2);
        DataAdd_Get dataAdd_get = new DataAdd_Get(this);
        dataAdd_get.createRow();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        views = findViewById(R.id.coor);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    DrawerLayout drawer;
    @Override
    public void onBackPressed() {
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("خروج")
                    .setMessage("آیا برای خارج شدن از برنامه مطمئنید؟")
                    .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    }).setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(1);
                }
            }).show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_my) {

        }else if(id == R.id.nav_rating){

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.RIGHT);
        return true;
    }

    public void btn_tests(View view) {
        startActivity(new Intent(MainActivity.this,ListTestActivity.class));
    }

    public void btn_developer(View view) {
    }

    public void btn_my_marks(View view) {
    }

    public void btn_exit(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }).start();
    }

    public void btn_open_nav(View view) {
        DrawerLayout drawers = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawers.openDrawer(Gravity.RIGHT,true);
    }

}
