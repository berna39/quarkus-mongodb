package com.terminator.event;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Event extends PanacheMongoEntity {

    private String title;
    private String detail;

    public Event(){

    }

    public Event(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
