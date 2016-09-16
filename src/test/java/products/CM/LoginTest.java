package products.CM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageFactory.CM.LoginPage;
import utility.SeleniumFunctions;

public class LoginTest {
	public static WebDriver driver;
//	 public static ExtentReports extent;
	 LoginPage login;
	 SeleniumFunctions SeleniumFunc;
	 
	 
	 @BeforeClass()
		public void setup()
		{
		   System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver.exe");
		    driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://aspdotnetstorefront.goavm.com");
		}
	 

	   @AfterClass
	    public void teardown() throws Exception
	   {	    
	  	    driver.close();
	  	    driver.quit();
	   }
    
	 	 
	 
//		Test 1 - Verify the functionality of login with Valid Email Address & Blank Password  
	 
	 @Test
	 public void ValidEmailBlankPassword() throws InterruptedException
	{
		  	
	 
	 System.out.println("====" + "\n" +
				"Test 1 : Verify the functionality of login with Valid Email Address & Blank Password"  + "\n" +
	 			"====");
	
	
	        SeleniumFunctions SeleniumFunc = new SeleniumFunctions(driver);
		    LoginPage login  =  new LoginPage(driver);
		   
		   
	        login.ClickOnLogInLink();	  // Clicks on Login link

			System.out.println("Step 1 : Enter Valid User Name and Blank Password and Clicking on Login button.");
		//	test.log(LogStatus.PASS, "Step 1 :", "Entering details for User Name and Password and Clicking on Login button.");	
			
			login.EnterUsername("admin@aspdotnetstorefront.com");
			Thread.sleep(3000);
			login.EnterPassword("");
		
			login.ClickOnLoginButton();  // Clicks on Login Button
		 
			Thread.sleep(3000);
			
		System.out.println("Step 2 : Verifying validation message displayed for Valid User Name and Blank Password ");
			
		String ActualMessage=SeleniumFunc.GetElementText("xpath", ".//*[@id='ctl00_PageContent_ctl00_ctrlLogin_RequiredFieldValidator2']");				
		String ExpectedMessage = "Password Required";
		 	if(ActualMessage.equals(ExpectedMessage))
		 	{
		 		
		 		System.out.println("Success !! Correct validation messages are displayed for Valid User Name and Blank Password fields");		    
		 	    System.out.println("==============================================\n");	 
		  	
		 	}
		 	else
		 	{
		 		System.out.println("Failure !!  Incorrect validation messages are displayed for Valid User Name and Blank Password fields" + "\n" + "Expected Validation messages : "  
		 						+ "\n" + ExpectedMessage + "\n" + 
				 			"Actual Validation messages : " + "\n" +  ActualMessage);
			/*test.log(LogStatus.FAIL,"Failure !!  Incorrect validation messages are displayed for Valid User Name and Blank Password fields" + "\n" + "Expected Validation messages : "  
				+ "\n" + ExpectedMessage + "\n" + 
				 "Actual Validation messages : " + "\n" +  ExpectedMessage);*/
		 	
		
			}	
		 	
			
	}
	 
		 
	 
	 
	
		//	 Test 2 - Verify the functionality of login with Invalid Email Address & Invalid Password  	
	 	
	 @Test
	 public void InvalidEmailInvalidPassword() throws InterruptedException
	{
		  	
	   //ExtentTest test = extent.startTest("Valid Details - Failed Purposefully", "InvalidEmailInvalidPassword").assignCategory("Assert","Extent API");
		 
        System.out.println("====" + "\n" +
				"Test 2 : Verify the functionality of login with Invalid Email Address & Invalid Password"  + "\n" +
	 			"====");
	    //test.log(LogStatus.PASS,"Test 2 :", " Verify the functionality of login with Invalid Email Address & Invalid Password");	
	  	  
        SeleniumFunc = new SeleniumFunctions(driver);
        LoginPage login  =  new LoginPage(driver);
	
		
	    login.ClickOnLogInLink();	  // Clicks on LogIn link
	    Thread.sleep(3000);
	    
		System.out.println("Step 1 : Redirects to the Login Page");
		//test.log(LogStatus.PASS, "Step 1 :", "Redirects to the Login Page");
		

			System.out.println("Step 2 : Enter Invalid User Name and Invalid Password and Clicking on Login button.");
			//test.log(LogStatus.PASS, "Step 2 :", "Entering Invalid User Name and Invalid Password and Clicking on Login button.");	
			
			login.EnterUsername("Test@test12");
			Thread.sleep(3000);
			login.EnterPassword("pass1234");
			Thread.sleep(3000);
			login.ClickOnLoginButton();
		
			Thread.sleep(5000);
			
			if(SeleniumFunc.IsElementPresent("xpath",".//*[@id='ctl00_header_sploginText']/a"))
			{
	   		
				
				System.out.println("Success !! User has logged in successfully");
				//test.log(LogStatus.PASS, "Success !! User has logged in successfully"); 
				System.out.println("==============================================\n");	 
			}
			else
	   		{
	   		
				//test.log(LogStatus.FAIL, "Step 3 :","Verifying User not Logged in for Invalid User Name and Password");
				System.out.println("Failed !! User has not logged in successfully");
				//test.log(LogStatus.FAIL, "Failed !! User has not logged in successfully"); 
				System.out.println("==============================================\n");	
	   			System.out.println("Failure !! Invalid Login Credentials");
	   			//test.log(LogStatus.FAIL, "Failure !! Invalid Login Credentials"); 
	   			Assert.fail();
	   		   	 
	   		}
			
		
				
		//(new LoginTest().extent).endTest(test);
		//Thread.sleep(5000);	
		
		
	}
	 
		 
	 
	 
//	 Test 3 : Verify the functionality of login  by keeping all fields blank
	 
	 @Test
	 public void BlankEmailBlankPassword() throws InterruptedException
	{
		  
			
		 //ExtentTest test = extent.startTest("Blank Email Blank Password", "BlankEmailBlankPassword").assignCategory("Assert","Extent API");
		 
		 System.out.println("====" + "\n" +
					"Test 3 : Verify the functionality of login  by keeping all fields blank"  + "\n" +
		 			"====");
			 //test.log(LogStatus.PASS,"Test 3 :", "Verify the functionality of login  by keeping all fields blank");		
		
			 
		    SeleniumFunc = new SeleniumFunctions(LoginTest.driver);

		    LoginPage login  =  new LoginPage(driver);
	
			
		    login.ClickOnLogInLink();	  // Clicks on LogIn link
		    
			System.out.println("Step 1 : Redirects to the Login Page");
			//test.log(LogStatus.PASS, "Step 1 :", "Redirects to the Login Page");
			
							
			System.out.println("Step 2 : Do not enter User Name and Password and Clicking on Login button");
			//test.log(LogStatus.PASS, "Step 2 :", "Do not enter User Name and Password and Clicking on Login button");
			
				login.EnterUsername("");
				login.EnterPassword("");
				login.ClickOnLoginButton();
				
				Thread.sleep(5000);
	
				System.out.println("Step 3 : Verifying result for valid messages are displayed");
				//test.log(LogStatus.PASS, "Step 3 :", "Verifying result for valid messages are displayed");
				Thread.sleep(2000);
				
					String ActualMessageUname=SeleniumFunc.GetElementText("id", "ctl00_PageContent_ctl00_ctrlLogin_RequiredFieldValidator3");
					String ActualMessagePassword=SeleniumFunc.GetElementText("id", "ctl00_PageContent_ctl00_ctrlLogin_RequiredFieldValidator2");
					//System.out.println(ActualMessage);
					String ExpectedMessageUname = "Email ID Required";
					String ExpectedMessagePassword = "Password Required";
				
					
					if(ActualMessageUname.equals(ExpectedMessageUname) && ActualMessagePassword.equals(ExpectedMessagePassword))
			   		 {
			   		 		
			   		 	System.out.println("Success !! Correct validation messages are displayed for Email Address & Password fields");
			   		    //test.log(LogStatus.PASS,"Success !! Correct validation messages are displayed for Email Address & Password fields");
			   		    System.out.println("==============================================\n");	 
			   		 
			   		 
			   		}
			   	 	else
			   	 	{
			   		 	
			   	 		System.out.println("Failure !!  Incorrect validation messages are displayed for Email Address & Password fields" + "\n" + "Expected Validation messages : "  
							+ "\n" + ExpectedMessageUname + "\n" + 
							 "Actual Validation messages : " + "\n" +  ActualMessageUname);
			   	       /* test.log(LogStatus.FAIL,"Failure !!  Incorrect validation messages are displayed for Email Address & Password fields" + "\n" + "Expected Validation messages : "  
								+ "\n" + ExpectedMessageUname + "\n" + 
								 "Actual Validation messages : " + "\n" +  ActualMessageUname);*/
			   	 

					}	
					
	 
	
					
				//(new LoginTest().extent).endTest(test);
				//Thread.sleep(5000);		
	}
	 
	 	 
	 
	 
	 //     Test 4 : Verify Login functionality with Valid Email Address & Valid Password
	 
	 @Test
	 public void ValidLogin() throws InterruptedException
	{
		  
			
		// ExtentTest test = extent.startTest("Login with Valid Credentials", "Verify Invalid Login Scenario").assignCategory("Assert","Extent API");

	 System.out.println("====" + "\n" +
				"Test 4 : Verify Login functionality with Valid Email Address & Valid Password"  + "\n" +
	 			"====");
	 //test.log(LogStatus.PASS,"Test 4 :", "Verify Login functionality with Valid Email Address & Valid Password");
	
	 
	 SeleniumFunc = new SeleniumFunctions(LoginTest.driver);

	 LoginPage login  =  new LoginPage(driver);
	 
	 	login.ClickOnLogInLink();	  // Clicks on SignIn link
	    
	 System.out.println("Step 1 : Redirects to the Login Page");
		//test.log(LogStatus.PASS, "Step 1 :", "Redirects to the Login Page");
	
	 System.out.println("Step 2 : Entering Valid Email Address & Valid Password and Clicking on Login button");
	//test.log(LogStatus.PASS, "Step 2 :", "Entering Valid Email Address & Valid Password and Clicking on Login button");
		
		
		login.EnterUsername("admin@aspdotnetstorefront.com");
		Thread.sleep(3000);
		login.EnterPassword("Clarion$1234");
		Thread.sleep(3000);

		login.ClickOnLoginButton();
		Thread.sleep(4000);	
		
			
	System.out.println("Step 3 : Verify whether user is logged in successfully");
	//test.log(LogStatus.PASS, "Step 3 :", "Verify whether user is logged in successfully");
	
	Thread.sleep(8000);
	    
		
		if(SeleniumFunc.IsElementPresent("id","ctl00_headerControl_HyperLink1"))
		{
   		
			System.out.println("Success !! User has logged in successfully");
			//test.log(LogStatus.PASS, "Success !! User has logged in successfully"); 
			System.out.println("==============================================\n");	 
		}
		else
   		{
   		
   			System.out.println("Failure !! Error in login");
   			//test.log(LogStatus.FAIL, "Failure !! Error in login"); 
   			Assert.fail();
   		   	 
   		}
		
//Logout			
		SeleniumFunc.ClickOnElement("id", "ctl00_headerControl_HyperLink1");
			Thread.sleep(1000);
			
		//(new LoginTest().extent).endTest(test);
		//Thread.sleep(5000);						
	
		
}
	 
	   
}

				
