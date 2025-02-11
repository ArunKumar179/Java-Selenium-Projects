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