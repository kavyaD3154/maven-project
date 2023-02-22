package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class ThirdTest extends genericlibraries.BaseClass
{
   @Test
   
   public void thirdTest() throws InterruptedException    //before method only we give opening browser
   {
	   SoftAssert soft =new SoftAssert();
	   
	   home.searchFor("core java for selenium");
	   
	   soft.assertEquals(corejava.getPageHeader(),"CORE JAVA FOR SELENIUM");
	   corejava.coreJavaSeleniumLink();
	  
	   soft.assertEquals(javavideo.getPageHeader(),"Core Java For Selenium Training" );
	  
	   javavideo.clickClosecookies();
	   web.switchToFrame();
	  
	  
	   javavideo.clickPlayButton();
	   Thread.sleep(3000);
	   javavideo.clickpauseButton();
	  
	   web.switchBackToFrame();
	  
	   javavideo.clickAddToWishList();
	  
	   soft.assertAll();
	   
   }
}