package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=12;
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
	// assertions
		 assertFalse(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(12, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);


		 startHour=21;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Kool Party";
		 description="This is my Kul party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
	

		//assertions
		assertEquals(0, appt1.compareTo(appt2));
	 }
	@Test
	 public void testRecure() throws Throwable {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 int[] recureDays = new int[]{1, 2, 3, 4, 5, 6, 7};
		 appt1.setRecurrence(null , 31, 1, 10);
		 appt1.setRecurrence(recureDays , 31, 1, 10);


		//assertions
	 	assertEquals(31, appt1.getRecurBy());
	 	assertEquals(recureDays, appt1.getRecurDays());
		assertEquals(1, appt1.getRecurIncrement());
		assertEquals(10, appt1.getRecurNumber());
	 }
 @Test
 public void testNotValid(){
		int startHour=50;
		int startMinute=10;
		int startDay=30;
		int startMonth=12;
		int startYear=100;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);
		int[] recureDays = new int[]{1, 2, 3, 4, 5, 6, 7};
		appt1.setRecurrence(null , 31, 1, 10);
		appt1.setRecurrence(recureDays , 31, 1, 10);

		assertEquals(false, appt1.getValid());
	 
		startHour=10;
		startMinute=61;
		startDay=30;
		startMonth=12;
		startYear=100;
		title="Birthday Party";
		description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt2 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);
		assertEquals(false, appt2. getValid());


		startHour=10;
		startMinute=40;
		startDay=32;
		startMonth=10;
		startYear=10;
		title="Birthday Party";
		description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt3 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);
		assertEquals(false, appt3. getValid());
 }
 @Test 
 public void setterTest(){
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);
		appt1.setStartHour(10);
		appt1.setStartMinute(51);
		appt1.setStartDay(30);
		appt1.setStartYear(10);

		Appt appt2 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);

		assertNotEquals(appt1, appt2);

	 
 }
 @Test
 public void toStringTest(){
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data	 
		Appt appt1 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						description);
		assertNotNull(appt1.toString());

 }
}

