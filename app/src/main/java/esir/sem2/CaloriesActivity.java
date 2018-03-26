package esir.sem2;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class CaloriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_calories);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent activity;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            activity = new Intent(CaloriesActivity.this,MainActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_oxygen) {
            activity = new Intent(CaloriesActivity.this,OximeterActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_blood_pressure) {
            activity = new Intent(CaloriesActivity.this,TensionActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_weight) {
            activity = new Intent(CaloriesActivity.this,BMIActivity.class);
            startActivity(activity);
        } else if (id == R.id.nav_setting) {
            activity = new Intent(CaloriesActivity.this,ProfileActivity.class);
            startActivity(activity);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
