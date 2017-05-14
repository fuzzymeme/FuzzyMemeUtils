package com.fuzzymeme.utils;

import java.text.DecimalFormat;

/**
 * Number formatter - how I like my numbers formatted.     
 */

public class NumberFormatter {
	
	private DecimalFormat standardFormat = new DecimalFormat("#,###,###,##0.##"); 
	private DecimalFormat scientificFormat = new DecimalFormat("##0.###E0"); 
	private double switchThreshold = 1000000000; // Threshold above which the number will be displayed in scientific notation
	
	public void setScientificFormat(String newFormat){
		scientificFormat = new DecimalFormat(newFormat);
		scientificFormat.setMinimumFractionDigits(0);  // To avoid the showing 5.0E-6 and 12E-6 
	}

	public void setStandardFormat(String newFormat){
		standardFormat = new DecimalFormat(newFormat);
	}

	public void setSwitchThreshold(double newThreshold){
		switchThreshold = newThreshold;
	}
	
	public String format(String string){
		
		// Format the label using the decimal formatter if it is a number
		try {
			string = format(Double.parseDouble(string));
		} catch (NumberFormatException e) {
			// It's OK to get an exception, the label will be returned 
			// without any changes because it doesn't parse as a number and
			// therefore shouldn't be formatted as a number
		}
		return string;
	}
	
	public String format(double d){

		if(d == 0.0){
			return "0.0";
		}
		
		if( Math.abs(d) > switchThreshold || Math.abs(d) < 0.01){
			return scientificFormat.format(d);
		}
		else{
			return standardFormat.format(d);
		}
	}

}

