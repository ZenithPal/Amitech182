package fgc.amitech18;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Random;

import static fgc.amitech18.EventDetails.makeBOAData;
import static fgc.amitech18.EventDetails.makeCultData;
import static fgc.amitech18.EventDetails.makeEventData;
import static fgc.amitech18.EventDetails.makeFunData;
import static fgc.amitech18.EventDetails.makeLitData;
import static fgc.amitech18.EventDetails.makeSponData;
import static fgc.amitech18.EventDetails.makeTechData;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static ArrayList<EventDetails> favEvent = new ArrayList<EventDetails>();
    private static int SPLASH_TIME_OUT = 3000;
    //List<event> eventList;
    private static String selectedCat = "BEST OF AMITECH";
    private static TextView dashHeader;
    String change_text[] = {"is here", "have fun!!", "it's about to begin! ", "Let's explore", "Let's party", "Let's participate"};
    private LinearLayoutManager layoutManager;
    private RecyclerView.ViewHolder viewHolder;
    private TextSwitcher mSwitcher;
    private int mCounter = 0;

    // Start the Runnable immediately
    private DrawerLayout mDrawerLayout;
    private Handler handler = new Handler();
    // Define the code block to be executed
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Insert custom code here
            Random rand = new Random();
            int mCounter = rand.nextInt(6);
            mSwitcher.setText(change_text[mCounter]);

            // Repeat every 2 seconds
            handler.postDelayed(runnable, SPLASH_TIME_OUT);
        }
    };
    //Start Event card variables
    private RecyclerView dash_rv_eventCard;
    //--finish--
    private eventCardAdapter cardAdapter;
    private ArrayList<EventDetails> eventCard = new ArrayList<EventDetails>();
    //Start Event category variables
    private RecyclerView dash_rv_eventCategory;
    private eventCardCategoryAdapter categoryAdapter;
    private String[] eventCat;
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {


        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            /*            t.setTypeface(Typeface.defaultFromStyle(R.font.oxygen_light));*/
            //t.setTextAppearance(MainActivity.this,R.font.chewy);
            t.setTextAppearance(MainActivity.this, R.style.CustomText);

            return t;
        }
    };

    public static void getSelectedFromDetails(String s) {
        selectedCat = s;
    }

    //private PrefManager prefManager;
    //finish
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mSwitcher = findViewById(R.id.switcher);
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);
        mSwitcher.setFactory(mFactory);
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        mSwitcher.setCurrentText("is here");
        handler.post(runnable);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        //  Fragment fragment = null;
                        //  menuItem.setChecked(true);

                        // close drawer when item is tapped
                        //    mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(MainActivity.this, MainActivity.class));
                                break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:
                                // i=new Intent(MainActivity.this,Contact_activity.class);
                                startActivity(new Intent(MainActivity.this,Contact_activity.class));  finish();
                                //Snackbar snackbar = Snackbar.make(findViewById(R.id.dash_rv_catlist),R.string.snack,Snackbar.ENGTH_SHORT);
                                //snackbar.show();
                                break;
                            //Fragment fragment = new ContactActivity();
                            // fragmentTransaction.add(R.id.mainArea, fragment);
                            // fragmentTransaction.commit();break;
                            //  Intent i=new Intent(MainActivity.this,ContactActivity.class);
                            //  startActivity(i); finish(); break;

                            case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                                startActivity(new Intent(MainActivity.this, SponsorActivity.class));finish();
                                break;
                            case R.id.eventshe:  startActivity(new Intent(MainActivity.this, EventSchedule.class));finish();break;

                            case R.id.events: //i=new Intent(MainActivity.this,EventActivity.class);
                                startActivity(new Intent(MainActivity.this, EventActivity.class));
                                break;
                            //case R.id.developer: //i=new Intent(MainActivity.this,EventActivity.class);
                            //startActivity(new Intent(MainActivity.this,DeveloperActivity.class));  break;
                            //    newGame();
                            //   return true;
                            //default:
                            //  menuItem.setChecked(true);
                            //  mDrawerLayout.closeDrawers();
                            //if (fragment != null) {
                            //  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                            //    ft.add(R.id.mainArea, fragment);

                            //   setTitle("Contact Us");
                            //   ft.commit();break;
                            // mDrawerLayout.closeDrawers();
                            //  }
                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here*/
                        //  displaySelectedScreen(menuItem.getItemId());
                        return true;
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setTitle("Home");

        toolbar.setTitleTextColor(Color.WHITE);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        Spinner spinner = findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears//simple_spinner_item
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        /*RecyclerView rv=(RecyclerView)findViewById(R.id.mainRecycle);
        rv.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);*/
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);


        dashHeader = findViewById(R.id.dash_tv_cat_title);
        dashHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prefManager = new PrefManager(MainActivity.this);
                //prefManager.setFirstTimeLaunch(true);
            }
        });

        //Creating the data set for the event card
        switch (selectedCat) {
            case "ALL EVENTS":
                eventCard = makeEventData();
                break;
            case "BEST OF AMITECH":
                eventCard = makeBOAData();
                break;
            case "FUN":
                eventCard = makeFunData();
                break;
            case "CULTURAL":
                eventCard = makeCultData();
                break;
            case "SPONSORED":
                eventCard = makeSponData();
                break;
            case "LITERARY":
                eventCard = makeLitData();
                break;
            case "TECHNICAL":
                eventCard = makeTechData();
                break;
            default:
                eventCard = makeBOAData();
                break;
        }
        LinearLayoutManager layoutManager_rv = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_rv_eventCard = findViewById(R.id.dash_rv_eventcard);
        dash_rv_eventCard.setLayoutManager(layoutManager_rv);
        cardAdapter = new eventCardAdapter(this, eventCard);
        dash_rv_eventCard.setAdapter(cardAdapter);

        eventCat = new String[]{
                "BEST OF AMITECH",
                "ALL EVENTS",
                "FAVOURITE",
                "TECHNICAL",
                "CULTURAL",
                "FUN",
                "LITERARY",
                "SPONSORED"
        };
        LinearLayoutManager layoutManager_rv_cat = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_rv_eventCategory = findViewById(R.id.dash_rv_catlist);
        dash_rv_eventCategory.setLayoutManager(layoutManager_rv_cat);
        categoryAdapter = new eventCardCategoryAdapter(this, eventCat);
        dash_rv_eventCategory.setAdapter(categoryAdapter);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rv=(RecyclerView)findViewById(R.id.mainRecycle);
        rv.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);*/
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // String item=adapterView.getItemAtPosition(i).toString();
        switch (adapterView.getSelectedItemPosition()) {
            case 0:
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, EventActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Contact_activity.class));
                break;
        }
        ((TextView) view).setTextColor(Color.WHITE);
        ((TextView) view).setTextSize(20);
    }

    //public ArrayList<EventDetails> getCardData() { return eventCard; }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    class eventCardAdapter extends RecyclerView.Adapter<eventCardAdapter.ViewHolder> {
        private ArrayList<EventDetails> meventCard;

        private int fav_flag = 0;
        private Context mcontext;
        //private String selectedCat = "BEST OF AMITECH";

        public eventCardAdapter(Context context, ArrayList<EventDetails> eventCard) {
            meventCard = eventCard;
            mcontext = context;
        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View cardview = layoutInflater.inflate(R.layout.dash_rv_eventcard, parent, false);

            ViewHolder viewHolder = new ViewHolder(context, cardview);
            return (viewHolder);
        }

        @Override
        public void onBindViewHolder(eventCardAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            EventDetails event_card = meventCard.get(position);
            if (!favEvent.isEmpty()) {
                for (int i = 0; i < favEvent.size(); i++) {
                    if (event_card.getCard_title() == favEvent.get(i).getCard_title())
                        viewHolder.bt_fav.setText("UNFAVOURITE");
                    //event_card.setEvent_favorite(1);
                }
            }
            int color, colorDark;
            color = getResources().getColor(R.color.colorBOADark);
            colorDark = getResources().getColor(R.color.colorAccent);
            //String selectCat = eventCardCategoryAdapter.getSelectedCat();
            //if(event_card.getCard_category()=="Best of Amitech") {
            // Set item views based on your views and data model
            TextView cardtitle = viewHolder.cardTitle;
            TextView carddesc = viewHolder.cardDesc;
            Button card_det = viewHolder.bt_details;
            Button card_fav = viewHolder.bt_fav;
            ImageView line = viewHolder.line;
            cardtitle.setText(event_card.getCard_title());
            carddesc.setText(event_card.getCard_desc());
            switch (selectedCat) {
                case "ALL EVENTS":
                    color = getResources().getColor(R.color.colorAll);
                    colorDark = getResources().getColor(R.color.colorAllDark);
                    break;
                case "BEST OF AMITECH":
                    color = getResources().getColor(R.color.colorBOA);
                    colorDark = getResources().getColor(R.color.colorBOADark);
                    break;
                case "FUN":
                    color = getResources().getColor(R.color.colorFun);
                    colorDark = getResources().getColor(R.color.colorFunDark);
                    break;
                case "CULTURAL":
                    color = getResources().getColor(R.color.colorCultural);
                    colorDark = getResources().getColor(R.color.colorCulturalDark);
                    break;
                case "TECHNICAL":
                    color = getResources().getColor(R.color.colorTechnical);
                    colorDark = getResources().getColor(R.color.colorTechnicalDark);
                    break;
                case "LITERARY":
                    color = getResources().getColor(R.color.colorLiterary);
                    colorDark = getResources().getColor(R.color.colorLiteraryDark);
                    break;
                case "SPONSORED":
                    color = getResources().getColor(R.color.colorSponsored);
                    colorDark = getResources().getColor(R.color.colorSponsoredDark);
                    break;
                default:
                    color = getResources().getColor(R.color.colorBOA);
                    colorDark = getResources().getColor(R.color.colorBOADark);
                    break;
            }
            cardtitle.setBackgroundColor(colorDark);
            cardtitle.setTextColor(color);
            card_det.setTextColor(colorDark);
            card_fav.setTextColor(colorDark);
            line.setBackgroundColor(color);
            //if(event_card.getEvent_favorite()==1)
            //viewHolder.bt_fav.setText("UNFAVOURITE");
            //else viewHolder.bt_fav.setText("FAVOURITE");
            //}
            /*else {
                meventCard.remove(event_card);
                cardAdapter.notifyDataSetChanged();
            }*/

        }

        @Override
        public int getItemCount() {
            return meventCard.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView cardTitle;
            public TextView cardDesc;
            public Button bt_details;
            public Button bt_fav;
            public ImageView line;
            private Context context;

            public ViewHolder(Context context, View itemView) {
                super(itemView);
                cardTitle = itemView.findViewById(R.id.dash_rv_card_tv_title);
                cardDesc = itemView.findViewById(R.id.dash_rv_card_tv_desc);
                bt_details = itemView.findViewById(R.id.dash_rv_card_bt_detail);
                bt_fav = itemView.findViewById(R.id.dash_rv_card_bt_nav);
                line = itemView.findViewById(R.id.dash_rv_card_line);
                // Store the context
                this.context = context;
                // Attach a click listener to the entire row view
                itemView.setOnClickListener(this);
                bt_details.setOnClickListener(this);
                bt_fav.setOnClickListener(this);
                bt_fav.setText("FAVOURITE");
            }

            // Handles the row being being clicked
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition(); // gets item position
                if (view != bt_fav) {
                    if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                        EventDetails card = meventCard.get(position);
                        if (selectedCat != "FAVOURITE")
                            EventDetailActivity.getCardData(card, position);
                        else EventDetailActivity.getFavCardData(favEvent, position);
                        // We can access the data within the views
                        Intent intent = new Intent(context, EventDetailActivity.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
                } else {
                    EventDetails card2;
                    //if(selectedCat=="FAVOURITE")card2 = favEvent.get(position);
                    /*else*/
                    card2 = meventCard.get(position);
                    if (bt_fav.getText() == "FAVOURITE") {
                        card2.setEvent_favorite(1);
                        //meventCard.set(position,card2);
                        favEvent.add(card2);
                        bt_fav.setText("UNFAVOURITE");
                    } else {
                        card2.setEvent_favorite(0);
                        //meventCard.set(position,card2);
                        favEvent.remove(card2);
                        //cardAdapter.notifyDataSetChanged();
                        //dash_rv_eventCard.setAdapter(cardAdapter);
                        bt_fav.setText("FAVOURITE");

                    }
                    for (int i = 0; i < favEvent.size(); i++) {
                        favEvent.get(i).card_pos = i + 1;
                    }
                    cardAdapter.notifyDataSetChanged();
                }
            }
        }
    }
    //event category adapter

    class eventCardCategoryAdapter extends RecyclerView.Adapter<eventCardCategoryAdapter.ViewHolder> {
        private String[] namelist;
        private Context mcontext;

        public eventCardCategoryAdapter(Context context, String[] name) {
            namelist = name;
            mcontext = context;
            //selectedCat = "BEST OF AMITECH";
        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCardCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View categoryview = layoutInflater.inflate(R.layout.fragment_rv_category, parent, false);

            ViewHolder viewHolder = new ViewHolder(context, categoryview);
            return (viewHolder);
        }

        @Override
        public void onBindViewHolder(eventCardCategoryAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            String categoryN = namelist[position];
            int draw;
            String col;
            col = "#424242";
            // Set item views based on your views and data model
            TextView catName = viewHolder.categoryName;
            catName.setText(categoryN);
            switch (categoryN) {
                case "ALL EVENTS":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_all;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_all;
                    break;
                case "BEST OF AMITECH":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_boa;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_boa;
                    break;
                case "FUN":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_fun;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_fun;
                    break;
                case "LITERARY":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_lit;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_lit;
                    break;
                case "SPONSORED":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_spon;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_spon;
                    break;
                case "CULTURAL":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_cult;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_cult;
                    break;
                case "TECHNICAL":
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_tech;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_tech;
                    break;
                default:
                    if (selectedCat == categoryN) {
                        draw = R.drawable.s_category_boa;
                        col = "#ffffff";
                    } else
                        draw = R.drawable.us_category_boa;
                    break;
            }
            catName.setBackgroundResource(draw);
            catName.setTextColor(Color.parseColor(col));
            if (selectedCat != "BEST OF AMITECH" && selectedCat != "ALL EVENTS")
                dashHeader.setText(selectedCat + " EVENTS");
            else
                dashHeader.setText(selectedCat);
        }

        @Override
        public int getItemCount() {
            return namelist.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView categoryName;
            private Context context;


            public ViewHolder(Context context, View itemView) {
                super(itemView);
                categoryName = itemView.findViewById(R.id.category_name);

                // Store the context
                this.context = context;
                // Attach a click listener to the entire row view
                itemView.setOnClickListener(this);
            }

            // Handles the row being being clicked
            @Override
            public void onClick(View view) {
                String name = categoryName.getText().toString();
                switch (name) {
                    case "ALL EVENTS":
                        eventCard = makeEventData();
                        break;
                    case "BEST OF AMITECH":
                        eventCard = makeBOAData();
                        break;
                    case "FAVOURITE":
                        eventCard = favEvent;
                        if (favEvent.isEmpty()) {
                            //Toast toast = Toast.makeText(MainActivity.this, "NO FAVOURITE EVENTS!", Toast.LENGTH_SHORT);
                            Toast.makeText(MainActivity.this, "NO FAVOURITE EVENTS!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "FUN":
                        eventCard = makeFunData();
                        break;
                    case "CULTURAL":
                        eventCard = makeCultData();
                        break;
                    case "SPONSORED":
                        eventCard = makeSponData();
                        break;
                    case "LITERARY":
                        eventCard = makeLitData();
                        break;
                    case "TECHNICAL":
                        eventCard = makeTechData();
                        break;
                    default:
                        eventCard = makeBOAData();
                        break;
                }
                categoryAdapter.notifyDataSetChanged();
                selectedCat = name;
                cardAdapter = new eventCardAdapter(context, eventCard);
                cardAdapter.notifyDataSetChanged();
                dash_rv_eventCard.setAdapter(cardAdapter);

                //dashHeader = (TextView) findViewById(R.id.dash_tv_cat_title);
                if (selectedCat != "BEST OF AMITECH")
                    dashHeader.setText(selectedCat + " EVENTS");
                else
                    dashHeader.setText(selectedCat);
            }
        }

        //public static String getSelectedCat(){return selectedCat;}
    }
    /*class eventCategoryAdapter extends RecyclerView.Adapter<eventCategoryAdapter.CategoryViewHolder>{
        private String[] cat;
        private Context mcontext;

        public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView categoryName;
            private Context con;
            public CategoryViewHolder(Context context, View itemview){
                super(itemview);
                categoryName = (TextView) findViewById(R.id.category_name);
                this.con=context;
                itemview.setOnClickListener(this);
            }
            @Override
            public void onClick(View view){

            }
        }

        public eventCategoryAdapter(Context context, String[] category){
            this.mcontext = context;
            this.cat = category;

        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCategoryAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            //Context context = parent.getContext();
           // LayoutInflater layoutInflater = LayoutInflater.from(context);

           // View cardview = layoutInflater.inflate(R.layout.dash_rv_eventcard, parent, false);

            //eventCardAdapter.ViewHolder viewHolder = new eventCardAdapter.ViewHolder(context, cardview);
            //return (viewHolder);

            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View category_view = layoutInflater.inflate(R.layout.fragment_rv_category, parent, false);
            eventCategoryAdapter.CategoryViewHolder holder = new eventCategoryAdapter.CategoryViewHolder(context, category_view);
            return (holder);
        }

        @Override
        public void onBindViewHolder (eventCategoryAdapter.CategoryViewHolder holder, int position){
            String name = cat[position];
            //TextView categoryName = holder.categoryName;
            holder.categoryName.setText(name);
        }

        @Override
        public int getItemCount(){return (cat.length);}
    }*/
}
    /*private class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{
        @Override
        public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class ViewHolder {
    }:
}*/
