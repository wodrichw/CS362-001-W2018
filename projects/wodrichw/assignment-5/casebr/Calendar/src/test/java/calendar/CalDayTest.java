package calendar;
import java.security.cert.TrustAnchor;
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

		int startHour=10;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=11;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
						 description);
		cal.addAppt(appt);
		appt =  new Appt((startHour - 3) % 24,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
						 description);
		cal.addAppt(appt);

		assertEquals(true, cal.isValid());
		assertEquals( 2, cal.getSizeAppts());
		assertTrue(cal.getAppts().get(0).getStartHour() < cal.getAppts().get(1).getStartHour());


		//assertions
		assertTrue(cal.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
