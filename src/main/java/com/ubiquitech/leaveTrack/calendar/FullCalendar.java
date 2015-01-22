package com.ubiquitech.leaveTrack.calendar;

/**
 * vane created on 2015/01/16.
 */
public class FullCalendar {
    String start;
    String end;
    String title;
    String color;

    public FullCalendar(String color, String title, String start, String end) {
        this.color = color;
        this.title = title;
        this.end = end;
        this.start = start;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
