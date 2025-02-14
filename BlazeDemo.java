package js1;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main{
	public static void main(String[] args) throws Exception{
		int a[]= new int[5];
		WebDriver d = new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		d.get("https://blazedemo.com/");
	
		d.manage().window().maximize();
		
		WebElement l=d.findElement(By.name("fromPort"));
		Select s = new Select(l);
		s.selectByVisibleText("Mexico City");
		
		Select s2= new Select(d.findElement(By.name("toPort")));
		s2.selectByValue("London");
		d.findElement(By.cssSelector("input[value=\"Find Flights\"]")).click();
		int j=0;
		for(int i=1;i<=5;i++) {
			
		String s3 =d.findElement(By.xpath("//div[@class='container']//tr["+i+"]/td[2]")).getText();
		int num=Integer.parseInt(s3);
		
		a[j]=num;
		j++;
		
		}
		
		
		Arrays.sort(a);
		
		
		System.out.println("Board to this flight "+ a[0]);
		if(d.findElement(By.xpath("//div[@class='container']//tr[4]/td[2]")).getText().equals("12")) {
			d.findElement(By.xpath("//div[@class='container']//tr[4]/td[1]")).click();
			//common attribute not found to locate so didn't use any looping  
			d.findElement(By.id("inputName")).sendKeys("Admin");
			d.findElement(By.id("address")).sendKeys("address");
			d.findElement(By.id("city")).sendKeys("city");
			d.findElement(By.id("state")).sendKeys("state");
			d.findElement(By.id("state")).sendKeys("zipCode");
			Select s3 = new Select(d.findElement(By.id("cardType")));
			s3.selectByIndex(1);
			d.findElement(By.id("nameOnCard")).sendKeys("Devil");
			d.findElement(By.id("rememberMe")).click();
			d.findElement(By.xpath("//input[@value=\"Purchase Flight\"]")).click();
			d.navigate().refresh();
			for(int i=0;i<3;i++) {
				d.navigate().back();
			}
			d.quit();
		}
	}
	
}