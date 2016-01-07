package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
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
		initView();
		List<HashMap<String, Object>> stopData = initStopData();
		initEvent(stopData);
	}

	private void initView() {
		TextView textView = (TextView) this.findViewById(R.id.routName);
		textView.setText(Constant.PREFIX_ROUTE + route.getName());
	}

	private List<HashMap<String, Object>> initStopData() {
		List<BusStop> busStops = route.getStop();
		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		if (busStops != null && busStops.size() > 0) {
			for (BusStop busStop : busStops) {
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("stopName", busStop.getName());
				item.put("stop", busStop);
				datas.add(item);
			}
		}
		return datas;
	}

	private void initEvent(List<HashMap<String, Object>> stopData) {
		ListView listView = (ListView) this.findViewById(R.id.stopListView);
		SimpleAdapter adapter = new SimpleAdapter(this, stopData, R.layout.stop_item, new String[] { "stopName" }, new int[] { R.id.name });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClickListener());
	}

	public void confirmTicket(View view) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(createTicket());
		SharePreferenceHelper.saveTickets(this.getApplicationContext(), tickets);
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
		ticket.setType(getTimeType());
		ticket.setUser(user);
		return ticket;
	}

	// TODO method name refactoring
	private String getTimeType() {
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.timeType);
		RadioButton radioButton = (RadioButton) this.findViewById(radioGroup.getCheckedRadioButtonId());
		return radioButton == null ? Constant.EMPTY_STRING : radioButton.getText() == null ? Constant.EMPTY_STRING : radioButton.getText()
				.toString();
	}

	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
			busStop = (BusStop) data.get("stop");
		}
	}

}
