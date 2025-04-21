package js;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main{
WebDriver d;
ChromeOptions c;
Actions a;
WebDriverWait wa;
JavascriptExecutor js;
	@BeforeMethod
	public void launchApp() {
		c=new ChromeOptions();
		c.addArguments("--incognito");
		
		d= new ChromeDriver(c);
		a= new Actions(d);
		d.get("https://www.myntra.com/");
		d.manage().window().maximize();
	}
	@Test(priority=1) //logo validation
	public void logo() {
		boolean flag=d.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo ']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority=2,timeOut=30000,dependsOnMethods="logo")  //search and add functionality
	public void testCase1()throws Exception {
		d.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Shirts");
		a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		Thread.sleep(3000);
		for(int i=1;i<4;i++) {
		d.findElement(By.xpath("//ul[@class='brand-list']/li["+i+"]")).click();
		}
		Thread.sleep(5000);
		d.findElement(By.id("30371566")).click();
		List<String> wh = new ArrayList(d.getWindowHandles());
		d.switchTo().window(wh.get(1));
		System.out.println(d.getCurrentUrl());
		String s1=d.findElement(By.xpath("//h1[@class='pdp-title']")).getText();
		String s2=d.findElement(By.xpath("//h1[@class='pdp-name']")).getText();
		String s3=d.findElement(By.xpath("//span[@class='pdp-price']")).getText();
		System.out.println("Selected product is "+s1+" "+s2+" and priced "+s3);
		}
	@DataProvider(name="loginData")
	public Object[] data() {
		return new Object[] {"2342","3432","345666","34422"};
	}
	
	@Test(priority=3,dataProvider="loginData")
	public void login(String phno) throws InterruptedException {
		WebElement w =d.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
		WebElement w1=d.findElement(By.xpath("//a[normalize-space()='login / Signup']"));
		a.moveToElement(w).click(w1).perform();
		d.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys(phno);
		d.findElement(By.xpath("//div[text()='CONTINUE']")).click();
		String w3=d.findElement(By.xpath("//div[@class='errorContainer']")).getText();
		Assert.assertEquals("Please enter a valid mobile number (10 digits)",w3);
		
		
		
	}
	@DataProvider(name="dp")
	public Object[] getData2() {
		return new Object[] {"Puma","nike","Woodland"};
	}
	
	@Test(priority=4,dataProvider="dp")
	public void studioTest(String data)throws Exception {
		wa=new WebDriverWait(d,Duration.ofSeconds(30));
		WebElement w5=d.findElement(By.xpath("//a[normalize-space()='Studio']"));
		wa.until(ExpectedConditions.visibilityOf(w5)).click();
		Thread.sleep(10000);
		WebElement w6=d.findElement(By.xpath("//img[@class='img-responsive preLoad loaded']"));
		if(w6.isDisplayed()) {
			d.findElement(By.xpath("//div[@class='ripple-container popup-close right']")).click();
		}
		d.findElement(By.id("header-studio-explore")).click();
		WebElement searchBox = d.findElement(By.xpath("//input[@placeholder='Search In Studio' and @enterkeyhint='search']"));
		js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(true);", searchBox);
		searchBox.sendKeys(data);
		Thread.sleep(2000);
		List<WebElement> ls=d.findElements(By.className("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz']"));
		for(WebElement we:ls) {
			Assert.assertTrue(we.isDisplayed());
		}
		}
	
	@AfterMethod
	public void closeApp() {
		//d.quit();
	}
}

