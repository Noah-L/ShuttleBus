package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.consts.BookingType;
import com.oocl.shuttlebus.consts.Constant;
import com.oocl.shuttlebus.model.BusStop;
import com.oocl.shuttlebus.model.Route;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

public class StopActivity extends Activity {

	private Route route;

	private BusStop busStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stop_list);
		Bundle bundle = this.getIntent().getExtras();
		route = (Route) bundle.get("route");
		initView(bundle.getString("routeType"));
		List<HashMap<String, Object>> stopData = initStopData();
		initEvent(stopData);
		initButtonEvent();
	}

	private void initView(String routeType) {
		TextView textView = (TextView) this.findViewById(R.id.routeType);
		textView.setText(routeType + Constant.SUFFIX_ROUTE + Constant.PREFIX_ROUTE + route.getName());
	}

	private List<HashMap<String, Object>> initStopData() {
		List<BusStop> busStops = route.getStop();
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		if (busStops != null && busStops.size() > 0) {
			for (BusStop busStop : busStops) {
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("stopIcon", R.drawable.stop);
				item.put("stopName", busStop.getName());
				item.put("stop", busStop);
				datas.add(item);
			}
		}
		return datas;
	}

	private void initEvent(List<HashMap<String, Object>> stopData) {
		ListView listView = (ListView) this.findViewById(R.id.stopListView);
		SimpleAdapter adapter = new SimpleAdapter(this, stopData, R.layout.stop_item, new String[] { "stopIcon", "stopName" }, new int[] {
				R.drawable.stop, R.id.name });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());
	}

	private void initButtonEvent() {
		Button returnButton = (Button) this.findViewById(R.id.stop_ReturnButton);
		Button genTicButton = (Button) this.findViewById(R.id.stop_GenTicButton);

		returnButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Intent intent = new Intent(StopActivity.this, IndexActivity.class);
				startActivity(intent);
			}
		});

		genTicButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				confirmTicket();
			}
		});
	}

	public void confirmTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(createTicket());
		SharePreferenceHelper.addTickets(this.getApplicationContext(), tickets);
		Intent intent = new Intent(StopActivity.this, IndexActivity.class);
		startActivity(intent);
	}

	private Ticket createTicket() {
		Ticket ticket = new Ticket();
		User user = SharePreferenceHelper.getUser(this.getApplicationContext());
		ticket.setId(1L); // TODO
		ticket.setDate(new Date());
		ticket.setBusStop(busStop);
		ticket.setRoute(route);
		ticket.setType(getBookingType());
		ticket.setUser(user);
		return ticket;
	}

	private String getBookingType() {
		String bookingType = BookingType.TEMPORARY.getValue();
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.timeType);
		RadioButton radioButton = (RadioButton) this.findViewById(radioGroup.getCheckedRadioButtonId());
		String onlineBookingText = radioButton == null ? Constant.EMPTY_STRING : radioButton.getText() == null ? Constant.EMPTY_STRING
				: radioButton.getText().toString();
		if (BookingType.USUALLY.getText().equals(onlineBookingText)) {
			bookingType = BookingType.USUALLY.getValue();
		}
		return bookingType;
	}

	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
			busStop = (BusStop) data.get("stop");
		}
	}

}
