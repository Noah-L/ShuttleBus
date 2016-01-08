package com.example.shuttlebus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oocl.shuttlebus.common.DateHelper;
import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

public class TicketActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket);
		initButtonEvent();
		
		
		User user = SharePreferenceHelper.getUser(getApplicationContext());		
		List<Ticket> tickets = SharePreferenceHelper.geTickets(getApplicationContext());
		
		List<Ticket> filterTickets = new ArrayList<Ticket>();
		if(tickets!=null){
			for(Ticket ticket : tickets){
				Date date = new Date();
				if(DateHelper.areSameDay(ticket.getDate(),date) && ticket.getUser().getUserName().equals(user.getUserName())){
					filterTickets.add(ticket);
				}
			}
		}
		
		Ticket firstTicket = null;
		Ticket secondeTicket = null;
		if(filterTickets.size()>1){
			firstTicket = filterTickets.get(0);
			secondeTicket = filterTickets.get(1);
			initTicketView(firstTicket,secondeTicket);
		}
		if(filterTickets.size()==1){
			firstTicket = filterTickets.get(0);
			initTicketView(firstTicket,secondeTicket);
		}
		if(filterTickets.size()==0){
			initTicketView(firstTicket,secondeTicket);
			Toast.makeText(getApplicationContext(), "您还没有任何票据信息", 3).show();
		}
	}
	
	private void initTicketView(Ticket firstTicket, Ticket secondTicket){
		SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd"); 
		
		if(firstTicket==null){
			LinearLayout layout = (LinearLayout)findViewById(R.id.ticket1);
			layout.setVisibility(View.INVISIBLE);
		}else{
			TextView nameOfFirstTicket = (TextView)findViewById(R.id.nameOfFirstTicket);
			TextView routeOfFirstTicket = (TextView)findViewById(R.id.routeOfFirstTicket);
			TextView stopOfFirstTicket = (TextView)findViewById(R.id.stopOfFirstTicket);
			TextView typeOfFirstTicket = (TextView)findViewById(R.id.typeOfFirstTicket);
			
			nameOfFirstTicket.setText("姓名 : "+firstTicket.getUser().getUserName());
			String routeType = firstTicket.getRoute().getType();
		    if(routeType.equals("on")){
		    	routeOfFirstTicket.setText("路线: "+firstTicket.getRoute().getName()+" 上班");
		    }else{
		    	routeOfFirstTicket.setText("路线: "+firstTicket.getRoute().getName()+" 下班");
		    }
			stopOfFirstTicket.setText("站点: "+firstTicket.getBusStop().getName());
			
			String type = firstTicket.getType();
			if(type.equals("长期预定")){
				typeOfFirstTicket.setText("类型: "+firstTicket.getType());
			}else{
				typeOfFirstTicket.setText("类型: "+firstTicket.getType() +" "+format.format(firstTicket.getDate()));	
			}
		}

		if(secondTicket==null){
			LinearLayout layout = (LinearLayout)findViewById(R.id.ticket2);
			layout.setVisibility(View.INVISIBLE);
		}else{
			TextView nameOfSecondTicket = (TextView)findViewById(R.id.nameOfSecondTicket);
			TextView routeOfSecondTicket = (TextView)findViewById(R.id.routeOfSecondTicket);
			TextView stopOfSecondTicket = (TextView)findViewById(R.id.stopOfSecondTicket);
			TextView typeOfSecondTicket = (TextView)findViewById(R.id.typeOfSecondTicket);
			
			nameOfSecondTicket.setText("姓名 : "+secondTicket.getUser().getUserName());
			
			String routeType = secondTicket.getRoute().getType();
		    if(routeType.equals("on")){
		    	routeOfSecondTicket.setText("路线: "+firstTicket.getRoute().getName()+" 上班");
		    }else{
		    	routeOfSecondTicket.setText("路线: "+firstTicket.getRoute().getName()+" 下班");
		    }
			routeOfSecondTicket.setText("路线: "+secondTicket.getRoute().getName());
			stopOfSecondTicket.setText("站点: "+secondTicket.getBusStop().getName());
			String type = secondTicket.getType();
			if(type.equals("长期预定")){
				typeOfSecondTicket.setText("类型: "+secondTicket.getType());
			}else{
				typeOfSecondTicket.setText("类型: "+secondTicket.getType() +" "+format.format(secondTicket.getDate()));	
			}
		}
	}
	
	private void initButtonEvent() {
		Button returnButton = (Button) findViewById(R.id.returnButton);
		returnButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(TicketActivity.this, IndexActivity.class);
				startActivity(intent);
			}
		});
	}


}
