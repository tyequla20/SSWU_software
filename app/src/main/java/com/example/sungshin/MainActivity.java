package com.example.sungshin;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    //private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mDrawerLayout;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);//자동의로 Toolbar 왼쪽에 버튼이 생성된다
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_manage);
        //버튼의 이미지를 생성 할 수 있다.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if (id == R.id.planAdd) {
                    Toast.makeText(context, title + ":일정추가 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.planCheck) {
                    Toast.makeText(context, title + ":일정확인 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.lectureEnroll) {
                    Toast.makeText(context, title + ":강의 등록 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.lectureSearch) {
                    Toast.makeText(context, title + ":강의 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.msg) {
                    Toast.makeText(context, title + ":메세지 연결 시도 중", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }

    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    /*
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                //.setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
*/
    //@Override
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
/*
switch (item.getItemId()) {
        case android.R.id.home: {
            finish();
            //mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
    }
    return super.onOptionsItemSelected(item);
}*/