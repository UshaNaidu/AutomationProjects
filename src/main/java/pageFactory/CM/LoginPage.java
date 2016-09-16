package pageFactory.CM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)   // ttmjhsyjhyt
	{	 
        this.driver = driver;
 //n in oj
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	
	
	 /*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 
	@FindBy(id="ctl00_headerControl_HyperLink1")
    public WebElement Login;
	
	@FindBy(xpath=".//*[@id='ctl00_PageContent_ctl00_ctrlLogin_UserName']")
    public WebElement Email;
	
	@FindBy(xpath=".//*[@id='ctl00_PageContent_ctl00_ctrlLogin_Password']")
    public WebElement Password;
	
	@FindBy(xpath=".//*[@id='ctl00_PageContent_ctl00_ctrlLogin_LoginButton']")
    public WebElement LoginButton;
		
	
	//Click on Login button
		public void ClickOnLogInLink()
		{
			Login.click();
		}
		
		//Enter Username
		public void EnterUsername(String email)
		{
			Email.clear();
			Email.sendKeys(email);
		}
			
		//Enter Password
		public void EnterPassword(String password)
		{
			Password.clear();
			Password.sendKeys(password);
		}		
		
		//Click on Sign In Link
		public void ClickOnLoginButton()
		{
			LoginButton.click();
		}
		
		
			
}

