package com.selenium.test;

import java.io.Console;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Checker {
	static void getPartnerValueString(String s) throws InterruptedException {
		System.out.println("STARTING TEST CASE FOR THE URL ENTERED : " + s);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(s);
		Thread.sleep(30000);
		if (s.contains("partner")) {
			System.out.println("FLOW IS INORGANIC");
		} else {
			Cookie ck = driver.manage().getCookieNamed("organic");
			System.out.println("FLOW IS ORGANIC : " + ck.getValue());
		}
		Cookie ck2 = driver.manage().getCookieNamed("partner");
		System.out.println("PARTNER IS : " + ck2.getValue());
		if (s.contains("campaign")) {
			Cookie ck3 = driver.manage().getCookieNamed("campaign");
			System.out.println("CAMPAIGN IS : " + ck3.getValue());
		} else {
			System.out.println("NO CAMPAIGN VALUE IS SET FOR THE URL");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/images/bt_downloadnow_normal.png']")).click();
		Thread.sleep(20000);
		String dip_url = driver.getCurrentUrl();
		System.out.println("URL ENTERED BY THE USER AT RUNTIME : " +s);
		System.out.println("URL OF DOWNLOAD INSTRUCTION PAGE : "+dip_url);
		//System.out.println(dip_url);
		//driver.quit();
	}

	static void getPartnerValueGoogle(String s, int n) throws InterruptedException {
		String val = s.concat(" smilebox");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		System.out.println("STARTING TEST CASE FOR THE GOOGLE SEARCH : " + val);
		Thread.sleep(2000);
		driver1.get("http://www.google.com");
		driver1.findElement(By.xpath("//input[@name='q']")).sendKeys(val);
		driver1.findElement(By.xpath(" //button[@class='sbico-c']")).click();
		Thread.sleep(4000);
		driver1.findElements(By.xpath("//a[contains(text(),'Smilebox')]")).get(n).click();
		Thread.sleep(30000);
		String page_url = driver1.getCurrentUrl();
		Cookie ck3 = driver1.manage().getCookieNamed("organic");
		System.out.println("FLOW IS ORGANIC : " + ck3.getValue());
		Cookie ck4 = driver1.manage().getCookieNamed("partner");
		System.out.println("PARTNER IS : " + ck4.getValue());
		if (s.contains("campaign")) {
			Cookie ck5 = driver1.manage().getCookieNamed("campaign");
			System.out.println("CAMPAIGN IS : " + ck5.getValue());
		} else {
			System.out.println("NO CAMPAIGN VALUE IS SET FOR THE URL");
		}
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//img[@src='/images/bt_downloadnow_normal.png']")).click();
		Thread.sleep(20000);
		String dip_url = driver1.getCurrentUrl();
		System.out.println("URL SELECTED BY THE USER AT RUNTIME : " +page_url);
		System.out.println("URL OF DOWNLOAD INSTRUCTION PAGE : "+dip_url);
		//driver1.quit();

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Boolean s = null;
		String sb = "";
		// TODO Auto-generated method stub
		do {
			System.out.println("Choose Your Option");
			System.out.println("");
			System.out.println("1.Use Direct URL : ");
			System.out.println("2.Use Google Search Flow : ");
			// System.out.println("3.Exit : ");
			Scanner option = new Scanner(System.in);
			int val_option = option.nextInt();
			if (val_option == 1) {

				Scanner reader = new Scanner(System.in);
				System.out.println("Enter the URL : ");
				String url1 = reader.nextLine();
				getPartnerValueString(url1);
			} else {
				Scanner reader = new Scanner(System.in); // Reading from
															// System.in
				System.out.println("Enter the KEYWORD : ");
				String url = reader.nextLine();
				System.out.println("Enter the number of URL  : ");
				int number = reader.nextInt();
				getPartnerValueGoogle(url, number);
			}
			System.out.println("Do you want to continue(Y/N)");
			Scanner reader = new Scanner(System.in);
			sb = reader.nextLine();
			if(sb.contains("y"))
			{
				s=true;
			}
			else{
				System.out.println("Thank You!!!!!!!");
				break;
			}
		} while (s == true);
		
	}
}
