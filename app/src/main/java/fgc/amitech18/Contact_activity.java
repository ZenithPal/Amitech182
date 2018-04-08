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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chaitanya on 20-03-2018.
 */
public class Contact_activity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CALL_PHONE = 100;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    //    private RecyclerView.Adapter mAdapter;
    //  private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activity);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
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

                            case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                                break;

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
        public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
            Contact contact=mContacts.get(position);
            TextView textView=holder.mTextView1;
            textView.setText(contact.getPost());
            phone = contact.getNumber();
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
                    Uri uri = Uri.parse("tel:+"+getNumber());
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(uri);

                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions((Activity)getContext(), new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_CALL_PHONE);
                    }

                    else
                        startActivity(callIntent);
                }
            });

            holder.whatsapp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Uri uri = Uri.parse("https://api.whatsapp.com/send?phone="+getNumber());
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

    private String getNumber()
    {
        if(phone.equals("null"))
            return null;
        else
            return "91"+phone;
    }
}
