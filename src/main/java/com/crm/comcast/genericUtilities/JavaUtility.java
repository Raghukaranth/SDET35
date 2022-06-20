package com.crm.comcast.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * contains java Specific library like 
 * getRandomdata, getSystemDate, etc
 * 
 * @author Raghavendra Karanth S
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate random numbers within range of 100
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int ranNum = random.nextInt(100);
		return ranNum;
	}
	
	/**
	 * to get System Date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTimeInISTFormat() {
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * used to get system date based on YYYY-MM-DD format
	 * @return
	 */
	public String getSystemTimeInStandardFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM =date.getMonth()+1;
		
		String finalFormat = yyyy+" "+DD+" "+MM;
		return finalFormat;
	}
}
