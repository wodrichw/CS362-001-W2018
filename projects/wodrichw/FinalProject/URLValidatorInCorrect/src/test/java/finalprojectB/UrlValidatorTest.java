
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

   
  //Manual Testing################################################################# 
   public void testManualTest()
   {
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertTrue(urlVal.isValid("http://www.google.com"));
    assertTrue(urlVal.isValid("http://www.google.com"));
    assertTrue(urlVal.isValid("http://www.google.com/"));
    assertTrue(urlVal.isValid("http://google.com/"));
    assertTrue(urlVal.isValid("http://www.go-ogle.com"));
    assertTrue(urlVal.isValid("http://google.com/index.html"));
    assertTrue(urlVal.isValid("http://www.google.com/index.html"));
    assertTrue(urlVal.isValid("http://www.google.com/~test/"));
    assertTrue(urlVal.isValid("http://www.google.com/this/is/a/longer/post-that-should-work.html"));
    assertTrue(urlVal.isValid("http://www.google.com/style.css"));
    assertEquals(urlVal.isValid("www.gogle.com/#"), false);
    assertEquals(urlVal.isValid("ww.gogle.com/#"), false);
    assertEquals(urlVal.isValid("http/www.gogle.com/"), false);
    assertEquals(urlVal.isValid("htttp://www.gogle.com/"), false);
    assertEquals(urlVal.isValid("www.gogle.com//"), false);
   }
   
  //Partition Testin############################################################### 
   public void validProtocol()
   {
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertTrue(urlVal.isValid("http://www.google.com"));
   }
   
   public void invalidProtocol(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertEquals(urlVal.isValid("http/www.gogle.com/"), false);
   }
   public void validDomainName(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertTrue(urlVal.isValid("http://google.com"));
   }
   public void invalidDomainNameGoodProtocol(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertFalse(urlVal.isValid("http://google"));
   }

   public void invalidDomainNameBadProtocol(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertFalse(urlVal.isValid("http:/googlecom."));
   }

   public void validPath(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertTrue(urlVal.isValid("http://google.com/hello"));
   }
   
   public void invalidPath(){
    String[] schemes = {"http", "https", "ftp"};
    UrlValidator urlVal = new UrlValidator(schemes);
    assertFalse(urlVal.isValid("http://google.com/../"));
   }



   //Programming Based Testing#######################################################
   public void testIsValid()
   {
	   //You can use this function for programming based testing.

    ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                 new ResultPair("go.a1a", false),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };

   //Build all possible commbinations of scheme authority and path
   String[] schemes = {"http", "https", "ftp"};
   UrlValidator urlVal = new UrlValidator(schemes);
   String testUrl;
   boolean result;
   for (int i = 0; i < testUrlScheme.length; i++){
     for (int j = 0; j < testUrlAuthority.length; j++){
       for (int k = 0; k < testPath.length; k++){
         testUrl = testUrlScheme[i].item + testUrlAuthority[j].item + testPath[k].item;
         result = !testUrlScheme[i].valid && !testUrlAuthority[j].valid && !testPath[k].valid;

         if (result != urlVal.isValid(testUrl)){
          System.out.print("FAIL: " + Boolean.toString(result) + " " + Boolean.toString(urlVal.isValid(testUrl)) + " " + testUrl + "\n");
         }
         //assertEquals(result, urlVal.isValid(testUrl));
       }
     }
   }


   }
   


}
