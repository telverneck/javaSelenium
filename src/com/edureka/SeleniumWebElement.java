package com.edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edureka.BasePage.BasePage;

public class SeleniumWebElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String baseURL = "https://www.amazon.com.br";

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(baseURL);

		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		String searchInput = "PlayStation 4";
		String trueTitle = "Amazon.com";

		WebElement searchButton = driver.findElement(By.cssSelector("input[value='Ir']"));

		BasePage.sendKeys(driver, searchBar, 20, searchInput);

		BasePage.click(driver, searchButton, 20);

		WebElement firstResult = driver
				.findElement(By.xpath("//div[@data-index='1']//a/span[contains(text(),'Console')]"));

		BasePage.click(driver, firstResult, 20);

		WebElement addCartButton = driver.findElement(By.cssSelector("input[id='add-to-cart-button']"));

		BasePage.click(driver, addCartButton, 20);

//		driver.findElement(By.id(searchBar)).sendKeys(searchInput);
//		driver.findElement(By.cssSelector(searchButton)).click();
//		driver.findElement(By.cssSelector(firstResult)).click();
//		driver.findElement(By.xpath(addCartButton)).click();

		String title = driver.getTitle();

		if ((title.contains(trueTitle)) || (title.contains(searchInput))) {
			System.out.print("Teste ok! \n" + title);

		} else
			System.out.print("Fails! title found: '" + title + "'");

		driver.quit();
	}

}
