package com.oocl.shuttlebus.mockdata;

import com.google.gson.Gson;
import com.oocl.shuttlebus.model.BusStop;
import com.oocl.shuttlebus.model.Route;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LANLE on 1/8/2016.
 */
public class MockData {

    public static List<User> mockUserData() {
        User hra = new User();
        hra.setId(10001);
        hra.setUserName("Hr");
        hra.setPassword("pwd");
        hra.setRole("HR");

        User passenger = new User();
        passenger.setId(10002);
        passenger.setUserName("Psg");
        passenger.setPassword("pwd");
        passenger.setRole("Passenger");
        Gson gson = new Gson();
        List<User> userList = new ArrayList<User>();
        userList.add(hra);
        userList.add(passenger);
        return userList;
    }

    public static List<Route> mockRoute() {
        BusStop stop1 = new BusStop();
        stop1.setId(20001);
        stop1.setName("紫荆园");
        BusStop stop2 = new BusStop();
        stop2.setId(20002);
        stop2.setName("海怡湾畔");
        BusStop stop3 = new BusStop();
        stop3.setId(20003);
        stop3.setName("公司");
        BusStop stop4 = new BusStop();
        stop4.setId(20004);
        stop4.setName("华子石西");
        BusStop stop5 = new BusStop();
        stop5.setId(20005);
        stop5.setName("白埔路口");
        BusStop stop6 = new BusStop();
        stop6.setId(20006);
        stop6.setName("吉大");
        BusStop stop7 = new BusStop();
        stop7.setId(20007);
        stop7.setName("九州城");
        BusStop stop8 = new BusStop();
        stop8.setId(20008);
        stop8.setName("唐家市场");
        BusStop stop9 = new BusStop();
        stop9.setId(20009);
        stop9.setName("唐家");
        BusStop stop10 = new BusStop();
        stop10.setId(20010);
        stop10.setName("中大五院");
        BusStop stop11 = new BusStop();
        stop11.setId(20011);
        stop11.setName("香洲總站");
        List<BusStop> r7_on = new ArrayList<BusStop>();
        List<BusStop> r10_on = new ArrayList<BusStop>();
        List<BusStop> r11_on = new ArrayList<BusStop>();
        List<BusStop> r12_off = new ArrayList<BusStop>();
        List<BusStop> r10_off = new ArrayList<BusStop>();

        r7_on.add(stop1);
        r7_on.add(stop2);
        r7_on.add(stop3);
        r7_on.add(stop11);
        r7_on.add(stop10);


        r10_on.add(stop4);
        r10_on.add(stop5);
        r10_on.add(stop2);
        r10_on.add(stop8);
        r10_on.add(stop9);
        r10_on.add(stop3);

        r11_on.add(stop6);
        r11_on.add(stop7);
        r11_on.add(stop8);
        r11_on.add(stop11);
        r11_on.add(stop10);
        r11_on.add(stop3);


        r12_off.add(stop3);
        r12_off.add(stop5);
        r12_off.add(stop4);
        r12_off.add(stop1);
        r12_off.add(stop6);
        r12_off.add(stop7);
        r12_off.add(stop9);


        r10_off.add(stop3);
        r10_off.add(stop2);
        r10_off.add(stop8);
        r10_off.add(stop7);
        r10_off.add(stop6);
        r10_off.add(stop5);
        r10_off.add(stop4);

        Route route1 = new Route();
        route1.setId(30001);
        route1.setName("7");
        route1.setStop(r7_on);
        route1.setType("on");
        route1.setVacancy(50);

        Route route2 = new Route();
        route2.setId(30002);
        route2.setName("10");
        route2.setStop(r10_on);
        route2.setType("on");
        route2.setVacancy(40);

        Route route3 = new Route();
        route3.setId(30003);
        route3.setName("11");
        route3.setStop(r11_on);
        route3.setType("on");
        route3.setVacancy(50);

        Route route4 = new Route();
        route4.setId(30004);
        route4.setName("13");
        route4.setStop(r12_off);
        route4.setType("off");
        route4.setVacancy(50);

        Route route5 = new Route();
        route5.setId(30005);
        route5.setName("14");
        route5.setStop(r10_off);
        route5.setType("off");
        route5.setVacancy(40);

        List<Route> routeList = new ArrayList<Route>();
        routeList.add(route1);
        routeList.add(route2);
        routeList.add(route3);
        routeList.add(route4);
        routeList.add(route5);

        return routeList;
    }

    public static List<Ticket> mockTicket() {
        User passenger = new User();
        passenger.setId(10002);
        passenger.setUserName("Psg");
        passenger.setPassword("pwd");
        passenger.setRole("Passenger");

        Route route1 = new Route();
        route1.setId(30001);
        route1.setName("7");
        route1.setType("on");
        route1.setVacancy(50);

        Route route2 = new Route();
        route2.setId(30001);
        route2.setName("7");
        route2.setType("on");
        route2.setVacancy(50);
        
        Route route3 = new Route();
        route3.setId(30001);
        route3.setName("10");
        route3.setType("off");
        route3.setVacancy(50);

        Route route4 = new Route();
        route4.setId(30001);
        route4.setName("10");
        route4.setType("off");
        route4.setVacancy(50);
        
        BusStop stop1 = new BusStop();
        stop1.setId(20002);
        stop1.setName("海怡湾畔");

        BusStop stop2 = new BusStop();
        stop2.setId(2004);
        stop2.setName("华子石西");

        Ticket onLongTicket = new Ticket();
        onLongTicket.setId(40001);
        onLongTicket.setUser(passenger);
        onLongTicket.setType("long");
        onLongTicket.setRoute(route2);
        onLongTicket.setBusStop(stop1);
        onLongTicket.setDate(new Date());


        Ticket offTempTicket = new Ticket();
        offTempTicket.setId(40002);
        offTempTicket.setUser(passenger);
        offTempTicket.setType("temp");
        offTempTicket.setRoute(route4);
        offTempTicket.setBusStop(stop2);
        offTempTicket.setDate(new Date());
        
        Ticket onLongTicket1 = new Ticket();
        onLongTicket1.setId(40001);
        onLongTicket1.setUser(passenger);
        onLongTicket1.setType("long");
        onLongTicket1.setRoute(route1);
        onLongTicket1.setBusStop(stop1);
        onLongTicket1.setDate(new Date());


        Ticket offTempTicket1 = new Ticket();
        offTempTicket1.setId(40002);
        offTempTicket1.setUser(passenger);
        offTempTicket1.setType("temp");
        offTempTicket1.setRoute(route3);
        offTempTicket1.setBusStop(stop2);
        offTempTicket1.setDate(new Date());

        List<Ticket> ticketList = new ArrayList<Ticket>();
        ticketList.add(onLongTicket);
        ticketList.add(offTempTicket);


        return ticketList;
    }

}
