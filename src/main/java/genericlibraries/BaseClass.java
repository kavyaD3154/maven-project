package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactusPage;
import pompages.CoreJavaForSeleniumPage;
import pompages.CoreJavaVideoPage;
import pompages.HomePagesofSkillrary;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

public class BaseClass
{
	protected PropertiesFileUtility property;
	protected Excelutility excel;
	protected genericlibraries.WebDriverUtility web;
	protected WebDriver driver;
	protected pompages.HomePagesofSkillrary home;
	protected pompages.SkillraryDemoAppPage skillraryDemo;
	protected pompages.SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected pompages.ContactusPage contact;
	protected CoreJavaForSeleniumPage corejava; 
	protected CoreJavaVideoPage javavideo;
	protected long time;
	//@BeforeSuite
   //@BeforeTest
	
	@BeforeClass
	public void classConfiguration()
	{
	 property=new PropertiesFileUtility();
	 excel=new Excelutility();
	 web=new WebDriverUtility();
	 
	
	 property.propertyFileInitialization(IConstatntpath.PROPERTIES_FILE_PATH);
	 excel.excelinitiallization(IConstatntpath.EXCEL_FILE_PATH);
	
	}
	
	
	@BeforeMethod
	public void methodConfiguration()
	{
		  time=Long.parseLong(property.fetchProperty("timeouts"));
			driver= web.openApplication(property.fetchProperty("browser"),property.fetchProperty("url"),time);
			
			home=new HomePagesofSkillrary(driver);
			
			Assert.assertTrue(home.getLogo().isDisplayed());
			
			skillraryDemo=new SkillraryDemoAppPage(driver);
			selenium=new SeleniumTrainingPage(driver);
			testing=new TestingPage(driver);
			contact=new ContactusPage(driver);
			corejava=new CoreJavaForSeleniumPage(driver);
			javavideo=new CoreJavaVideoPage(driver);		
	}
	
	@AfterMethod
	 public void methodTearDown()
	 {
		web.quitBrowser();
	 }
    @AfterClass
    public void classTearDown()
    {
    	excel.closeexcel();
    }
    //@AfterTest
	//@AfterTest@AfterSuite

}