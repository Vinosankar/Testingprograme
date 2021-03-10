package commonfun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonfun  {
	public static Properties properties = null;
	public static WebDriver driver=null;
	
	public Properties LoadPropertiesfile() throws IOException
	{
		FileInputStream fileInputStream =new FileInputStream("config.properties");
		 properties =new Properties();
	        properties.load(fileInputStream);
	        return properties;
	}
	
	@BeforeSuite
	public void lanchbrowser() throws IOException
	{
		LoadPropertiesfile();
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String driverlocation=properties.getProperty("Driverlocation");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverlocation);
			 driver = new ChromeDriver();
		
		}
		else
			if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.drivre", driverlocation);
		    driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@AfterSuite
	public void tearDown()
	{
		
	}
	
	

	
	
	

}
