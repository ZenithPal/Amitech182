package fgc.amitech18;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static fgc.amitech18.EventDetails.makeBOAData;
import static fgc.amitech18.EventDetails.makeCultData;
import static fgc.amitech18.EventDetails.makeEventData;
import static fgc.amitech18.EventDetails.makeFunData;
import static fgc.amitech18.EventDetails.makeLitData;
import static fgc.amitech18.EventDetails.makeSponData;
import static fgc.amitech18.EventDetails.makeTechData;

public class EventDetailActivity extends AppCompatActivity {
    private static ArrayList<EventDetails> favcardData;
    private static EventDetails card_data;
    private static int c;
    private static int card_pos;
    private ArrayList<EventDetails> cardData;
    private TextView detail_title;
    private TextView detail_desc;
    private TextView detail_date;
    private TextView detail_member;
    private TextView detail_loc;
    private TextView detail_rule;
    private int color;
    private Button btn_next;
    private Button btn_prev;
    private Button nav;
    private Button reg;
    private ImageView ic_team;
    private ImageView ic_loc;
    private ImageView detail_grad;
    private ImageView detail_img;
    private Intent homeIntent;
    private GestureDetectorCompat mDetector;

    public static void getCardData(EventDetails card, int pos) { //gets the data of the card clicked in RV
        c = 0;
        card_data = card;
        card_pos = card_data.getCard_pos() - 1;
    }

    public static void getFavCardData(ArrayList<EventDetails> card, int pos) {
        c = 1;
        favcardData = card;
        card_pos = favcardData.get(pos).getCard_pos() - 1;
        card_data = favcardData.get(pos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeIntent = new Intent(EventDetailActivity.this, MainActivity.class);
        //color= "@color/colorFunDark";
        setContentView(R.layout.activity_event_detail);

        nav = findViewById(R.id.detail_btn_nav);
        reg = findViewById(R.id.detail_btn_register);
        ic_team = findViewById(R.id.ic_act_evdetail_iv_team);
        ic_loc = findViewById(R.id.ic_act_evdetail_iv_loc);
        detail_title = findViewById(R.id.detail_tv_evname);
        detail_desc = findViewById(R.id.detail_tv_evdesc);
        detail_date = findViewById(R.id.detail_tv_evdate);
        detail_member = findViewById(R.id.detail_tv_teamsize);
        detail_loc = findViewById(R.id.detail_tv_location);
        detail_rule = findViewById(R.id.detail_tv_rule);
        detail_grad = findViewById(R.id.detail_iv_gradient);
        detail_img = findViewById(R.id.detail_iv_evimg);
        populateDetails();

        if (c != 1) {
            switch (card_data.getCard_category()) {
                case "ALL EVENTS":

                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_boa));
                    cardData = makeEventData();
                    break;
                case "BEST OF AMITECH":

                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_boa));
                    cardData = makeBOAData();
                    break;
                case "FUN":

                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_fun));
                    cardData = makeFunData();
                    break;
                case "CULTURAL":
                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_cult));
                    cardData = makeCultData();
                    break;
                case "LITERARY":
                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_lit));
                    cardData = makeLitData();
                    break;
                case "TECHNICAL":

                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_tech));
                    cardData = makeTechData();
                    break;
                case "SPONSORED":
                    detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_spon));
                    cardData = makeSponData();
                    break;
                default:
                    cardData = makeEventData();
                    break;
            }
        }
        //cardData = makeEventData();
        //cardData=filterEvents(cardData);

        btn_next = findViewById(R.id.detail_btn_next);
        if (card_pos == cardData.size() - 1) btn_next.setVisibility(View.INVISIBLE);
        btn_next.setTextColor(Color.BLACK);

        btn_prev = findViewById(R.id.detail_btn_prev);
        //if(card_pos==0) btn_prev.setVisibility(View.INVISIBLE);
        btn_prev.setTextColor(Color.BLACK);
        nav.setTextColor(color);
        reg.setTextColor(color);
    }

    public void populateDetails() {
        detail_title.setText(card_data.getCard_title());
        detail_desc.setText(card_data.getCard_desc());
        detail_date.setText(card_data.getEvent_date());
        detail_member.setText(card_data.getEvent_members());
        detail_loc.setText(card_data.getEvent_location());
        detail_rule.setText(card_data.getEvent_rules());
        detail_img.setImageResource(card_data.getEvent_img());
    }

    public void onbtnClick(View v) {

        if (v == btn_next)
            card_pos++;
        else
            card_pos--;

        if (card_pos >= 0) {
            card_data = cardData.get(card_pos);
            populateDetails();
        }

        if (card_pos == cardData.size() - 1) btn_next.setVisibility(View.INVISIBLE);
        if (card_pos < cardData.size() - 1) btn_next.setVisibility(View.VISIBLE);

        if (card_pos == -1) {

            MainActivity.getSelectedFromDetails(card_data.getCard_category());
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(homeIntent);
            finish();
        }
        if (card_pos > 0) btn_prev.setVisibility(View.VISIBLE);
    }

   /*public ArrayList<EventDetails> filterEvents(ArrayList<EventDetails> data){
       EventDetails temp; int pos=0;
       while(pos<data.size()) {
           temp = data.get(pos);
           if (temp.getCard_category() != card_data.getCard_category()) {
               data.remove(temp);
           } pos++;
       }
      return data;
   }*/
   public void facebook(View view)
   {
       Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/amitech.aset/"));
       startActivity(browserIntent);
   }

   public void whatsapp(View view)
   {
       Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=+91" + card_data.getEvent_wtsapno());
       Intent intent = new Intent(Intent.ACTION_VIEW, uri);
       startActivity(intent);
   }
}
