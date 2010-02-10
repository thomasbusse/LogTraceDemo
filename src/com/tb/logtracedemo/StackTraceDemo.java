package com.tb.logtracedemo;

import android.util.Log;

/**
 * This class calls a few of it's own methods to demo the stack trace
 * capabilities.
 * 
 * @author tbusse
 * 
 */
public class StackTraceDemo {
	final String LOG_TAG = "STACKTRACEDEMO";

	public void innerMethod(int inner) throws IndexOutOfBoundsException {
		Log.i(LOG_TAG, "innerMethod entered");
		System.out.println(inner + 1);
		if (inner > 11) {
			// too big
			throw new IndexOutOfBoundsException();
		}
		Log.i(LOG_TAG, "innerMethod exited");
	}

	public void middleMethod(int middle) {
		Log.i(LOG_TAG, "middleMethod entered");
		Log.i(LOG_TAG, "calling innerMethod");
		innerMethod(middle + 1);
		Log.i(LOG_TAG, "middleMethod exited");
	}

	public void outerMethod(int outer) {
		Log.i(LOG_TAG, "outerMethod entered");
		Log.i(LOG_TAG, "calling middleMethod");
		middleMethod(outer + 1);
		Log.i(LOG_TAG, "outerMethod exited");
	}

	public void printStackTrace() {
		Log.i(LOG_TAG, "printStackTrace entered");
		try {
			outerMethod(10);
		} catch (Exception e) {
			// handle exception: in this case here print the stack trace of the throwable
			String st;
			// Once we got the throwable (exception) we can get the stack trace and print it
			st = Log.getStackTraceString(e);
			Log.i(LOG_TAG, st);
		}
	}

}
