package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

import org.junit.Test;

import sun.util.calendar.Gregorian;

import static org.junit.Assert.*;



public class TimeTableRandomTest {
    private static final long TestTimeout = 1000 * 5; /* Timeout at 10 seconds */
    private static final int NUM_TESTS=100;
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"delete","getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	


        
	 @Test
	  public void TableTester()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.print("Starting Testing Delete Apt Test...");

        try{
            for (int i = 0; elapsed < TestTimeout; i++){
                TimeTable timeTable = new TimeTable();

                LinkedList<Appt> appts = new LinkedList<Appt>();           
                    long randomseed = System.currentTimeMillis();
                    Random random = new Random(randomseed);
                    int startHour=ValuesGenerator.RandInt(random);
                    int startMinute=ValuesGenerator.RandInt(random);
                    int startDay=ValuesGenerator.RandInt(random);
                    int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    int startYear=ValuesGenerator.RandInt(random);
                    

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

                        appts.add(appt);
                    startHour=ValuesGenerator.RandInt(random);
                    startMinute=ValuesGenerator.RandInt(random);
                    startDay=ValuesGenerator.RandInt(random);
                    startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    startYear=ValuesGenerator.RandInt(random);
                    

                    title="Birthday Party";
                    description="This is my birthday party.";
                    //Construct a new Appointment object with the initial data	 
                    appt = new Appt(startHour,
                            startMinute ,
                            startDay ,
                            startMonth ,
                            startYear ,
                            title,
                            description);

                    startHour=ValuesGenerator.RandInt(random);
                    startMinute=ValuesGenerator.RandInt(random);
                    startDay=ValuesGenerator.RandInt(random);
                    startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    startYear=ValuesGenerator.RandInt(random);
                    

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

                    startHour=ValuesGenerator.RandInt(random);
                    startMinute=ValuesGenerator.RandInt(random);
                    startDay=ValuesGenerator.RandInt(random);
                    startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    startYear=ValuesGenerator.RandInt(random);
                    

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


                for (int k = 0; k < NUM_TESTS; k++){
                    appt.setStartHour(ValuesGenerator.getRandomIntBetween(random, -1, 30));
                    appt2.setStartHour(ValuesGenerator.getRandomIntBetween(random, -1, 30));
                    appt3.setStartHour(ValuesGenerator.getRandomIntBetween(random, -1, 30));
                    appts.add(appt);
                    appts.add(appt2);
                    appts.add(appt3);
                    String methodName = TimeTableRandomTest.RandomSelectMethod(random);
                    TimeTable ttab = new TimeTable();
                    if (methodName == "delete"){
                        if (appts.size() == 0) continue;
                        int randInt = ValuesGenerator.getRandomIntBetween(random, 0, 5); 
                        if (randInt == 0){
                            ttab.deleteAppt(appts, null);
                        }else if (randInt == 1){
                            ttab.deleteAppt(null, null);
                        }else if (randInt == 2){
                            LinkedList<Appt>tempAppts = new LinkedList<Appt>();
                            tempAppts.add(appt);
                            ttab.deleteAppt(tempAppts, appt);
                        }else{
                            ttab.deleteAppt(appts, appt);
                        }
                    }
                    int i11 = ValuesGenerator.RandInt(random);
                    int i12 = ValuesGenerator.RandInt(random);
                    int i13 = ValuesGenerator.RandInt(random);
                    int i21 = ValuesGenerator.RandInt(random);
                    int i22 = ValuesGenerator.RandInt(random);
                    int i23 = ValuesGenerator.RandInt(random);
                    GregorianCalendar cal1 = new GregorianCalendar(i11, i12, i13);
                    GregorianCalendar cal2 = new GregorianCalendar(i21, i22, i23);
                    if (methodName == "getApptRange"){
                        ttab.getApptRange(appts, cal1, cal2);
                    }
                }
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((i%10000)==0 && i!=0 )
                            System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
            } }catch(NullPointerException e){}
             }	
}
