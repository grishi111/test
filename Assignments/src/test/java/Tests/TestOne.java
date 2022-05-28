package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import Pages.BasePage;

public class TestOne extends BasePage{
	
		@BeforeMethod
		public void setUp() {
			initialization();
			waitForSecs(2000);
		}
		@AfterMethod
		public void closebrowser() {
			driver.quit();
		}
		@Test(priority=1)
		public void FirstTest() {
			
			boolean eleSelected=driver.findElement(By.cssSelector("nav#main-navigation")).isDisplayed();
			Assert.assertTrue(eleSelected);
			
			driver.findElement(By.cssSelector("button[data-test='btnSearch_Header_Disabled']")).click();
			
			String text="ROUGE ALLURE";
			
			driver.findElement(By.cssSelector("input#searchInput")).sendKeys(text);
			driver.findElement(By.cssSelector("input#searchInput")).sendKeys(Keys.RETURN);
			waitForSecs(2000);
			
			List <WebElement>titles= driver.findElements(By.cssSelector("h4.product-item__title>span"));
			for(WebElement w:titles) {
				boolean isPresent=w.getText().toLowerCase().contains(text.toLowerCase());
				Assert.assertTrue(isPresent);
			}
			
			
	}
		
@Test(priority=2)
public void SecondTest() {
	driver.findElement(By.cssSelector("a#makeup")).click();
	driver.findElement(By.cssSelector("a[data-linkname='Lipstick']")).click();
	
	waitForSecs(1000);
	List <WebElement>result= driver.findElements(By.xpath("//span[text()='ROUGE ALLURE']/.."));
	
	result.get(0).click();
	
	driver.findElements(By.cssSelector("button#pos-cnc-btn")).get(0).click();
	waitForSecs(1000);
	
	driver.navigate().refresh();
	waitForSecs(2000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button.js-cart.cart.button")));
			
	waitForSecs(1000);
	
	boolean isNameCorrect= driver.findElement(By.cssSelector("span.heading.is-7")).getText().toLowerCase().contains("ROUGE ALLURE".toLowerCase());
	Assert.assertTrue(isNameCorrect);
	
	Select s = new Select(driver.findElement(By.cssSelector("select#prd0")));
	String qt=s.getOptions().get(0).getText();
	
	boolean isQuantity=qt.equalsIgnoreCase("1");
	Assert.assertTrue(isQuantity);
			
	}

}
