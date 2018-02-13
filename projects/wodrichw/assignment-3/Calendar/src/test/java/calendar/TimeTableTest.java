package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	
	//test getAptRang();
	 @Test
	  public void test01()  throws Throwable  {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
	
		/** the month the user is currently viewing **/
		int thisMonth;
		
		/** the year the user is currently viewing **/
		 int thisYear;
		
		/** todays date **/
		int thisDay;
		
			//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
		 
		 listAppts.add(appt);
		  
	      // create another appointment
		 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
			  startMinute ,
			  startDay ,
			  startMonth ,
			  startYear ,
			  title,
			 description);
		/*	
		 if(diagnose){
			System.out.println(appt.toString());
		 }*/
		 listAppts.add(appt);
		 // create another appointment
		 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
			  startMinute ,
			  startDay ,
			  startMonth ,
			  startYear ,
			  title,
			 description);
		 listAppts.add(appt);
		 // create another appointment
		 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
			  startMinute ,
			  startDay ,
			  startMonth ,
			  startYear ,
			  title,
			 description);
		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		
		 listAppts.add(appt);



		 
		//get a list of appointments for one day, which is today
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		TimeTable timeTable=new TimeTable();
		//Create a linked list of calendar days to return
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		assertNotEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));
	 }

	 //test delete
	 @Test
	  public void test02()  throws Throwable  {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
	
		/** the month the user is currently viewing **/
		int thisMonth;
		
		/** the year the user is currently viewing **/
		 int thisYear;
		
		/** todays date **/
		int thisDay;
		
			//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
		 
		 listAppts.add(appt);


		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		TimeTable timeTable=new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		int[] pv = new int[] {0};

		LinkedList<Appt> shuffle = timeTable.permute(listAppts, pv);

		assertNotNull(shuffle);
	 }




	 @Test
	  public void deleteFromTable()  throws Throwable  {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
	
		/** the month the user is currently viewing **/
		int thisMonth;
		
		/** the year the user is currently viewing **/
		 int thisYear;
		
		/** todays date **/
		int thisDay;
		
			//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
		 
		 listAppts.add(appt);


		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		TimeTable timeTable=new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);



		LinkedList<Appt> deleted = timeTable.deleteAppt(listAppts, appt);

		assertNull(deleted);
		
		
	 }
	
	 @Test
	  public void recurse()  throws Throwable  {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
	
		/** the month the user is currently viewing **/
		int thisMonth;
		
		/** the year the user is currently viewing **/
		 int thisYear;
		
		/** todays date **/
		int thisDay;
		
			//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
		 

		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

		 listAppts.add(appt);

		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		TimeTable timeTable=new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);


		assertNotNull(calDays);

		 Appt appt2 = new Appt(startHour,
			  startMinute ,
			  startDay ,
			  startMonth ,
			  startYear ,
			  title,
			 description);
		 
		listAppts = new LinkedList<Appt>();

		 int[] recurdaysarr={2,3,4};
		 appt2.setRecurrence( recurdaysarr, Appt.RECUR_BY_WEEKLY, 0, Appt.RECUR_NUMBER_NEVER);

		listAppts.add(appt2);

		today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		timeTable=new TimeTable();
		LinkedList<CalDay> calDays1 = new LinkedList<CalDay>();
		calDays1 = timeTable.getApptRange(listAppts, today, tomorrow);



		assertNotEquals(calDays1, calDays);
	 }
}
