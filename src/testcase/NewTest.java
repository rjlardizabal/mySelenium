package testcase;
import pageFactory.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	WebDriver driver = new FirefoxDriver();
	Home_Page homepage = new Home_Page(driver);
	Mobile_Page mobilepage = new Mobile_Page(driver);
	ShoppingCart_Page shoppingcartpage = new ShoppingCart_Page(driver);
	
	
   @BeforeMethod(groups={"group3"})
  public void beforeMethod() {
		  
		  driver.get("http://live.guru99.com/indeadsadsax.php");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
	  }
	
	
  @Test(enabled=false,groups="group1")
  public void VerifySortBy() throws Exception {
	  
	  homepage.clickMobileLink();
	  mobilepage.SortBy("Name");
	  
	  List<WebElement> webelements = mobilepage.getAllProducts();
	  
	  int numOfProducts = mobilepage.getAllProducts().size();
	  

	  for(int i=0;i<numOfProducts-1;i++){
		  int isSorted=webelements.get(i).getText().compareTo(webelements.get(i+1).getText());
		  System.out.println(isSorted);
		  
		  Assert.assertTrue(isSorted<0);
		  
		  
	  }
	 
	 

  }
  
  
  @Test(groups="group2")
  public void GetPrice(){
	  homepage.clickMobileLink();
	  mobilepage.getPrice("IPhone");	  
	  
  }
  
  
  @Test(groups={"group3"})
  public void VerifyError(){
	  
	  homepage.clickMobileLink();
	  mobilepage.ClickAddtoCartSamsung();
	  shoppingcartpage.SetQuantity(100);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
