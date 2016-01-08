package com.oocl.shuttlebus.mockdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oocl.shuttlebus.model.Ticket;

public class MockSummaryData {

	public static Map<String, Integer> calculateVacancy(List<Ticket> tickets) {
		StringBuffer result = new StringBuffer();
		result.append("");
        Map<String, Integer> onTicketMap = new HashMap<String, Integer>();
        onTicketMap.put("on_7", 50);
        onTicketMap.put("on_10", 40);
        onTicketMap.put("on_11", 50);
        onTicketMap.put("off_13", 50);
        onTicketMap.put("off_14", 40);
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getRoute().getType().equals("on")) {
                onTicketMap.put("on_" + tickets.get(i).getRoute().getName(), onTicketMap.get("on_" + tickets.get(i).getRoute().getName()) - 1);
            }
            if (tickets.get(i).getRoute().getType().equals("off")) {
                onTicketMap.put("off_" + tickets.get(i).getRoute().getName(), onTicketMap.get("off_" + tickets.get(i).getRoute().getName()) - 1);
            }
        }
        return onTicketMap;
    }
}
