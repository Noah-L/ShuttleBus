package com.oocl.shuttlebus.mockdata;

import com.google.gson.Gson;
import agiledon.codekata.refactoring.elearning.shuttlebus.BusStop;
import agiledon.codekata.refactoring.elearning.shuttlebus.Route;
import agiledon.codekata.refactoring.elearning.shuttlebus.Ticket;
import agiledon.codekata.refactoring.elearning.shuttlebus.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LANLE on 1/8/2016.
 */
public class MockData {

    public static List mockUserData() {
        User hra = new User();
        hra.setUserName("Hr");
        hra.setPassword("pwd");
        hra.setRole("HR");

        User passenger = new User();
        passenger.setUserName("Psg");
        passenger.setPassword("pwd");
        passenger.setRole("Passenger");
        Gson gson = new Gson();
        List userList = new ArrayList();
        userList.add(hra);
        userList.add(passenger);
        return userList;
    }

    public static List mockRoute() {
        BusStop stop1 = new BusStop();
        stop1.setName("紫荆园");
        BusStop stop2 = new BusStop();
        stop1.setName("海怡湾畔");
        BusStop stop3 = new BusStop();
        stop1.setName("公司");
        BusStop stop4 = new BusStop();
        stop1.setName("华子石西");
        BusStop stop5 = new BusStop();
        stop1.setName("白埔路口");
        BusStop stop6 = new BusStop();
        stop1.setName("吉大");
        BusStop stop7 = new BusStop();
        stop1.setName("九州城");
        BusStop stop8 = new BusStop();
        stop1.setName("唐家市场");

        List r7_on = new ArrayList();
        List r10_on = new ArrayList();
        List r11_on = new ArrayList();
        List r12_off = new ArrayList();
        List r10_off = new ArrayList();

        r7_on.add(stop1);
        r7_on.add(stop2);
        r7_on.add(stop3);

        r10_on.add(stop4);
        r10_on.add(stop5);
        r10_on.add(stop2);
        r10_on.add(stop3);

        r11_on.add(stop6);
        r11_on.add(stop7);
        r11_on.add(stop8);
        r11_on.add(stop3);

        r12_off.add(stop3);
        r12_off.add(stop5);
        r12_off.add(stop4);
        r12_off.add(stop1);

        r10_off.add(stop3);
        r10_off.add(stop2);
        r10_off.add(stop8);
        r10_off.add(stop7);
        r10_off.add(stop6);

        Route route1 = new Route();
        route1.setName("7");
        route1.setStop(r7_on);
        route1.setType("on");
        route1.setVacancy(50);

        Route route2 = new Route();
        route2.setName("10");
        route2.setStop(r10_on);
        route2.setType("on");
        route2.setVacancy(40);

        Route route3 = new Route();
        route3.setName("11");
        route3.setStop(r11_on);
        route3.setType("on");
        route3.setVacancy(50);

        Route route4 = new Route();
        route4.setName("10");
        route4.setStop(r12_off);
        route4.setType("off");
        route4.setVacancy(50);

        Route route5 = new Route();
        route5.setName("10");
        route5.setStop(r10_off);
        route5.setType("off");
        route5.setVacancy(40);

        List routeList = new ArrayList();
        routeList.add(route1);
        routeList.add(route2);
        routeList.add(route3);
        routeList.add(route4);
        routeList.add(route5);

        return routeList;
    }
}
