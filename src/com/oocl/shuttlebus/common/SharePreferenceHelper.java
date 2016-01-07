package com.oocl.shuttlebus.common;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oocl.shuttlebus.model.Ticket;
import com.oocl.shuttlebus.model.User;

public class SharePreferenceHelper {
		private static final String PREF_USER = "default_user";
		public static boolean saveUser(Context context, User user){
			SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(context);
			SharedPreferences.Editor editor = setting.edit();
			editor.putString(PREF_USER, new Gson().toJson(user));
			return editor.commit();
		}
		
	    public static User getUser(Context context) {
			SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
			String userJson = settings.getString(PREF_USER, "");
			User user = new Gson().fromJson(userJson, User.class);
			return user;
		}
	    
	    private static final String PREF_TICKETS = "tickets";
	    public static boolean saveTickets(Context context, List<Ticket> tickets) {
			SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(context);
			SharedPreferences.Editor editor = setting.edit();
			editor.putString(PREF_TICKETS, new Gson().toJson(tickets));
			return editor.commit();
	    }
	    
	    public static List<Ticket> geTickets(Context context) {
			SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
			String ticketsJson = settings.getString(PREF_TICKETS, "");
			return new Gson().fromJson(ticketsJson, new TypeToken<List<Ticket>>(){}.getType());
		}
}
