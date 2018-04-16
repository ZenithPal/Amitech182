package fgc.amitech18;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class EventSchedule extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_schedule_layout);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(2).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(EventSchedule.this, MainActivity.class));
                                finish();
                                break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:
                                // i=new Intent(MainActivity.this,Contact_activity.class);
                                startActivity(new Intent(EventSchedule.this,Contact_activity.class)); finish();
                                break;

                            case R.id.sponsor:  startActivity(new Intent(EventSchedule.this,SponsorActivity.class)); finish();// i=new Intent(MainActivity.this,SponsorActivity.class);
                                break;

                            case R.id.events: startActivity(new Intent(EventSchedule.this,EventActivity.class)); finish(); //i=new Intent(MainActivity.this,EventActivity.class);
                                break;
                            case R.id.developer:  break;
                            case R.id.eventshe:break;

                        }

                        return true;
                    }
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setTitle("Event Schedule");
        toolbar.setTitleTextColor(Color.WHITE);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
