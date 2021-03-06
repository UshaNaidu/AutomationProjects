package utility;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser 
{
	private WebDriver driver;
	public static final String BS_URL = "http://" + Constants.BS_USERNAME + ":" + Constants.BS_AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	public static final String SL_URL = "http://" + Constants.SL_USERNAME + ":" + Constants.SL_AUTOMATE_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	
	/*
	Set up method to lunch browser
	*/
	public WebDriver setUp(String browser, String environment, String OS) throws Exception 
	 {	   
		
		
		//Adding random wait between each thread
		Random t = new Random();
	    Thread.sleep(t.nextInt(15)*1000);
		
		if(environment.equalsIgnoreCase("Local") )
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				FirefoxProfile profile = new FirefoxProfile();
				profile.setEnableNativeEvents(true);
				driver = new FirefoxDriver(profile);
				 driver.manage().window().maximize();	
			}
			
			else if(browser.equalsIgnoreCase("ie"))
			{  
			   System.setProperty("webdriver.ie.driver", "src/test/resources/BrowserDrivers/IEDriverServer.exe");
			   driver = new InternetExplorerDriver();
			   driver.manage().window().maximize();
			   
			}
			
			else if(browser.equalsIgnoreCase("chrome"))
			{
				//
				//src/test/resources/BrowserDrivers/chromedriver.exe
			   //System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
			  // driver = new ChromeDriver();

				   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		           capabilities.setCapability("chrome.binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		           System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver.exe");
		           ChromeDriver driver = new ChromeDriver(capabilities);
		          
			   
			}
		}
		
		else if(environment.equalsIgnoreCase("Grid"))
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				if(OS.equalsIgnoreCase("Windows 7"))
				{
					DesiredCapabilities capability = DesiredCapabilities.firefox();
					capability.setBrowserName("firefox");
					capability.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(Constants.nodeURLW7),capability);
				}
				
			}
			else if(browser.equalsIgnoreCase("ie"))
			{  
				if(OS.equalsIgnoreCase("Windows 7"))
				{
					//System.setProperty("webdriver.ie.driver", "C:/Piyush/IEDriverServer.exe");
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					capability.setBrowserName("Internet Explorer");
					capability.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(Constants.nodeURLW7),capability);
				}
			   
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
			   
			   if(OS.equalsIgnoreCase("Windows 7"))
				{
				   	//System.setProperty("webdriver.chrome.driver", "C:/Piyush/chromedriver.exe");
					DesiredCapabilities capability = DesiredCapabilities.chrome();
					capability.setBrowserName("chrome");
					capability.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(Constants.nodeURLW7),capability);
				}
			   
			   
			}
			
		}
		
		else if(environment.equalsIgnoreCase("BrowserStack"))
		{
			//https://www.browserstack.com/automate/java
			
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "7.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "XP");
		    caps.setCapability("browserstack.debug", "true");
		    driver = new RemoteWebDriver(new URL(BS_URL), caps);
			
		}
		
		
		else if(environment.equalsIgnoreCase("Saucelabs"))
		{
			//https://docs.saucelabs.com/reference/platforms-configurator/?_ga=1.149449526.1441791307.1424257692#/
		
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 8");
			caps.setCapability("version", "40.0");
			
			
			/*DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 8");
			caps.setCapability("version", "23.0");
			
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 8");
			caps.setCapability("version", "10.0");*/
			
			driver = new RemoteWebDriver(new URL(SL_URL), caps);
			
		}
			
		
		
		
			
		

		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(90, TimeUnit.SECONDS);

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	   
	 }
	
	/*
	Tear down method to quit browser after test execution
	*/
	public void tearDown() throws Exception 
	  {  
		    try
	        {
		    	driver.close();
	            Thread.sleep(5000);
	            driver.quit();
	        }
	        catch(Exception e)
	        {
	        }
		   
	  }

	
	/*public void intialization()
	{
		
		
	}*/
	
}
