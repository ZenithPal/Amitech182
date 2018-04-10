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

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;

    private ArrayList<event> events = new ArrayList<event>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        events = event.showEvent();
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        eventAdapter mAdapter = new eventAdapter(this,events);
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    public class eventAdapter extends RecyclerView.Adapter<eventAdapter.ViewHolder> {
        private ArrayList<event> mevent;
        private Context mContext;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView0;

            private Context context;
            public ViewHolder(Context context,View v) {
                super(v);
                mTextView0 = v.findViewById(R.id.textView);
                this.context = context;
            }
        }
        public eventAdapter(Context context,ArrayList<event>events){//*****
            mevent=events;
            mContext=context;
        }

        private Context getContext(){
            return mContext;
        }
        @Override
        public eventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context=parent.getContext();
            LayoutInflater inflater= LayoutInflater.from(context);
            View sponsorView=inflater.inflate(R.layout.event_rv_card, parent, false);
            eventAdapter.ViewHolder vh = new eventAdapter.ViewHolder(context,sponsorView);

            return vh;
        }


        @Override
        public void onBindViewHolder(eventAdapter.ViewHolder holder, int position) {
            event eve=mevent.get(position);
            TextView textView0=holder.mTextView0;
            textView0.setText(eve.getHead());


            // imageView2.setTint(sponsor.getCrown());
            //  imageView2.setColorFilter(getResources().getC);
            //  DrawableCompat.setTint(imageView2.getDrawable(),sponsor.getCrown());
            // ImageView v = findViewById(R.id.imageView6);

// set the stroke color
            // outline.setStrokeColor(Color.parseColor("#ED4337"));
            if(position%2==0)
            {holder.itemView.setBackgroundColor(Color.parseColor("#EEEEEE"));
            }
        }

        @Override
        public int getItemCount() {
            return mevent.size();
        }
}}