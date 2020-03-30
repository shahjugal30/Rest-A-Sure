package com.jugal.rest_a_sure;

public class Booking {


    String bookingid;
    String bookingname;
    String bookingdate;
    String bookingtime;
    String bookingguests;

    public Booking()
    {

    }

    public Booking(String bookingid, String bookingname, String bookingdate, String bookingtime, String bookingguests) {
        this.bookingid = bookingid;
        this.bookingname = bookingname;
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        this.bookingguests = bookingguests;
    }

    public String getBookingid() {
        return bookingid;
    }

    public String getBookingname() {
        return bookingname;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public String getBookingguests() {
        return bookingguests;
    }
}
