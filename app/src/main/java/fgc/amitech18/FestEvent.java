package fgc.amitech18;

/**
 * Created by payal on 04-03-2018.
 */

public class FestEvent {
    private String eventName, eventVenue, eventTime, eventDate;
    private int imageID;
    FestEvent(String eventName, String eventVenue, String eventTime, String eventDate, int imageID) {
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.imageID = imageID;
    }
    public String getHead() {
        return eventName;
    }
    public String getEventTime() {
        return eventTime;
    }
    public String getEventVenue() {
        return eventVenue;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getImageID() {
        return imageID;
    }

}
