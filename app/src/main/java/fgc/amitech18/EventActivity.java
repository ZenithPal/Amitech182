package fgc.amitech18;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.l4digital.fastscroll.FastScroller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class EventActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FastScrollRecyclerView mRecyclerView;
    private ArrayList<FestEvent> mFestEvents = new ArrayList<>();

    int PERMISSION_CODE = 100;
    String[] permissions = {Manifest.permission.WRITE_CALENDAR , Manifest.permission.READ_CALENDAR};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        mFestEvents = getFestEvents(getApplicationContext());
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        EventAdapter mAdapter = new EventAdapter(mFestEvents);
        mRecyclerView.setAdapter(mAdapter);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(EventActivity.this, MainActivity.class));
                                finish();
                              break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:startActivity(new Intent(EventActivity.this,Contact_activity.class)); finish();
                                // i=new Intent(MainActivity.this,Contact_activity.class);

                                break;

                            case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                                startActivity(new Intent(EventActivity.this,SponsorActivity.class)); finish(); break;

                            case R.id.events: //i=new Intent(MainActivity.this,EventActivity.class);
                                break;
                            case R.id.developer:  break;

                        }

                        return true;
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setTitle("Events");

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

    private ArrayList<FestEvent> getFestEvents(Context context){
        int i = 0;
        String[] eventNames,eventVenue, eventTime, eventDate;
        ArrayList<FestEvent> events = new ArrayList<>();

        eventNames = context.getResources().getStringArray(R.array.event_name);
        eventVenue = context.getResources().getStringArray(R.array.venue_array);
        eventTime = context.getResources().getStringArray(R.array.time_array);
        eventDate = context.getResources().getStringArray(R.array.date_array);
        while(i < eventNames.length){
            events.add(new FestEvent(eventNames[i], eventVenue[i], eventTime[i], eventDate[i]));
            i++;
        }
        Collections.sort(events, new Comparator<FestEvent>()
        {
            @Override
            public int compare(FestEvent o1, FestEvent o2)
            {
                if(o1.getEventDate().compareTo(o2.getEventDate()) == 0){
                    if(o1.getEventTime().charAt(0) == '0'  && o2.getEventTime().charAt(0) == '1' || o1.getEventTime().charAt(0) == '1'  && o2.getEventTime().charAt(0) == '0')
                        return -o1.getEventTime().compareTo(o2.getEventTime());
                    else
                        return o1.getEventTime().compareTo(o2.getEventTime());
                }
                else{
                    return o1.getEventDate().compareTo(o2.getEventDate());
                }
            }
        });
        return events;
    }

    public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements FastScroller.SectionIndexer{
        private ArrayList<FestEvent> mFestEvents;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mEvent,mTime,mVenue,mDate;
            FloatingActionButton mAdd;
            public ViewHolder(View v) {
                super(v);
                mEvent = v.findViewById(R.id.event_name);
                mVenue = v.findViewById(R.id.event_venue);
                mTime = v.findViewById(R.id.event_time);
                mAdd = v.findViewById(R.id.add_to_calender);
                mDate = v.findViewById(R.id.event_date);
            }
        }
        public EventAdapter(ArrayList<FestEvent> FestEvents){
            mFestEvents = FestEvents;
        }

        @Override
        public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater= LayoutInflater.from(context);
            View sponsorView=inflater.inflate(R.layout.event_rv_card, parent, false);
            return new EventAdapter.ViewHolder(sponsorView);
        }


        @Override
        public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {

            final FestEvent eve = mFestEvents.get(position);
            TextView event = holder.mEvent;
            TextView time = holder.mTime;
            TextView venue = holder.mVenue;
            TextView date = holder.mDate;
            FloatingActionButton add = holder.mAdd;
            event.setText(eve.getHead());
            date.setText(eve.getEventDate());
            time.setText(eve.getEventTime());
            venue.setText(eve.getEventVenue());

            add.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {

                    Calendar beginTime = Calendar.getInstance();
                    beginTime.set(2018, 3, 20, 7, 30);
                    Calendar endTime = Calendar.getInstance();
                    endTime.set(2018, 3, 21, 8, 30);
                    Intent intent = new Intent(Intent.ACTION_INSERT)
                            .setData(CalendarContract.Events.CONTENT_URI)
                            .putExtra(CalendarContract.Events.TITLE, eve.getHead())
                            .putExtra(CalendarContract.Events.EVENT_LOCATION, "Amity University, Noida")
                            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

                    if(ContextCompat.checkSelfPermission(EventActivity.this
                            , Manifest.permission.READ_CALENDAR )== PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(EventActivity.this, Manifest.permission.WRITE_CALENDAR)
                            == PackageManager.PERMISSION_GRANTED )

                        startActivity(intent);

                    else
                        requestPermissions(permissions, 100);
                }
            });
        }


        @Override
        public int getItemCount() {
            return mFestEvents.size();
        }

        @Override
        public String getSectionText(int position) {
            return mFestEvents.get(position).getHead().substring(0,1);
        }
    }
}