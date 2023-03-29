package vtigerGenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtilities {

	/**
	 * This method will provide the system date
	 * @return
	 */
	public String getSystemDate() 
	{ 
		Date d = new Date();
		return d.toString();
					
	}

	/**
	 * This method will provide the system date in specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String date[] = d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = date1+" "+month+" "+year+" "+time;
		return finalDate;
		
	}
	
	/**
	 * This method will return a random number for every run
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random r = new Random();
		return r.nextInt(1000);
		
	}

}
