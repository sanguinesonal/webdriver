package com.selenium.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.http.cookie.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://gmail.com/");
		driver.findElement(By.id("identifierId")).sendKeys("sonal.agar12@gmail.com");
		driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sonalsonal");
		driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
		
		Set<org.openqa.selenium.Cookie> cookiesList2 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies :cookiesList2) {
		    System.out.println(getcookies);
		    System.out.println("");
		}
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class='gb_9a gbii']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='gb_Ha gb_nf gb_uf gb_yb']")).click();
		
		System.out.println("After Logout");
		
		Set<org.openqa.selenium.Cookie> cookiesList3 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies1 :cookiesList3) {
		    System.out.println(getcookies1);
		    System.out.println("");
		
		}
		 /*Set<org.openqa.selenium.Cookie> allCookies = driver.manage().getCookies();
		
		System.out.println("After login");
		Set<org.openqa.selenium.Cookie> cookiesList1 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies :cookiesList1) {
			System.out.print(getcookies.getName());
			System.out.println("");
		    System.out.println(getcookies.getValue());
		    System.out.println("");
		    System.out.println(getcookies.getDomain());
		    System.out.println("");
		    System.out.println(getcookies.getPath());
		    System.out.println("");
	}
		
		
		org.openqa.selenium.Cookie cookie1 = driver.manage().getCookieNamed("ACCOUNT_CHOOSER");
		Date Exp = cookie1.getExpiry();
		System.out.println(Exp);
		//Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.DATE, -1);
		
		//driver.manage().deleteCookieNamed("ACCOUNT_CHOOSER");
		//driver.manage().deleteCookieNamed("GAPS");
		//driver.manage().deleteAllCookies();
		
		
		System.out.println("Deleted Cookies");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Set<org.openqa.selenium.Cookie> cookiesList2 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies :cookiesList2) {
		    System.out.println(getcookies);
		    System.out.println("");
		
		// TODO Auto-generated method stub

	}
		driver.navigate().refresh();
		//driver.manage().addCookie((cookie1));
		//driver.manage().addCookie((org.openqa.selenium.Cookie) cookiesList1);
		Thread.sleep(5000);
		 for(org.openqa.selenium.Cookie cookie : allCookies) {
	            driver.manage().addCookie(cookie);
	            
		driver.navigate().refresh();
		driver.get("https://gmail.com/");
		
		System.out.println("Final Cookies");
		
		Set<org.openqa.selenium.Cookie> cookiesList3 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies :cookiesList3) {
		    System.out.println(getcookies);
		    System.out.println("");
	}*/

		
		File file = new File("Cookies.data");							
        try		
        {		
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
            // loop for getting the cookie information 		
            for(org.openqa.selenium.Cookie ck : driver.manage().getCookies())							
            {		
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
                Bwrite.newLine();			
        }		
            Bwrite.flush();			
            Bwrite.close();			
            fileWrite.close();			
        }catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
		}
	}