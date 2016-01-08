package com.example.shuttlebus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.oocl.shuttlebus.common.SharePreferenceHelper;
import com.oocl.shuttlebus.consts.Constant;
import com.oocl.shuttlebus.mockdata.MockSummaryData;
import com.oocl.shuttlebus.model.Ticket;

public class SummaryActivity extends Activity {
	TextView summaryText = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.summary);
		List<Ticket> tickets = SharePreferenceHelper.geTickets(getApplicationContext());
		List<HashMap<String, String>> summaryInfo = initData(tickets);
		initListViewEvent(summaryInfo);
		initButtonEvent();
	}
	
	private void initButtonEvent(){
		Button returnButton = (Button)findViewById(R.id.summary_ReturnButton);
		returnButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				closeActivity();
			}
		});
	}
	
	public void closeActivity() {
		this.finish();
	}
	
	private List<HashMap<String, String>> initData(List<Ticket> tickets) {
		Map<String, Integer> summaryMap = MockSummaryData.calculateVacancy(tickets);
		List<HashMap<String, String>> datas = new ArrayList<HashMap<String, String>>();
		Iterator<Map.Entry<String, Integer>> iterator = summaryMap.entrySet().iterator();
        while (iterator.hasNext()) {
        	Map.Entry<String, Integer> entry = iterator.next();
        	HashMap<String, String> item = new HashMap<String, String>();
			item.put("routeName", (entry.getKey().indexOf("on") > -1 ? "上班" : "下班") + "路线：" + Constant.PREFIX_ROUTE + entry.getKey().substring(entry.getKey().indexOf(( "_" )) + 1));
			item.put("vacancy", "剩餘空位： " + entry.getValue());
			datas.add(item);
        }
		return  datas;
	}
	
	private void initListViewEvent(List<HashMap<String, String>> summaryData) {
		ListView listView = (ListView) this.findViewById(R.id.summaryListView);
		SimpleAdapter adapter = new SimpleAdapter(this, summaryData, R.layout.summary_item, new String[] { "routeName", "vacancy"}, 
				new int[] {R.id.name, R.id.vacancy});
		listView.setAdapter(adapter);
	}
}
