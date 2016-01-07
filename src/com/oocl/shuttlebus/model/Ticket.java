package com.oocl.shuttlebus.model;
import com.oocl.shuttlebus.
/**
 * Created by LANLE on 1/7/2016.
 */
public class Ticket {
    private long id;
    private User user;
    private Route route;
    private BusStop busStop;
    private String type;
    private String date;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
