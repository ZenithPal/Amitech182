package fgc.amitech18;

import java.util.ArrayList;

public class Contact {
    private String mPhNumber;
    private String mpost;
    private String mname;
    private int mpic;

    public Contact(String post, String name, int pic, String phNumber) {
        mpost = post;
        mname = name;
        mpic = pic;
        mPhNumber = phNumber;
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

    public String getNumber() {
        return mPhNumber;
    }

    public static ArrayList<Contact> createContactList(){
        Contact contact_card;
        String[] conPost;
        String[] conName;
        int[] picture;
        String[] phNum;

        ArrayList<Contact> contacts=new ArrayList<Contact>();
        conPost = new String[]{
                "President",
                "Vice President",
                "Chief General Manager",
                "Secretary",
                "Joint Secretary",
                "Techmaster",
                "Director Finance",
                "Director Events",
                "Director Sponsorship",
                "Master Of Ceremonies",
                "Mistress Of Ceremonies",
                "Director Publication",
                "PR Executive",
                "Director Hospitality",
                "Director Creative",
                "Director Transport",
                "Director Discipline",
                "Treasurer",
                "Deputy Director Sponsorship",
                "Deputy Director Discipline",
                "Deputy Director Events",
                "Logistics Incharge",
                "Brand Ambassador(Male)",
                "Brand Ambassador(Male)",
                "Brand Ambassador(Female)",
                "Brand Ambassador(Female)",
                "Director Photography",
                "Deputy Director Photography"
        };
        conName = new String[]{
                "Ritvik Pandey",
                "Praveen Sharma",
                "Arjun Singh",
                "Anshu Mishra",
                "Diksha Giri",
                "Payal Joshi",
                "Vaibhav S. Adhikari",
                "Navneet",
                "Deepanshu Kakkar",
                "Harshit Rajpal",
                "Garima Kanwar",
                "Kritika",
                "Abhinav Kapoor",
                "Sahil Ahmad",
                "Pragyashree Jain",
                "Utkrisht Solanki",
                "Dhruv Meena",
                "Swatantra",
                "Himank",
                "Shekhar Jha",
                "Annie Goel ",
                "Deepanshu Prakash",
                "Harshit Bajaj",
                "Siddharth Arya",
                "Aastha Mishra",
                "Harshita Sachdeva",
                "Manit Ahuja",
                "Shabd Sharma"
        };
        picture=new int[]{
                R.drawable.ritvik,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.vaibhav,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.kritika,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.pragyashree,
                R.drawable.utkrisht,
                R.drawable.dhruv,
                R.drawable.swatantra,
                R.drawable.ic_launcher_background,
                R.drawable.shekhar,
                R.drawable.img_20180415_112238,
                R.drawable.deepanshu_prakash,
                R.drawable.harshit_bajaj,
                R.drawable.img_20180415_wa0040,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.manit_ahuja,
                R.drawable.new_shabd
        };

        phNum = new String[]
                {
                        "9643029728",
                        "9311215051",
                        "9582228699",
                        "9990139461",
                        "9582174670",
                        "9871721631",
                        "9810281120",
                        "9873296445",
                        "9654899213",
                        "9560625808",
                        "9958967469",
                        "9871960498",
                        "8800207169",
                        "8860472629",
                        "8569993463",
                        "8750752179",
                        "8130773871",
                        "8512093591",
                        "8802952920",
                        "7982109028",
                        "8376038306",
                        "7289961925",
                        "9717534370",
                        "9868492757",
                        null,
                        "7532029923",
                        "9650909981",
                        "9312368006"
                };
        for (int i = 0; i < 28; i++) {
            contact_card = new Contact(conPost[i], conName[i], picture[i], phNum[i]);
            contacts.add(contact_card);

        }
        return contacts;
    }
}