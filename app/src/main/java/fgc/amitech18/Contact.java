package fgc.amitech18;

import java.util.ArrayList;

/**
 * Created by payal on 20-03-2018.
 */

public class Contact {
    private String mpost;
    private String mname;
    private int mpic;
    //  private int mwhtsapp;
    //  private int mcall;

    public Contact(String post, String name, int pic) {
        mpost = post;
        mname = name;
        mpic = pic;
        //   mwhtsapp = whtsapp;
        //mcall = call;
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

    // public int getWhtsapp() {
    // return mwhtsapp;
    // }

    // public int getCall() {
    //  return mcall;
    //   }

    public static ArrayList<Contact>createContactList(){
        Contact contact_card;
        String[] conPost;
        String[] conName;
        int[] picture;
        // int whatsapp;
        // int call;
        ArrayList<Contact> contacts=new ArrayList<Contact>();
        conPost = new String[]{
                "BRAND AMBASSADOR",
                "Publicity Director",
                "Sponsorship Director",
                "Technical Director",
                "Cultural Director",
                "Transport Director"
        };
        conName = new String[]{
                "SOMEONE",
                "Oh yes I am",
                "I am here",
                "present",
                "now",
                "here"
        };
        picture=new int[]{
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };

        for (int i = 0; i < 6; i++) {
            contact_card = new Contact(conPost[i], conName[i],picture[i]);
            contacts.add(contact_card);

        }
        return contacts;
    }}