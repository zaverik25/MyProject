package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Constructor of Base class which will read from config.properties
	public BaseHRMClass() {
		
		try {
			FileInputStream file= new FileInputStream("C:\\Users\\khush\\eclipse-workspace\\HRmanagment\\src\\test\\java\\environmentvariables\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) { //throws exception when file is not found
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException a) { //throws exception when input or read functions gices error
			a.printStackTrace();
		}
		
	}
	//Common commands
	public static void initiation() {
		//gets property of browser from config and store in a varaible.
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		  else if(browsername.equals("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); driver =new
		  FirefoxDriver(); }
		 
		//Basic commands
		driver.manage().window().maximize();
		//Selenium 4 command for implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
		driver.get(prop.getProperty("url"));
		
		
	}
	//Screenshots
	public static void screenshots(String filename) {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("C:\\Users\\khush\\eclipse-workspace\\HRmanagment\\src\\test\\java\\screenshots\\Screenshots" + filename+ ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
