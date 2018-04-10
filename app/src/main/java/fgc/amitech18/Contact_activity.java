package fgc.amitech18;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.l4digital.fastscroll.FastScrollRecyclerView;

import java.util.ArrayList;

public class Contact_activity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FastScrollRecyclerView mRecyclerView;
    //    private RecyclerView.Adapter mAdapter;
    //  private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activity);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // mLayoutManager = new LinearLayoutManager(this);
        contacts = Contact.createContactList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // specify an adapter (see also next example)
        ContactsAdapter mAdapter = new ContactsAdapter(this,contacts);
        mRecyclerView.setAdapter(mAdapter);
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
                                break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:
                                // i=new Intent(MainActivity.this,Contact_activity.class);

                                break;

                            case R.id.sponsor: startActivity(new Intent(Contact_activity.this,SponsorActivity.class)); finish();
                                break;

                            case R.id.events:  startActivity(new Intent(Contact_activity.this,EventActivity.class)); finish();//i=new Intent(MainActivity.this,EventActivity.class);
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

        actionbar.setTitle("Contact Us");
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

    public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
        private ArrayList<Contact> mContacts;
        private Context mContext;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView1;
            public TextView mTextView2;
            public ImageView mImageView;
            public Button callButton;
            public Button whatsapp;
            private Context context;

            public ViewHolder(Context context,View v) {
                super(v);
                mTextView1 = v.findViewById(R.id.designation);
                mTextView2 = v.findViewById(R.id.name);
                mImageView = v.findViewById(R.id.imageView);
                callButton = v.findViewById(R.id.callIcon);
                whatsapp = v.findViewById(R.id.whappIcon);
                this.context = context;
            }
        }
        public ContactsAdapter(Context context,ArrayList<Contact>contacts){
            mContacts=contacts;
            mContext=context;
        }

        private Context getContext(){
            return mContext;
        }
        @Override
        public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context=parent.getContext();
            LayoutInflater inflater= LayoutInflater.from(context);
            View contactView=inflater.inflate(R.layout.contact_rv_card, parent, false);
            ViewHolder vh = new ViewHolder(context,contactView);

            return vh;
        }

        @Override
        public void onBindViewHolder(ContactsAdapter.ViewHolder holder, final int position) {
            final Contact contact=mContacts.get(position);
            TextView textView=holder.mTextView1;
            textView.setText(contact.getPost());
            TextView textView1=holder.mTextView2;
            textView1.setText(contact.getmName());
            ImageView imageView1=holder.mImageView;
            imageView1.setClipToOutline(true);
            imageView1.setImageResource(contact.getPic());
            if(position%2==0)
            {
                holder.itemView.setBackgroundColor(Color.parseColor("#EEEEEE"));
            }

            holder.callButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position==24) ptoast();
                    else {
                        Uri uri = Uri.parse("tel:+91" + contact.getNumber());
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(uri);
                        startActivity(callIntent);
                    }
                }
            });

            holder.whatsapp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(position==24) wtoast();
                    else {
                        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=+91" + contact.getNumber());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

    public void ptoast(){
        Toast toast = Toast.makeText(this, "Phone no. not available", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void wtoast(){
        Toast toast = Toast.makeText(this, "Whatsapp no. not available", Toast.LENGTH_SHORT);
        toast.show();
    }

}