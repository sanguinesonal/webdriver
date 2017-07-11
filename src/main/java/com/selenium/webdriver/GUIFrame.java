
package com.selenium.webdriver;


import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

public class GUIFrame implements ActionListener {
	JFrame fr;
	JLabel lb1;
	JTextField tf1;
	JButton b1;

	GUIFrame() {
		fr = new JFrame("Form");
		fr.setLayout(null);
		fr.setTitle("Bug Calculator Application");

		lb1 = new JLabel("Template ID");
		tf1 = new JTextField();
		b1 = new JButton("OK");

		lb1.setBounds(30, 50, 100, 25);
		tf1.setBounds(150, 50, 100, 30);
		b1.setBounds(80, 100, 80, 40);
		fr.add(lb1);
		fr.add(tf1);
		fr.add(b1);
		b1.addActionListener(this);

		//fr.setSize(320, 220);
		fr.setBounds(500, 150, 320, 220);
		fr.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			if (e.getSource() == b1) {
				
				String projectId = new String();

				Scanner input = new Scanner(System.in);
				System.out.println("Enter a Project ID: ");
				projectId = input.nextLine();

				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Workspace-Webdriver\\chromedriver.exe");

				WebDriver driver = new ChromeDriver();

				driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				driver.get("https://basecamp.com/");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='top']/ul/li[1]/a"))).click();
				// driver.findElement(By.xpath(".//*[@id='top']/ul/li[1]/a")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_hint")))
						.sendKeys("agarwal.sonal@thinksys.com");
				// driver.findElement(By.id("login_hint")).sendKeys("agarwal.sonal@thinksys.com");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']"))).click();
				// driver.findElement(By.xpath("//input[@name='commit']")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@id='password']")))
						.sendKeys("thinksys@123");
				// driver.findElement(By.xpath("
				// //input[@id='password']")).sendKeys("thinksys@123");

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[1]/div[1]/form[2]/button[2]"))).click();
				// driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/form[2]/button[2]")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("#all_projects > .projects.with_archived header .archived a"))).click();
						// driver.findElement(By.cssSelector("#all_projects >
						// .projects.with_archived header .archived a")).click();

				// int projectId = 400;
				// String selectorString = String.format("//*[contains(text(),'{0}')]",
				// projectId);

				String selectorString = "//*[contains(text(),'" + projectId + "')]";

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorString))).click();
				// driver.findElement(By.xpath(selectorString)).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='workspace']/div/div/div[2]/section[3]/div/p[2]/a[2]")))
						.click();
				// driver.findElement(By.xpath(".//*[@id='workspace']/div/div/div[2]/section[3]/div/p[2]/a[2]")).click();

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> bugCount = driver.findElements(By.xpath("//*[contains(text(),'$')]"));

				int count = bugCount.size();
				count = (count - 1) / 2;
				System.out.println("Template ID is : " + projectId);
				System.out.println("Number of Bugs in template is = " + count);
				
				
				JOptionPane.showMessageDialog(null, "Template ID : " + projectId + "\n" + "Bug Count :" + count);

			}
		} catch (NumberFormatException n) {
			System.out.println("Check the input fields");
		}
		
	}
}