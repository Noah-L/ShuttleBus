package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.mockdata.MockData;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

public class TicketActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket);
		
		List<Ticket> mockupDatas =  MockData.mockTicket();
		SharePreferenceHelper.saveTickets(getApplicationContext(), mockupDatas);
		
		User user = SharePreferenceHelper.getUser(getApplicationContext());		
		List<Ticket> tickets = SharePreferenceHelper.geTickets(getApplicationContext());
		
		List<Ticket> filterTickets = new ArrayList<Ticket>();
		for(Ticket ticket : tickets){
			Date date = new Date();
			if(ticket.getUser().getId()== user.getId() && areSameDay(ticket.getDate(),date)){
				filterTickets.add(ticket);
			}
		}
		
		if(filterTickets.size()>1){
			Ticket firstTicket = tickets.get(0);
			Ticket secondeTicket = tickets.get(1);
			initTicketView(firstTicket,secondeTicket);
		}
	}
	
	public boolean areSameDay(Date dateA,Date dateB) {
	    Calendar calDateA = Calendar.getInstance();
	    calDateA.setTime(dateA);

	    Calendar calDateB = Calendar.getInstance();
	    calDateB.setTime(dateB);

	    return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
	            && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
	            &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
	}
	
	private void initTicketView(Ticket firstTicket, Ticket secondTicket){
		TextView nameOfFirstTicket = (TextView)findViewById(R.id.nameOfFirstTicket);
		TextView routeOfFirstTicket = (TextView)findViewById(R.id.routeOfFirstTicket);
		TextView stopOfFirstTicket = (TextView)findViewById(R.id.stopOfFirstTicket);
		TextView typeOfFirstTicket = (TextView)findViewById(R.id.typeOfFirstTicket);
		
		nameOfFirstTicket.setText("姓名 : "+firstTicket.getUser().getUserName());
		routeOfFirstTicket.setText("路线: "+firstTicket.getRoute().getName());
		stopOfFirstTicket.setText("站点: "+firstTicket.getBusStop().getName());
		typeOfFirstTicket.setText("类型: "+firstTicket.getType() +""+firstTicket.getDate());
		
		TextView nameOfSecondTicket = (TextView)findViewById(R.id.nameOfSecondTicket);
		TextView routeOfSecondTicket = (TextView)findViewById(R.id.routeOfSecondTicket);
		TextView stopOfSecondTicket = (TextView)findViewById(R.id.stopOfSecondTicket);
		TextView typeOfSecondTicket = (TextView)findViewById(R.id.typeOfSecondTicket);
		
		nameOfSecondTicket.setText("姓名 : "+secondTicket.getUser().getUserName());
		routeOfSecondTicket.setText("路线: "+secondTicket.getRoute().getName());
		stopOfSecondTicket.setText("站点: "+secondTicket.getBusStop().getName());
		typeOfSecondTicket.setText("类型: "+secondTicket.getType() +"" + secondTicket.getDate());
	}


}
