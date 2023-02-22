package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class secondTest extends BaseClass 
{
	@Test
	 public void secondTest() throws InterruptedException
	 {
		SoftAssert soft = new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoAPP();
		web.handleChildBrowser();
		skillraryDemo.selectCategory(web, 1);
		soft.assertEquals(testing.getPageHeader(), "Testing");
		web.dragAndDropElement(testing.getSeleniumimage(), testing.getCartArea());
		
		web.scrollToElement(testing.getFaceBookIcon());
		
		testing.clickFaceBookIcon();
		soft.assertAll();
	 }

}
