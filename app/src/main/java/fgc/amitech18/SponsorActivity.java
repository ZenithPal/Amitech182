package fgc.amitech18;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SponsorActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;

    private ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // mLayoutManager = new LinearLayoutManager(this);
        sponsors = Sponsor.createSponsorList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // specify an adapter (see also next example)
        SponsorsAdapter mAdapter = new SponsorsAdapter(this,sponsors);
        mRecyclerView.setAdapter(mAdapter);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(3).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(SponsorActivity.this, MainActivity.class));
                                finish();
                                break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:
                                // i=new Intent(MainActivity.this,Contact_activity.class);
                                startActivity(new Intent(SponsorActivity.this,Contact_activity.class)); finish();
                                break;

                            case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                                break;

                            case R.id.events: startActivity(new Intent(SponsorActivity.this,EventActivity.class)); finish(); //i=new Intent(MainActivity.this,EventActivity.class);
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

        actionbar.setTitle("Our Sponsors");
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

    public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ViewHolder> {
        private ArrayList<Sponsor> mSponsors;
        private Context mContext;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView0;
            public TextView mTextView1;
            public TextView mTextView2;
            public ImageView mImageView;
            public ImageView mImageView1;
            private Context context;
            public ViewHolder(Context context,View v) {
                super(v);
                mTextView0 = v.findViewById(R.id.event_name);
                mTextView1 = v.findViewById(R.id.textView0);
                mTextView2 = v.findViewById(R.id.textView1);
                mImageView = v.findViewById(R.id.imageView);
                mImageView1 = v.findViewById(R.id.imageView6);
                this.context = context;
            }
        }
        public SponsorsAdapter(Context context,ArrayList<Sponsor>sponsors){//*****
            mSponsors=sponsors;
            mContext=context;
        }

        private Context getContext(){
            return mContext;
        }
        @Override
        public SponsorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context=parent.getContext();
            LayoutInflater inflater= LayoutInflater.from(context);
            View sponsorView=inflater.inflate(R.layout.sponsor_rv_card, parent, false);
            SponsorsAdapter.ViewHolder vh = new SponsorsAdapter.ViewHolder(context,sponsorView);

            return vh;
        }

        @Override
        public void onBindViewHolder(SponsorsAdapter.ViewHolder holder, int position) {
            Sponsor sponsor=mSponsors.get(position);
            TextView textView0=holder.mTextView0;
            textView0.setText(sponsor.getHead());
            TextView textView=holder.mTextView1;
            textView.setText(sponsor.getPost());

            TextView textView1=holder.mTextView2;
            textView1.setText(sponsor.getmName());

            ImageView imageView1=holder.mImageView;
            imageView1.setClipToOutline(true);
           // imageView1.setPadding(10,0,10,0);

            //imageView1.setClipBounds(0,0,0,0);
            imageView1.setImageResource(sponsor.getPic());
            ImageView imageView2=holder.mImageView1;

            // imageView2.setTint(sponsor.getCrown());
            //  imageView2.setColorFilter(getResources().getC);
            //  DrawableCompat.setTint(imageView2.getDrawable(),sponsor.getCrown());
            // ImageView v = findViewById(R.id.imageView6);
            Drawable d = imageView2.getDrawable();
            d.setTint(sponsor.getCrown());

// set the stroke color
            // outline.setStrokeColor(Color.parseColor("#ED4337"));
            if(position%2==0)
            {holder.itemView.setBackgroundColor(Color.parseColor("#EEEEEE"));
            }
        }

        @Override
        public int getItemCount() {
            return mSponsors.size();
        }
    }
}