package esir.sem2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private double mWeight;
    private double mBMI;
    private int mBdSys;
    private int mBdDya;
    private int mPulse;
    private int mOxygenRate;
    private TextView mBMITxtView;
    private TextView mBdDyaTxtView;
    private TextView mBdSysTxtView;
    private TextView mPulseTxtView;
    private TextView mWeightTxtView;
    private TextView mOxygenRateTxtView;
    private String mUserGreetings;
    private TextView mUserGreetingsTxtView;
    private TextView mDateRefreshTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(view, "Mise à jour des données", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                //Toast.makeText(getApplicationContext(),"Mise à jour des données en cours", Toast.LENGTH_SHORT).show();
                initData();
                updateInterface();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mUserGreetingsTxtView = findViewById(R.id.profile_pseudo_main_greeting_main);
        mBMITxtView = findViewById(R.id.imc_Value_TxtView_main);
        mBdDyaTxtView = findViewById(R.id.bp_dya_val_main);
        mBdSysTxtView = findViewById(R.id.bp_sys_val_main);
        mPulseTxtView = findViewById(R.id.bp_pulse_val_main);
        mWeightTxtView = findViewById(R.id.weight_main);
        mOxygenRateTxtView = findViewById(R.id.oxi_rate_val_main);
        mDateRefreshTxtView = findViewById(R.id.date_refresh_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mWeight = 76;
        mBMI = 20.75;
        mBdSys = 145;
        mBdDya = 87;
        mPulse = 63;
        mOxygenRate = 98;
        initData();
        updateInterface();
    }

    private void initData() {
        mUserGreetings = "Bonjour "+getResources().getText(R.string.profile_pseudo)+',';
    }

    private void updateInterface() {



        Date currentTime = Calendar.getInstance().getTime();
        mDateRefreshTxtView.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm",Locale.FRANCE).format(currentTime));

        DecimalFormat numberFormat = new DecimalFormat("#.0");
        mWeightTxtView.setText(numberFormat.format(mWeight));

        mBdSysTxtView.setText(String.valueOf(mBdSys));
        mBdDyaTxtView.setText(String.valueOf(mBdDya));

        mPulseTxtView.setText(String.valueOf(mPulse));

        mBMITxtView.setText(numberFormat.format(mBMI));
        mOxygenRateTxtView.setText(String.valueOf(mOxygenRate));

        mUserGreetingsTxtView.setText(mUserGreetings);

        if (mBMI <= 16.5 || mBMI >= 30){
            mBMITxtView.setTextColor(getResources().getColor(R.color.alizarin_red_color));
        } else if (mBMI <= 18.5 || mBMI >= 25){
            mBMITxtView.setTextColor(getResources().getColor(R.color.orange_orange_color));
        } else {
            mBMITxtView.setTextColor(getResources().getColor(R.color.nephritis_green_color));
        }

        if (mOxygenRate >= 94){
            mOxygenRateTxtView.setTextColor(getResources().getColor(R.color.nephritis_green_color));
        } else if (mOxygenRate >= 90){
            mBMITxtView.setTextColor(getResources().getColor(R.color.orange_orange_color));
        } else {
            mBMITxtView.setTextColor(getResources().getColor(R.color.alizarin_red_color));
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent profileActivity = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(profileActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent activity;
        int id = item.getItemId();

        if (id == R.id.nav_oxygen) {
            activity = new Intent(MainActivity.this,OximeterActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_blood_pressure) {
            activity = new Intent(MainActivity.this,TensionActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_weight) {
            activity = new Intent(MainActivity.this,BMIActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_calories) {
            Intent profileActivity = new Intent(MainActivity.this,CaloriesActivity.class);
            startActivity(profileActivity);
        } else if (id == R.id.nav_setting) {
            Intent profileActivity = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(profileActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
