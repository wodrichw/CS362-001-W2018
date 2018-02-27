package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.Test;

import jdk.nashorn.internal.codegen.CompilerConstants.Call;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 1000 * 4; /* Timeout at 10 seconds */
    private static final int NUM_TESTS=100;
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

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
	  public void addAptTest()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.print("Starting Testing...");

        try{
            for (int i = 0; elapsed < TestTimeout; i++){
                GregorianCalendar cal = new GregorianCalendar(2018, 1, 1);
                CalDay calDay = new CalDay(cal);

            
                long randomseed =System.currentTimeMillis(); //10
    //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);
                
                int startHour=ValuesGenerator.getRandomIntBetween(random, 10, 20);
                int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
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

                for (int j = 0; j < NUM_TESTS; j++){
                    startHour=ValuesGenerator.getRandomIntBetween(random, 10, 20);
                    startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
                    startDay=ValuesGenerator.RandInt(random);
                    startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    startYear=ValuesGenerator.RandInt(random);
                    Appt appt2 = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
                    calDay.addAppt(appt2);
                }
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((i%10000)==0 && i!=0 )
                    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
            }
            
        }catch(NullPointerException e){}
	 }
}
