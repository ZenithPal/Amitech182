package fgc.amitech18;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
import java.util.Collections;
import java.util.Comparator;

public class EventActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FastScrollRecyclerView mRecyclerView;

    private ArrayList<FestEvent> mFestEvents = new ArrayList<>();
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
        String[] eventNames;
        ArrayList<FestEvent> events = new ArrayList<>();

        eventNames = context.getResources().getStringArray(R.array.event_name_arraylist);
        while(++i < eventNames.length){
            events.add(new FestEvent(eventNames[i]));
        }
        Collections.sort(events, new Comparator<FestEvent>()
        {
            @Override
            public int compare(FestEvent o1, FestEvent o2)
            {
                return o1.getHead().compareTo(o2.getHead());
            }
        });
        return events;
    }

    public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements FastScroller.SectionIndexer{
        private ArrayList<FestEvent> mFestEvents;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView0;
            public ViewHolder(View v) {
                super(v);
                mTextView0 = v.findViewById(R.id.textView);
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
            FestEvent eve= mFestEvents.get(position);
            TextView textView0 = holder.mTextView0;
            textView0.setText(eve.getHead());


            // imageView2.setTint(sponsor.getCrown());
            //  imageView2.setColorFilter(getResources().getC);
            //  DrawableCompat.setTint(imageView2.getDrawable(),sponsor.getCrown());
            // ImageView v = findViewById(R.id.imageView6);

// set the stroke color
            // outline.setStrokeColor(Color.parseColor("#ED4337"));
//            if(position%2==0)
//            {holder.itemView.setBackgroundColor(Color.parseColor("#EEEEEE"));
//            }
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