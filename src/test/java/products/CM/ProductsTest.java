package products.CM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageFactory.CM.LoginPage;
import pageFactory.CM.ProductPage;
import utility.SeleniumFunctions;


public class ProductsTest
{
		                                      
	public static WebDriver driver;
	// public static ExtentReports extent;
	 LoginPage login;
	 ProductPage product;
	 SeleniumFunctions SeleniumFunc;
	 
	 
	 @BeforeSuite()
	 public void setup()
	 {
		   System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDrivers/chromedriver.exe");
		    driver = new ChromeDriver();			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://aspdotnetstorefront.goavm.com/");
			/*extent = new ExtentReports(System.getProperty("user.dir")+"\\GOAVM_Execution_Report\\GOAVM_Execution_Report.html", true);			
			extent = new ExtentReports("D:\\Downloads\\Clarion\\Davinci_Execution_Report\\Davinci_Execution_Report.html", true);
			extent.config().documentTitle("GOAVM Automation Report");
			extent.config().reportName("Regression");
			extent.config().reportHeadline("GOAVM");*/
				
	 }
	 

	
	 
	 @Test
	 public void ProductFunctionality() throws InterruptedException
	 {
	 
		// ExtentTest test = (new LoginTest().extent).startTest("Product functionality", "Verify end to end select product Functionality.").assignCategory("Assert","Extent API");
	  	  		
						
			     System.out.println("====" + "\n" +
							"Test 1 : Verify User Logged In with valid credentials"  + "\n" +
				 			"====");
				 //test.log(LogStatus.PASS,"Test 4 :", "Verify Login functionality with Valid Email Address & Valid Password");
				
				      LoginPage login = new LoginPage(driver);
				      ProductPage product = new ProductPage(driver);
				 
				      login.ClickOnLogInLink();	  // Clicks on LogIn link
				    
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
				Thread.sleep(4000);			    										      			    			      
			      
			      
				System.out.println("====" + "\n" + "Test 1 : Verify End to End Functionality of a Product."  + "\n" +
				 			"====");
			    //test.log(LogStatus.PASS,"Test 1 : Verify End to End Functionality of a Product.");				    	      
			      			     			         
				    
				System.out.println("Step 4 : Click on Artwork Product Link.");
				//test.log(LogStatus.PASS,"Step 4 : Click on Artwork Product Link.");
						product.ClickOnArtWorkLink();
						Thread.sleep(2000);
						
						String expected = "Artwork";
								String actual = driver.findElement(By.linkText("Artwork")).getText();
								
								
				System.out.println("Step 5 : Verifying Artwork Product Link has been clicked successfully or not.");
				//test.log(LogStatus.PASS,"Step 5 : Verifying Artwork Product Link has been clicked successfully or not.");						
						if(actual.contentEquals(expected))
						{
				   		
							System.out.println("Success !! 'Artwork Product Link has been clicked successfully.");
							//test.log(LogStatus.PASS,"Success !! 'Artwork Product Link has been clicked successfully"); 
			
						}
						
						else
				   		{
				   		
				   			System.out.println("Failure !! 'Artwork Product Link has not been clicked.");
							Reporter.log("Failure !!'Artwork Product Link has not been clicked."); 
						
				   		}		
							
						
				System.out.println("Step 6 : Select a product ArtWork Bloom subcategory.");
				//test.log(LogStatus.PASS,"Step 6 : Select a product ArtWork Bloom subcategory.");
						product.ClickOnAutomnBloomProduct();
						Thread.sleep(4000);
						
						String expected1 = "Autumn Bloom";
						String actual1 = driver.findElement(By.linkText("Autumn Bloom")).getText();
						
						
				System.out.println("Step 7 : Verifying Artwork Product Link has been clicked successfully or not.");
				//test.log(LogStatus.PASS,"Step 7 : Verifying Artwork Product Link has been clicked successfully or not.");						
				       if(actual1.contentEquals(expected1))
				       {
		   		
					        System.out.println("Success !! 'Artwork Product Link has been clicked successfully.");
					        //test.log(LogStatus.PASS,"Success !! 'Artwork Product Link has been clicked successfully"); 
	
				       }
				
				       else
		   		       {
		   		
		   			        System.out.println("Failure !! 'Artwork Product Link has not been clicked.");
					        Reporter.log("Failure !!'Artwork Product Link has not been clicked."); 
				
		   		       }		
				       
				       
				System.out.println("Step 8 : Click on Add To Cart Button.");
				//test.log(LogStatus.PASS,"Step 8 : Click on Add To Cart Button.");
						product.ClickOnAddToCartbutton();
						Thread.sleep(2000);
						
				       
				System.out.println("Step 9 : Click on Items Icon.");
				//test.log(LogStatus.PASS,"Step 9 : Click on Items Icon.");
						product.ClickOnItemsIcon();
						Thread.sleep(2000);
								
		    
				System.out.println("Step 10 : Enter Quantity.");
				//test.log(LogStatus.PASS,"Step 10 : Enter Quantity.");
						product.EnterQuantity();
					    Thread.sleep(2000);	
	        
					    
			    System.out.println("Step 11 : Click on Proceed To Checkout Button.");
				//test.log(LogStatus.PASS,"Step 11 : Click on Proceed To Checkout Button.");
						product.ClickOnProceedToCheckout();
						Thread.sleep(2000);	
							    
			   System.out.println("Step 12 : Click on Shipping Method Radio Button.");
			   //test.log(LogStatus.PASS,"Step 12 : Click on Add To Cart Button.");
						product.ClickOnShippingMethodRadioButton();
					    Thread.sleep(2000);	
					    
			   System.out.println("Step 13 : Enter Quantity");
			   //test.log(LogStatus.PASS,"Step 13 : Click on Add To Cart Button.");
						product.EnterQuantity();
						Thread.sleep(2000);	    
	}
	 

}
