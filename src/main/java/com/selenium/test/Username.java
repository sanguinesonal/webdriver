package com.selenium.test;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Cookie.Builder;

public class Username {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.gmail.com");
		Cookie cookie1 = new Cookie("ACCOUNT_CHOOSER", "AFx_qI5DW8GPvwowQ62Nq5ZaUIh18NHxHcHR5NzwYryIyWnHnxo4TG3alxT6LYbux-0ZJDCjcDPD4WYzCD-g_PePla_p7kiDOKo9BG3JtOL3PlRB3apWoGsizZ4_Ct7oJI9OphWkKmTv");
		driver.manage().addCookie(cookie1);
		Thread.sleep(2000);
		driver.get("http://www.gmail.com");
		Cookie ck = new Cookie.Builder("SID", "uwTmWoy80DDkKPb7VwDCFr187n2DrG0WP_BiL0-1iXK5VQEHH--Usf6I6hiea9fwfLvIcA.").domain("google.com").build();
		driver.manage().addCookie(ck);
		//Cookie ck1 = new Cookie.Builder("SID", "uwTmWoy80DDkKPb7VwDCFr187n2DrG0WP_BiL0-1iXK5VQEHH--Usf6I6hiea9fwfLvIcA.").domain("google.co.in").build();
		//driver.manage().addCookie(ck1);
		//driver.manage().addCookie(new Cookie("SID", "uwTmWoy80DDkKPb7VwDCFr187n2DrG0WP_BiL0-1iXK5VQEHH--Usf6I6hiea9fwfLvIcA.", "google.co.in", "/", null));
		
		Thread.sleep(2000);
		driver.get("https://mail.google.com");
		
		
			Set<org.openqa.selenium.Cookie> cookiesList1 =  driver.manage().getCookies();
			for(org.openqa.selenium.Cookie getcookies :cookiesList1) {
			    System.out.println(getcookies);
			    System.out.println("");
			}
			
			Thread.sleep(2000);
			driver.get("https://www.facebook.com");
			Cookie ck4 = new Cookie.Builder("c_user", "1332739633").domain("facebook.com").build();
			//Cookie ck4 = new Cookie("c_user", "1332739633");
			driver.manage().addCookie(ck4);
			 System.out.println("FACEBOOK");
			Set<org.openqa.selenium.Cookie> cookiesList2 =  driver.manage().getCookies();
			for(org.openqa.selenium.Cookie getcookies :cookiesList2) {
			    System.out.println(getcookies);
			    System.out.println("");
			}
			
	}
}