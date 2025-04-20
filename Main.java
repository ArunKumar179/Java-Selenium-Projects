
package js1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main{
	public static void main(String[] args) throws Exception{
		WebDriver d = new ChromeDriver();
		WebDriverWait w= new WebDriverWait(d,Duration.ofSeconds(30));
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://www.youtube.com/");
		d.findElement(By.name("search_query")).sendKeys("Dr bro");
		d.findElement(By.cssSelector("button.ytSearchboxComponentSearchButton")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src=\"https://i.ytimg.com/vi/NFoyfSO0KYo/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLCBCGjPWyuVxK7LDE-yphLnRNF2XQ\"]"))).click();
		Thread.sleep(2000);
		d.findElement(By.linkText("https://tinyurl.com/532b5cjv")).click();
		Set<String> h=d.getWindowHandles();
		List<String> j=new ArrayList<String>(h);
		String w1 =j.get(0);
		String w2=j.get(1);
		d.switchTo().window(w2);
		d.navigate().refresh();
		d.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/div[1]/form/section[1]/article/div[1]/div/div[2]/label/span")).click();
		d.findElement(By.xpath("//button[text()=' Continue › ']")).click();
		
	WebElement r=d.findElement(By.id("Self"));
	Select s = new Select(r);
	s.selectByVisibleText("18 yr");
	d.findElement(By.xpath("//button[text()=' Continue › ']")).click();
	
	}
}

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

