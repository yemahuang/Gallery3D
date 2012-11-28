package com.cooliris.mediayemaha;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class Tools {
	static final String ALARM_BROAD = "com.cooliris.mediayemaha.ALARM_ALERT";

	private Tools() {
	};

	static Calendar calculateAlarm(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, seconds);
		return calendar;
	}

	public static void enableAlert(Context paramContext, long time) {
		Intent intent = new Intent(ALARM_BROAD);//指定
		AlarmManager alarmManager = (AlarmManager) paramContext
				.getSystemService("alarm");
		alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent
				.getBroadcast(paramContext, 0, intent,
						PendingIntent.FLAG_CANCEL_CURRENT));
	}
}