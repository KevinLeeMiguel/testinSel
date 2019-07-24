package com.testing.performance.scripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import step.handlers.javahandler.AbstractKeyword;
import step.handlers.javahandler.Keyword;

public class Testes extends AbstractKeyword {

	@Keyword(name= "openChrome")
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Selenium and step\\chromedriver_win32\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		session.put("driver",chrome);
	}
	
	@Keyword(name= "closeChrome")
	public void closeDriver() {
		WebDriver chrome = (WebDriver) session.get("driver");
		chrome.close();
	}

	@Keyword(name = "createStudent")
	public void createStudent() throws InterruptedException {
		long sleepTime = Long.parseLong(input.getString("sleepTime"));
		WebDriver chrome = (WebDriver) session.get("driver");
		chrome.get("http://localhost:8083/StudentReg");
		WebElement el = chrome.findElement(By.xpath("//button[text()='Register']"));
		chrome.findElement(By.xpath("//input[@id='name']")).sendKeys("Iradukunda Lee Miguel Kevin");
		chrome.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
		chrome.findElement(By.xpath("//select[@id='gender']/option[text()='Male']"));
		el.click();
		chrome.findElement(By.xpath("//h1[text()='Student Registration!']"));
		sleep(sleepTime);
	}

	public void sleep(long duration) throws InterruptedException {
		Thread.sleep(duration);
	}

	@Test
	public void testChrome() throws InterruptedException {
		createStudent();
	}

}
