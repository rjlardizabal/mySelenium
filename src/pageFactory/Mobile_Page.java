package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Mobile_Page {
	WebDriver driver;
	
	public Mobile_Page(WebDriver wdriver){
		
		this.driver=wdriver;
		PageFactory.initElements(wdriver, this);
		
	}
	
	
	@FindBy(css=".product-name>a") 
	private List<WebElement> products;
	
	@FindBy(css=".sort-by select")
	private WebElement SortBy;
	
	@FindBy(xpath="//a[@title='Samsung Galaxy']/following-sibling::div/div/button")
	private WebElement AddtoCartSamsungGalaxy;
	
	
	public List<WebElement> getAllProducts(){
				return products;
		
	}
	
	
	public void SortBy(String sortByOption){
		
		Select select = new Select(SortBy);
		try{
		select.selectByVisibleText(sortByOption);
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	
	
	public String getPrice(String Product){
		
		String xpathExpression = "//div/h2[a='"+Product+"']/following-sibling::div[@class='price-box']";
		
		String price = driver.findElement(By.xpath(xpathExpression)).getText();
		System.out.println("Price is: "+price);
		return price;
	}
	
	public void ClickAddtoCartSamsung(){
		AddtoCartSamsungGalaxy.click();;
		
		
	}

}
