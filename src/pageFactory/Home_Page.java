package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	
	
	
	@FindBy(id="search")	
	private WebElement txtbox_Search;
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	private WebElement link_Mobile;
	
	public Home_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	
	public void searchItem(String searchItem){
		
		txtbox_Search.sendKeys(searchItem);
		txtbox_Search.submit();
		
		
	}
	
	
	public void clickMobileLink(){
		link_Mobile.click();
		
	}
	
	
}
