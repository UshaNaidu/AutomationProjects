package pageFactory.CM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class ProductPage 
{
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	
	
	 /*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 
	@FindBy(css="a[href='/artwork-c-539.aspx']")
    public WebElement artWorkLink;
	
	@FindBy(css="img[src='/images/Category/icon/autumnbloom.jpg']")
    public WebElement automnBloomProduct;
	
	@FindBy(css=".options button:nth-of-type(1)")  	// .product-container button:nth-of-type(1)
    public WebElement addToCartbutton;
	
	@FindBy(css=".cart a:nth-of-type(1) img")
    public WebElement itemsIcon;
	
	@FindBy(id="ctl00_PageContent_ctrlShoppingCart_ctl00_txtQuantity")
    public WebElement quantity;
	
	@FindBy(id="ctl00_PageContent_btnCheckOutNowTop")
    public WebElement proceedToCheckout;
	
	@FindBy(id="ctl00_PageContent_OnePageCheckout1_PaymentView_ShipMethodView_ShippingMethods_0")
    public WebElement shippingMethod;
	
	@FindBy(id=".form-group input:nth-of-type(1)")
    public WebElement nameOnCard;
	
	

	//Click on Bedding button
		public void ClickOnArtWorkLink()
		{
			
			artWorkLink.click();
		
		}
		
		public void ClickOnAutomnBloomProduct()
		{
			
			automnBloomProduct.click();
			
		}
		
		public void ClickOnAddToCartbutton()
		{
			
			addToCartbutton.click();
				
		}
			
		public void ClickOnItemsIcon()
		{
			
			itemsIcon.click();
				
		}
		
		public void EnterQuantity()
		{

			quantity.sendKeys("40");
				
		}
		
		public void ClickOnProceedToCheckout()
		{
			
			proceedToCheckout.click();
				
		}
				
		public void ClickOnShippingMethodRadioButton()
		{
			
			shippingMethod.click();
				
		}
		
		public void EnterNameOnCard()
		{
			
			nameOnCard.sendKeys("User Admin");
				
		}
		
		
		
}
		
			
		
		
			


