package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class FirstTestScript extends BaseClass
{
	 @Test
	 
	 public void firstTest()
	 {
		 SoftAssert soft=new SoftAssert();
				 
		 home.clickGears();
		 home.clickSkillrarydemoAPP();
		web.handleChildBrowser();
		
		soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
		skillraryDemo.mouseHoverTocourse(web);
		
		skillraryDemo.clickSeleniumtraining();
		
	soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		selenium.doubleClickOnPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		web.explicitlyWait(time, selenium.getItemAddedMessage());
		web.takeScreenShot();

		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		
		soft.assertAll();
		 
	 }
   
}