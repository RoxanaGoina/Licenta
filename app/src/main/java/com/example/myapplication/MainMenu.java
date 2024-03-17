package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainMenu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    ImageView imageView;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
//        ActionBar actionBar = getSupportActionBar();
        int backgroundColor = ContextCompat.getColor(this, R.color.white);
        int colorBlack = ContextCompat.getColor(this, R.color.black);
       // navigationView.setItemIconTintList(ColorStateList.valueOf(colorBlack));



//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        imageView=findViewById(R.id.imageMenu);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
      //  this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // this.getSupportActionBar().setHomeButtonEnabled(true);
        navigationView.setBackgroundColor(backgroundColor);
      //  navigationView.setItemTextColor(backgroundColor);
         navigationView.setItemIconTintList(ColorStateList.valueOf(colorBlack));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.account)
                {
                  //  Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, MyAccountActivity.class));
                }
                if (item.getItemId()==R.id.tests)
                {
                    //Toast.makeText(MainMenu.this, "Test" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, TestsActivity.class));

                }
                if(item.getItemId()==R.id.diary){
                    startActivity(new Intent(MainMenu.this, Diary_Activity.class));

                }
                if (item.getItemId()==R.id.report)
                {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, ReportActivity.class));

                }
                if (item.getItemId()==R.id.historic)
                {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, HistoricActivity.class));

                }
//                if (item.getItemId()==R.id.news)
//                {
//                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainMenu.this, NewsActivity.class));
//
//                }
                if (item.getItemId()==R.id.result)
                {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, ResultActivity.class));

                }

                if (item.getItemId()==R.id.appoitnemet)
                {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, AppointnementActivity.class));

                }
                if (item.getItemId()==R.id.logout)
                {
                    //Toast.makeText(MainMenu.this, "Account selected" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainMenu.this, LoginActivity.class));

                }
                return false;
            }
        });
    }
        @Override
        public void onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);

            } else
                super.onBackPressed();
        }


    }
