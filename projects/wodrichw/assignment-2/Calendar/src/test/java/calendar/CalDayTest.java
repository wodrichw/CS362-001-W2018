package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		/** the month the user is currently viewing **/
		int thisMonth;
		
		/** the year the user is currently viewing **/
		 int thisYear;
		
		/** todays date **/
		int thisDay;


		Calendar rightnow = Calendar.getInstance();
		thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay cal = new CalDay(today);

		//assertions
		assertTrue(cal.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
