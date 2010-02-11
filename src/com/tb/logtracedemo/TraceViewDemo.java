package com.tb.logtracedemo;

import android.util.Log;

/**
 * This class demonstrates the use of TraceView (Profiling)
 * @author tbusse
 *
 */
public class TraceViewDemo {
	final String LOG_TAG = "TRACEVIEWDEMO";
	
	public void startMethod() {
		Log.v(LOG_TAG, "startMethod entered");
	}
}
