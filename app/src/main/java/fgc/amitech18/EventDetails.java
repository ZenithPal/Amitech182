package fgc.amitech18;

import java.util.ArrayList;

/**
 * Created by Diksha on 10-03-2018.
 */

public class EventDetails {
    public String card_title; //title for card and details
    public String card_desc; //description for card
    public String event_date; //Date of event;
    public String card_category; //category of the event
    public String event_members; //team size
    public String event_location; //On campus location
    public String event_rules; //guidelines
    public int event_favorite;
    public int event_img;
    public int card_pos; //position of the card in the rv

    public EventDetails(String title, String desc, String date, String cat, String teamsize, String loc, String rule, int pos, int draw) {
        this.card_title = title;
        this.card_desc = desc;
        this.event_date = date;
        this.card_category = cat;
        this.event_members = teamsize;
        this.event_location = loc;
        this.event_rules = rule;
        this.card_pos = pos;
        this.event_img = draw;
    }

    public static ArrayList<EventDetails> makeEventData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        /*String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                //BEST OF AMITECH
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz",
                //FUN Events
                "Stupid Cupid",
                "Tambola",
                "Beg Borrow Steal",
                //CULTURAL Events
                "Kalakaari",
                "Fashion Fingers",
                "Serenade",
                "Natraj"
        };

        desc = new String[]{
                "Welcome to the world of logical reasoning and brilliant articulation. Leave your mark as the best debtor and critical thinker.",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",

                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",
                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",
                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",

                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "FUN",
                "FUN",
                "FUN",
                "CULTURAL",
                "CULTURAL",
                "CULTURAL",
                "CULTURAL"
        };

        teamsize = new String[]{
                "2-4 Members",
                "3-8 Members",
                "2-5 Members",
                "Individual Participation",

                "Individual Participation",
                "2 Members",
                "Individual Participation",

                "6-10 Members",
                "3-8 Members",
                "7-9 Members",
                "2-5 Members"
        };

        rule = new String[]{"Rules are very important for any event read them. \nEach member can present one argument.\nCross questioning is not allowed, chill life.\nBring your own pen and paper.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",

                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",

                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."};

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018",

                "26 April 2018",
                "25 April 2018",
                "25 April 2018",

                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3",

                "Ground",
                "Booth 5",
                "Booth 8",

                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{
                1,
                2,
                3,
                4,
                1,
                2,
                3,
                1,
                2,
                3,
                4
        };

        image = new int[]{
                R.drawable.event_img1,
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5,
                R.drawable.event_img6,
                R.drawable.event_img1,
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5
        };*/

        EventCard.addAll(makeTechData());
        EventCard.addAll(makeFunData());
        EventCard.addAll(makeCultData());
        EventCard.addAll(makeSponData());
        EventCard.addAll(makeLitData());
        for (int i = 0; i < EventCard.size(); i++) {
            event_card = EventCard.get(i);
            event_card.card_category = "ALL EVENTS";
            event_card.card_pos = i + 1;
            EventCard.set(i, event_card);
        }

    /*for (int i = 0; i < pos.length; i++) {
        event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
        EventCard.add(event_card);
    }*/
        return EventCard;
    }

    public static ArrayList<EventDetails> makeBOAData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                //BEST OF AMITECH
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz"
        };

        desc = new String[]{
                "Welcome to the world of logical reasoning and brilliant articulation. Leave your mark as the best debtor and critical thinker.",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!"
        };

        cat = new String[]{
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH"
        };

        teamsize = new String[]{
                "2-4 Members",
                "3-8 Members",
                "2-5 Members",
                "Individual Participation"
        };

        rule = new String[]{"Rules are very important for any event read them. \nEach member can present one argument.\nCross questioning is not allowed, chill life.\nBring your own pen and paper.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{
                1,
                2,
                3,
                4,
        };
        image = new int[]{
                R.drawable.event_img5,
                R.drawable.event_img6,
                R.drawable.event_img1,
                R.drawable.event_img2
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeFunData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                "Stupid Cupid",
                "Tambola",
                "Beg Borrow Steal"
        };

        desc = new String[]{
                "This event does not feature bows and arrows sadly but you can still get lucky! ",
                "This event does not feature bows and arrows sadly but you can still get lucky! ",
                "This event does not feature bows and arrows sadly but you can still get lucky! "
        };

        cat = new String[]{
                "FUN",
                "FUN",
                "FUN"
        };

        teamsize = new String[]{
                "Individual Participation",
                "2 Members",
                "Individual Participation"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Ground",
                "Booth 5",
                "Booth 8"
        };

        pos = new int[]{
                1,
                2,
                3
        };
        image = new int[]{
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeCultData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Kalakaari",
                "Fashion Fingers",
                "Serenade",
                "Natraj"
        };

        desc = new String[]{
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "CULTURAL",
                "CULTURAL",
                "CULTURAL",
                "CULTURAL"
        };

        teamsize = new String[]{
                "6-10 Members",
                "3-8 Members",
                "7-9 Members",
                "2-5 Members"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{

                1,
                2,
                3,
                4
        };
        image = new int[]{
                R.drawable.event_img1,
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeSponData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Guess Who?",
                "Star Night"
        };

        desc = new String[]{
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "SPONSORED",
                "SPONSORED"
        };

        teamsize = new String[]{
                "6-10 Members",
                "3-8 Members"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "25 April 2018",
                "26 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage"
        };

        pos = new int[]{

                1,
                2
        };

        image = new int[]{
                R.drawable.event_img2,
                R.drawable.event_img3
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeTechData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Technovation",
                "Counter Strike",
                "Mini Militia",
                "Swish 'N' Click"
        };

        desc = new String[]{
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "TECHNICAL",
                "TECHNICAL",
                "TECHNICAL",
                "TECHNICAL"
        };

        teamsize = new String[]{
                "6-10 Members",
                "3-8 Members",
                "7-9 Members",
                "2-5 Members"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{

                1,
                2,
                3,
                4
        };

        image = new int[]{
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeLitData() { //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Ad Mad",
                "Power To Her",
                "Rumble Jumble",
                "You Me Mad"
        };

        desc = new String[]{
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "LITERARY",
                "LITERARY",
                "LITERARY",
                "LITERARY"
        };

        teamsize = new String[]{
                "6-10 Members",
                "3-8 Members",
                "7-9 Members",
                "2-5 Members"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{

                1,
                2,
                3,
                4
        };

        image = new int[]{
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public String getCard_title() {
        return this.card_title;
    }

    public String getCard_desc() {
        return this.card_desc;
    }

    public String getEvent_date() {
        return this.event_date;
    }

    public String getCard_category() {
        return this.card_category;
    }

    public String getEvent_members() {
        return this.event_members;
    }

    public String getEvent_location() {
        return this.event_location;
    }

    public String getEvent_rules() {
        return this.event_rules;
    }

    public int getEvent_img() {
        return this.event_img;
    }

    public int getEvent_favorite() {
        return this.event_favorite;
    }

    public void setEvent_favorite(int value) {
        this.event_favorite = value;
    }

    public int getCard_pos() {
        return this.card_pos;
    }
}
