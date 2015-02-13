package com.ubiquitech.leaveTrack.calendar;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * vane created on 2015/01/16.
 */
@ResponseBody
public class FullCalendar {
    String start;
    String end;
    String title;
    String color;
    long id;

    public FullCalendar(String color, String title, String start, String end,long id) {
        this.color = color;
        this.title = title;
        this.end = end;
        this.start = start;

        this.id=id;

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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
