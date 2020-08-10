package com.edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String baseURL = "https://www.amazon.com.br";
		String searchBar = "twotabsearchtextbox";
		String searchInput = "ps4";
		String trueTitle = "Amazon.com.br";

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.findElement(By.id(searchBar)).sendKeys(searchInput);
		driver.findElement(By.id(searchBar)).submit();

		String title = driver.getTitle();

		if ((title.contains(trueTitle)) && (title.contains(searchInput))) {
			System.out.print("Teste ok! \n" + title);

		} else
			System.out.print("Fails " + title);

		driver.quit();
	}

}
