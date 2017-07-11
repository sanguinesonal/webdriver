package com.selenium.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.util.Cookie;

public class Retest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://gmail.com/");
		
		try{			
		     
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer Tokenizertoken = new StringTokenizer(strline,";");									
	        StringTokenizer token;
			while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;	
	     
	        if(!(val=token.nextToken()).equals("null"))
			{	
	        
	        	//expiry = new Date(val);			
	        }		
	        Boolean isSecure = new Boolean(token.nextToken()).								
	        booleanValue();		
	        org.openqa.selenium.Cookie ck = new org.openqa.selenium.Cookie(name,value,domain,path,expiry,isSecure);																	
	        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
	        }		
	        }catch(Exception ex){					
	        ex.printStackTrace();			
	        }		
	        driver.get("http://demo.avactis.com/4.7.9/");	

	}

}
