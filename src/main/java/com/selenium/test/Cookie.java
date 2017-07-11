package com.selenium.test;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookie {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://www.gmail.com");
		org.openqa.selenium.Cookie cookie1 = new org.openqa.selenium.Cookie("ACCOUNT_CHOOSER", "AFx_qI5DW8GPvwowQ62Nq5ZaUIh18NHxHcHR5NzwYryIyWnHnxo4TG3alxT6LYbux-0ZJDCjcDPD4WYzCD-g_PePla_p7kiDOKo9BG3JtOL3PlRB3apWoGsizZ4_Ct7oJI9OphWkKmTv");
		driver.manage().addCookie(cookie1);
		org.openqa.selenium.Cookie cookie2 = new org.openqa.selenium.Cookie("NID", "103=jhpCEvOcUGcnDFdv4vpVgUIfxOQkiDpAJ2buIbMAx9ZgvCaEKI3Qc_yA4prDfdc3FwXRYLPuX0BDWSyoNnB091GskpucHh_WIy35K3sOQ5LDH5lg6ZOIZ9mCsMXx6x-tIpRzqilVHHKeQyyX4yRg");
		driver.manage().addCookie(cookie2);
		//org.openqa.selenium.Cookie cookie3 = new org.openqa.selenium.Cookie("CheckConnectionTempCookie327", "914514");
		//driver.manage().addCookie(cookie3);
		org.openqa.selenium.Cookie cookie4 = new org.openqa.selenium.Cookie("GAPS", "1:lApZEMHRs1jRrfaSvI8ZCdP5N1KP0w:Vw-4xdNE0Xce5xWG");
		driver.manage().addCookie(cookie4);
		org.openqa.selenium.Cookie cookie5 = new org.openqa.selenium.Cookie("GAPS", "1:EC_canUMSup0JpYN305n32p52mDtiw:m_iUv5QYfKv8MmiY");
		driver.manage().addCookie(cookie5);
		org.openqa.selenium.Cookie cookie8 = new org.openqa.selenium.Cookie("SSID", "AcPVTrbpe1w0zISRd");
		driver.manage().addCookie(cookie8);
		
		//driver.navigate().refresh();*/
		driver.manage().deleteCookieNamed("SSID");
		driver.manage().deleteCookieNamed("GAPS");
		Thread.sleep(2000);
		org.openqa.selenium.Cookie cookie6 = new org.openqa.selenium.Cookie("SSID", "A_fIdHgFR4udY6HhS");
		org.openqa.selenium.Cookie cookie7 = new org.openqa.selenium.Cookie("GAPS", "1:_O6th_P33ixpJzqjinxMC45NfQ25Gw:TQoNtbxXuoTv1REU");
		driver.manage().addCookie(cookie6);
		driver.manage().addCookie(cookie7);
		
		 //URL url = new URL("http://mail.google.com");
		// URLConnection conn = url.openConnection();
		 //conn.setRequestProperty("Cookie", "SSID=AKgkXII1pTMoriGyF");
		// conn.connect();
		 
		 driver.navigate().refresh();
		 driver.get("http://www.gmail.com");


		//HttpCookie ck = new HttpCookie("SSID", "AMot75bghiNmbVsDo");
		
		Set<org.openqa.selenium.Cookie> cookiesList1 =  driver.manage().getCookies();
		for(org.openqa.selenium.Cookie getcookies :cookiesList1) {
		    System.out.println(getcookies);
		    System.out.println("");
		
	}
}
}
