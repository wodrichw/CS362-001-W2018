
package finalprojectB;

import jdk.nashorn.internal.AssertsEnabled;
import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
    UrlValidator urlVal = new UrlValidator(null, null, 1);
    //UrlValidator urlVal = new UrlValidator(null, allowAllSchemes);
    assertTrue(urlVal.isValid("http://www.google.com"));
    assertTrue(urlVal.isValid("http://www.google.com/"));
    assertTrue(urlVal.isValid("www.google.com/"));
    assertTrue(urlVal.isValid("http://www.go-ogle.com"));
    assertTrue(urlVal.isValid("google.com/"));
    assertTrue(urlVal.isValid("google.com/index.html"));
    assertTrue(urlVal.isValid("http://www.google.com/index.html"));
    assertTrue(urlVal.isValid("www.google.com/~test/"));
    assertTrue(urlVal.isValid("http://www.google.com/this/is/a/longer/post-that-should-work.html"));
    assertTrue(urlVal.isValid("http://www.google.com/style.css"));
    assertEquals(urlVal.isValid("www.gogle.com/#"), false);
    assertEquals(urlVal.isValid("ww.gogle.com/#"), false);
    assertEquals(urlVal.isValid("http/www.gogle.com/"), false);
    assertEquals(urlVal.isValid("htttp://www.gogle.com/"), false);
    assertEquals(urlVal.isValid("www.gogle.com//"), false);
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
