package com.iitdh.sonusourav.instigo.Council;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.iitdh.sonusourav.instigo.Complaints.ComplainStatus;
import com.iitdh.sonusourav.instigo.Complaints.ComplaintsActivity;
import com.iitdh.sonusourav.instigo.HomeActivity;
import com.iitdh.sonusourav.instigo.R;
import com.iitdh.sonusourav.instigo.Utils.CommonFunctions;

import java.util.ArrayList;
import java.util.Objects;


public class CouncilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private CouncilRecyclerAdapter recyclerAdapter;
    private int numberOfColumns = 2;
    ArrayList<String> mCouncilName;
    ArrayList<Integer> mCouncilImage;

    private Integer[] imageId = {
            R.drawable.hostel_warden,
            R.drawable.meeting,
            R.drawable.sports,
            R.drawable.office_worker,
            R.drawable.food,
            R.drawable.boy,
            R.drawable.sport_junior,
            R.drawable.music_girl,
            R.drawable.emergency_call
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.include_council).setVisibility(View.VISIBLE);


        CommonFunctions.setUser(this);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        initCommitteeName();
        initArrayImage();


        recyclerView = findViewById(R.id.recycler_view_council);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerAdapter = new CouncilRecyclerAdapter(mCouncilName, mCouncilImage);
        recyclerView.setAdapter(recyclerAdapter);



    }

    private void initCommitteeName() {
        mCouncilName = new ArrayList<>();
        mCouncilName.add("Hostel Warden");
        mCouncilName.add("General Secretary");
        mCouncilName.add("Sports Secretary");
        mCouncilName.add("Hostel Secretary");
        mCouncilName.add("Mess Committee");
        mCouncilName.add("Junior Hostel Secretary");
        mCouncilName.add("Junior Sports Secretary");
        mCouncilName.add("Cultural Secretary");
        mCouncilName.add("Maintenance");
    }

    private void initArrayImage(){
        mCouncilImage = new ArrayList<Integer>();
        mCouncilImage.add(R.drawable.hostel_warden);
        mCouncilImage.add(R.drawable.meeting);
        mCouncilImage.add(R.drawable.sports);
        mCouncilImage.add(R.drawable.office_worker);
        mCouncilImage.add(R.drawable.food);
        mCouncilImage.add(R.drawable.boy);
        mCouncilImage.add(R.drawable.sport_junior);
        mCouncilImage.add(R.drawable.music_girl);
        mCouncilImage.add(R.drawable.emergency_call);
    }


    private static long back_pressed=100;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        startActivity(new Intent(CouncilActivity.this, HomeActivity.class));

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return CommonFunctions.navigationItemSelect(item, this);

    }


}
