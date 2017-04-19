package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart_Page {
	WebDriver driver;
	
	public ShoppingCart_Page(WebDriver driver){
		this.driver = driver;
		

		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy (xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")
	private WebElement QuantityBox;
	
	@FindBy (css =".button.btn-update")
		private WebElement UpdateButton;
		
	
	
	
	public void SetQuantity(Integer Quantity){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(QuantityBox));
		QuantityBox.sendKeys(Quantity.toString());
		UpdateButton.click();
	}

}
