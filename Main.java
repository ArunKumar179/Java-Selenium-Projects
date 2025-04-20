package js;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main{
WebDriver d;
ChromeOptions c;
Actions a;
	@BeforeMethod
	public void launchApp() {
		c=new ChromeOptions();
		c.addArguments("--incognito");
		d= new ChromeDriver(c);
		a= new Actions(d);
		d.get("https://www.myntra.com/");
		d.manage().window().maximize();
	}
	@Test(priority=1)
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
	
	@AfterMethod
	public void closeApp() {
		d.quit();
	}
}

