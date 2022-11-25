package testLayer;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pomPackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {

	PomLogin log;
	public LoginTest() {
		
		//Calling constructor of parent class
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshots("Login");
		 log= new PomLogin();
	}
	
	@Test(priority=1)
	public void Title() {
		
		String actual=log.verify();
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
		
	}
	
	@Test(priority=2, dataProvider="Details")
	public void Login(String name,String Pass) throws InterruptedException {
		
		log.typeusername(name);
		log.typepassword(Pass);
		//log.clickbtn();
		Thread.sleep(3000);
		
	}
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
}
