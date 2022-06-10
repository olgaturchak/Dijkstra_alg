package com.company;

import java.time.Duration;
import java.time.LocalTime;

public class Event {

    LocalTime start;
    LocalTime finish;
    String title;
    double price;

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Event of(LocalTime start, LocalTime finish, String title, double price) {
        Event event = new Event();
        event.start = start;
        event.finish = finish;
        event.title = title;
        event.price = price;

        return event;
    }


    @Override
    public String toString() {
        return "Event -- band <** " + title + " **> " + "price=" + price +
                ", start - " + start +
                ", finish - " + finish +
                ", duration: " + getDuration() + " min ***"+ "\n";
    }

    public Duration getDuration(){
        Duration duration = Duration.between(start, finish);
        return duration;
    }
}
