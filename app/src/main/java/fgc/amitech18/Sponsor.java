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
                "Associate sponsor",
                "Drinks partner",
                "Desserts partner",
                "Technology partner",
                "Event sponsor",
                "Clarity partner"
        };
        spoPost = new String[]{

                "Vivo",
                "ACE Academy",
                "Kreatryx",
                "Dena bank",
                "Pepsi",
                "Baskin Robbins",
                "Feels Goods Creations",
                "Worlds of wonder",
                "Lenskart"
        };
        spoName = new String[]{
                "Camera & Music",
                "Engineering Academy",
                "GATE/PSU/SSC Preparation Simplified",
                "Dena hai toh Bharosa hai",
                "",
                "",
                "Spreading happiness feels good",
                "Place of wow moments",
                "Spexy is the new sexy"
        };
        picture=new int[]{
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background
        };
        crown=new int[]{


                Color.parseColor("#FBC02D"),
                Color.parseColor("#BDBDBD"),
                Color.parseColor("#795548"),
                Color.parseColor("#2E7D32"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FBC02D")

        };

        for (int i = 0; i < 9; i++) {
            sponsor_card = new Sponsor(spoHead[i],spoPost[i], spoName[i],picture[i],crown[i]);
            sponsors.add(sponsor_card);

        }
        return sponsors;
    }}