package com.example.FedUniMillionaire30345643;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    private View nView;
    TextView username, challenge;
    TextView texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        nView = navigationView.getHeaderView(0);

        challenge=findViewById(R.id.Chalenge);
        texts=(TextView)findViewById(R.id.texts);

        String userName=getIntent().getStringExtra("name");
        username=nView.findViewById(R.id.username);
        username.setText(userName);

        texts.setText("Welcome Mr : "+ userName+ "\n"+" do you want start challenge ?");
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Challenge.class);
                intent.putExtra("name",userName);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(item1 -> {
                    int id = item1.getItemId();
                    if (id == R.id.scr) {
                        Intent intent = new Intent(MainActivity2.this, ScoreActivity.class);
                        intent.putExtra("from","hi");
                        startActivity(intent);
                    }
                    else if (id==R.id.sortD){
                        Intent intent = new Intent(MainActivity2.this, ScoreActivity.class);
                        intent.putExtra("from","sortD");
                        startActivity(intent);
                    }
                    else if (id==R.id.sortS){
                        Intent intent = new Intent(MainActivity2.this, ScoreActivity.class);
                        intent.putExtra("from","sortS");
                        startActivity(intent);
                    }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

}