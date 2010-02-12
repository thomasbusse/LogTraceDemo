package com.tb.logtracedemo;

import android.util.Log;

/**
 * This class demonstrates the use of TraceView (Profiling)
 * 
 * @author tbusse
 * 
 */
public class TraceViewDemo {
	final String LOG_TAG = "TRACEVIEWDEMO";

	public void startMethod() {
		Log.v(LOG_TAG, "startMethod entered");
		calculatePiSlow();
	}

	// Calculate pi: slowly converging series
	public void calculatePiSlow() {
		final int N = 1000; // # of terms
		double sum = 0.0; // final sum
		double term; // term without sign
		double sign = 1.0; // sign on each term
		for (int k = 0; k < N; k++) {
			term = 1.0 / (2.0 * k + 1.0);
			// sum = sum + sign * term;
			sum = add( sum, mult(sign, term) );
			if (k % (N / 50) == 0) // print one in 50
				print("k: " + k + ", " + sum + ", pi: " + sum * 4.0);
			sign = -sign;
		}
		print("Final pi (approx., " + N + " terms): " + sum * 4.0);
		print("Actual pi: " + Math.PI);
	}

	// Just adds two numbers
	// Returns a + b
	private double add( double a, double b ) {
		double c;
		c = a + b;
		return c;
	}

	// Just multiplies two numbers
	// Returns a * b
	private double mult( double a, double b ) {
		double c;
		c = a * b;
		return c;
	}
	
	// Print to system.out
	private void print( String s ) {
		System.out.println( s );
	}

}
