package com.example.kmeproject;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InferanceEngine {

	// this method is going to be called from the ui
	// to make inferances , the output should be
	// a single string of one of the categories
    public static String getCategory(ArrayList<String> lines, ArrayList<String> elementsOfDesign, ArrayList<String> colors, ArrayList<String> budget) {

		int[] res = {0,0,0,0,0};
		ArrayList<String> out = new ArrayList<String>();

		out.add(Constants.MODERNIST);
		out.add(Constants.CLASSIC_MODERN);
		out.add(Constants.CLASSIC);
		out.add(Constants.MODERN_MINIMALIST);
		out.add(Constants.MINIMALIST);


		for (String e : elementsOfDesign) {
			switch (e) {
				case Constants.MID_RANGE:
					res[out.indexOf(Constants.CLASSIC_MODERN)] += 1;
					break;
				case Constants.SUPER_SIMPLE:
					res[out.indexOf(Constants.MODERN_MINIMALIST)] += 1;
					break;
				case Constants.DETAILED:
					res[out.indexOf(Constants.CLASSIC_MODERN)] += 1;
					res[out.indexOf(Constants.CLASSIC)] += 1;
					break;
				case Constants.SIMPLE:
					res[out.indexOf(Constants.MODERNIST)] += 1;
					res[out.indexOf(Constants.MODERN_MINIMALIST)] += 1;
					break;
			}
		}

		for (String b : budget) {
			switch (b) {
				case Constants.LOW:
					res[out.indexOf(Constants.MINIMALIST)] += 1;
					break;
				case Constants.AVERAGE:
					res[out.indexOf(Constants.MODERNIST)] += 1;
					break;
				case Constants.HIGH:
					res[out.indexOf(Constants.CLASSIC)] += 1;
					break;
			}
		}

		for (String l : lines) {
			switch (l) {
				case Constants.CURVED_LINES:
					res[out.indexOf(Constants.CLASSIC)] += 1;
					break;
				case Constants.CURVED_WITH_STRAIGHT:
					res[out.indexOf(Constants.CLASSIC_MODERN)] += 1;
					break;
				case Constants.STRAIGHT_LINES:
					res[out.indexOf(Constants.MODERN_MINIMALIST)] += 1;
					break;
			}
		}

		for (String c : colors) {
			switch (c) {
				case Constants.MID_TONE:
					res[out.indexOf(Constants.CLASSIC)] += 1;
					break;
			}
		}


		int maxAt = 0;

		for (int i = 0; i < res.length; i++) {
			maxAt = res[i] > res[maxAt] ? i : maxAt; // Find the max index
		}


		// Print the result and return
		Log.i("INFERENCE", out.get(maxAt));

		return out.get(maxAt);


    }



}
