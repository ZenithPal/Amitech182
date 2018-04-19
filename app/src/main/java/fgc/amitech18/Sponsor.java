package fgc.amitech18;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by payal on 20-03-2018.
 */

public class Sponsor {
    private String mhead;

    private String mpost;
    private String mname;
    private int mpic;
    private int mcrown;
    //  private int mwhtsapp;
    //  private int mcall;

    public Sponsor(String head,String post, String name, int pic,int crown) {
        mhead = head;
        mpost = post;
        mname = name;
        mpic = pic;
        mcrown = crown;
        //   mwhtsapp = whtsapp;
        //mcall = call;
    }
    public String getHead() {
        return mhead;
    }
    public String getPost() {
        return mpost;
    }

    public String getmName() {
        return mname;
    }

    public int getPic() {
        return mpic;
    }
    public int getCrown() {
        return mcrown;
    }

    // public int getWhtsapp() {
    // return mwhtsapp;
    // }

    // public int getCall() {
    //  return mcall;
    //   }

    public static ArrayList<Sponsor>createSponsorList(){
        Sponsor sponsor_card;
        String[] spoHead;

        String[] spoPost;
        String[] spoName;
        int[] picture;
        int[] crown;
        // int whatsapp;
        // int call;
        ArrayList<Sponsor> sponsors=new ArrayList<Sponsor>();
        spoHead = new String[]{
                "Title sponsor",
                "Power sponsor",
                "Associate sponsor",
                "Technology partner"

        };
        spoPost = new String[]{

                "ACE Academy",
                "Career Launcher",
                "Developing Success Institute",
                "Feels Goods Creations"

        };
        spoName = new String[]{

                "Engineering Academy",
                "Helping the youth of the country achieve their career dreams",
                "One thing that matters to you and us, is your result and success",

                "Spreading happiness feels good"

        };
        picture=new int[]{
                R.drawable.logotitle_new,
                R.drawable.logo_ace_academy,
                R.drawable.logo_career_launcher,
                R.drawable.logo_devloping_success,
                R.drawable.ic_launcher_background

        };
        crown=new int[]{


                Color.parseColor("#FBC02D"),
                Color.parseColor("#BDBDBD"),
                Color.parseColor("#795548"),

                Color.parseColor("#FBC02D")


        };

        for (int i = 0; i < 4; i++) {
            sponsor_card = new Sponsor(spoHead[i],spoPost[i], spoName[i],picture[i],crown[i]);
            sponsors.add(sponsor_card);

        }
        return sponsors;
    }}