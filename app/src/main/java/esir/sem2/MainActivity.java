package esir.sem2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
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
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private double mWeight;
    private double mIBM;
    private int mBdSys;
    private int mBdDya;
    private int mPulse;
    private int mOxygenRate;
    private TextView mIBMTxtView;
    private TextView mBdDyaTxtView;
    private TextView mBdSysTxtView;
    private TextView mPulseTxtView;
    private TextView mWeightTxtView;
    private TextView mOxygenRateTxtView;

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
    }


    @Override
    protected void onStart() {
        super.onStart();
        mWeight = 76;
        mIBM = 20.75;
        mBdSys = 145;
        mBdDya = 87;
        mPulse = 63;
        mOxygenRate = 98;
        mIBMTxtView = findViewById(R.id.imc_Value_TxtView_main);
        mBdDyaTxtView = findViewById(R.id.bp_dya_val_main);
        mBdSysTxtView = findViewById(R.id.bp_sys_val_main);
        mPulseTxtView = findViewById(R.id.bp_pulse_val_main);
        mWeightTxtView = findViewById(R.id.weight_main);
        mOxygenRateTxtView = findViewById(R.id.oxi_rate_val_main);
        initData();
        updateInterface();
    }

    private void initData() {

    }

    private void updateInterface() {

        DecimalFormat numberFormat = new DecimalFormat("#.0");
        mWeightTxtView.setText(numberFormat.format(mWeight));

        mBdSysTxtView.setText(String.valueOf(mBdSys));
        mBdDyaTxtView.setText(String.valueOf(mBdDya));

        mPulseTxtView.setText(String.valueOf(mPulse));

        mIBMTxtView.setText(numberFormat.format(mIBM));
        mOxygenRateTxtView.setText(String.valueOf(mOxygenRate));

        if (mIBM <= 16.5 || mIBM >= 30){
            mIBMTxtView.setTextColor(getResources().getColor(R.color.alizarin_red_color));
        } else if (mIBM <= 18.5 || mIBM >= 25){
            mIBMTxtView.setTextColor(getResources().getColor(R.color.orange_orange_color));
        } else {
            mIBMTxtView.setTextColor(getResources().getColor(R.color.nephritis_green_color));
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

        } else if (id == R.id.nav_weight) {

        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
