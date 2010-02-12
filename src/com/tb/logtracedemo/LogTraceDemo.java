package com.tb.logtracedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;

/**
 * LogTraceDemo
 * @author tbusse
 * 3
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

	/** EXAMPLE: Logging */
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
			// Log.println(Log.VERBOSE, LOG_TAG, "ButtonLogVerbose println was pressed!");
			break;
		case R.id.ButtonLogASSERT:
			Log.println(Log.ASSERT, LOG_TAG, "ButtonLogASSERT was pressed!");
			break;
		}
	}

	/** EXAMPLE: isLoggable */
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
		case R.id.ButtonLogASSERT:
			if (Log.isLoggable(LOG_TAG, Log.ASSERT)) {
				Log.println(Log.ASSERT, LOG_TAG, "ButtonLogASSERT (isLoggable) was pressed!");
			}
			break;
		}
	}

	/** EXAMPLE: Stacktrace */
	public void stackTraceClickHandler(View view) {
		StackTraceDemo std = new StackTraceDemo();
		// Call a method to create an exception which contains a stacktrace
		// which can be printed
		std.printStackTrace();
	}

	/** EXAMPLE: Assertions */
	public void assertClickHandler(View view) {
		switch (view.getId()) {
		case R.id.ButtonAssertSimple:
			assert false;
			break;
		case R.id.ButtonAssertWithMsg:
			assert false : "My assert message";
			break;
		}
	}

	/** EXAMPLE: TraceView */
	public void traceViewClickHandler(View view) {
		// Create trace file with starting the method tracing
		Debug.startMethodTracing( "LogTraceDemo" );
		// Create an example class
		TraceViewDemo tvd = new TraceViewDemo();
		// Call a method to demonstrate profiling
		tvd.startMethod();
		// Stop method tracing
		Debug.stopMethodTracing();
	}

}