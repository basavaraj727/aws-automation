package com.amazon.addtocart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazonaddtocart {

	public static WebDriver oBrowser=null;
	
	
	@Test(priority=1)
	public static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "E:\\DemoWorkSpace\\AmazonDemo\\Library\\Drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	@Test(priority=2)
	public static void navigate()
	{
		try
		{
			oBrowser.get("https://www.amazon.in/");
			Thread.sleep(1000);
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public static void selectitem()
	{
		try
		{
			oBrowser.findElement(By.id("twotabsearchtextbox")).sendKeys("basicphones");
			oBrowser.findElement(By.id("nav-search-submit-button")).click();
			oBrowser.findElement(By.xpath("//span[text()='Samsung']")).click();
			oBrowser.findElement(By.xpath("//span[text()='Less Than 999 mAh']")).click();
			Thread.sleep(1000);
			
			
			List<WebElement> imagesize=oBrowser.findElements(By.xpath("//img[@class='s-image"));
			System.out.println("No of image avilable"+imagesize.size());
			
			oBrowser.findElement(By.xpath("//span[text()='(Renewed) Samsung Guru GT-E1200 (White)']")).click();
			Thread.sleep(2000);
			Set<String> windowhandles=oBrowser.getWindowHandles();
			Iterator<String> olist=windowhandles.iterator();
			String parentBrowser=olist.next();
			String childBrowser=olist.next();
			oBrowser.switchTo().window(childBrowser);
			
			oBrowser.findElement(By.name("submit.add-to-cart")).click();
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public static void writedatatocsv()
	{
	
		try
		{
			FileWriter fr=new FileWriter("E:\\DemoWorkSpace\\AmazonDemo\\Files\\Test.csv",true);
			
			BufferedWriter br=new BufferedWriter(fr);
			
			br.write("Mobile name is:(Renewed) Samsung Guru GT-E1200 (White)");
			br.write("Mobile price is:Rs1300");
			System.out.println("Written successfully");
			br.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
