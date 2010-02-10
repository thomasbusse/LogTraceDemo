/**
* Change for git gui
*/

package com.tb.git.logtracedemo;

import com.tb.git.logtracedemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * LogTraceDemo
 * package renamed.
 * @author tbusse
 * 
 */
public class LogTraceDemo extends Activity {
	final String LOG_TAG = "LOGTRACEDEMO";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.v(LOG_TAG, "onCreate entered");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.v(LOG_TAG, "onCreate exited");
	}

	/** Will be connected with the buttons via XML */
	public void logClickHandler(View view) {
		switch (view.getId()) {
		case R.id.ButtonERROR:
			Log.e(LOG_TAG, "ButtonERROR was pressed!");
			break;
		case R.id.ButtonWARN:
			Log.w(LOG_TAG, "ButtonWARN was pressed!");
			break;
		case R.id.ButtonINFO:
			Log.i(LOG_TAG, "ButtonINFO was pressed!");
			break;
		case R.id.ButtonDEBUG:
			Log.d(LOG_TAG, "ButtonDEBUG was pressed!");
			break;
		case R.id.ButtonVERBOSE:
			Log.v(LOG_TAG, "ButtonVERBOSE was pressed!");
			break;
		}
	}

	/** Will be connected with the buttons via XML */
	public void logIsLoggableClickHandler(View view) {
		switch (view.getId()) {
		case R.id.ButtonERROR:
			if (Log.isLoggable(LOG_TAG, Log.ERROR)) {
				Log.e(LOG_TAG, "ButtonERROR (isLoggable) was pressed!");
			}
			break;
		case R.id.ButtonWARN:
			if (Log.isLoggable(LOG_TAG, Log.WARN)) {
				Log.w(LOG_TAG, "ButtonWARN (isLoggable) was pressed!");
			}
			break;
		case R.id.ButtonINFO:
			if (Log.isLoggable(LOG_TAG, Log.INFO)) {
				Log.i(LOG_TAG, "ButtonINFO (isLoggable) was pressed!");
			}
			break;
		case R.id.ButtonDEBUG:
			if (Log.isLoggable(LOG_TAG, Log.DEBUG)) {
				Log.d(LOG_TAG, "ButtonDEBUG (isLoggable) was pressed!");
			}
			break;
		case R.id.ButtonVERBOSE:
			if (Log.isLoggable(LOG_TAG, Log.VERBOSE)) {
				Log.v(LOG_TAG, "ButtonVERBOSE (isLoggable) was pressed!");
			}
			break;
		}
	}

	/** Will be connected with the buttons via XML */
	public void stackTraceClickHandler(View view) {
		StackTraceDemo std = new StackTraceDemo();
		// Call a method to create an exception which contains a stacktrace
		// which can be printed
		std.printStackTrace();
	}

}