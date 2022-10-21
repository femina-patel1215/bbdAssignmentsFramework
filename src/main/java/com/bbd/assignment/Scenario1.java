package com.bbd.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {

	public static void main(String[] args) {
		// Microsoft Edge
		System.setProperty("webdriver.edge.driver", "C:/Users/bbdnet10169/Documents/Jars/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		try {
			driver.manage().window().maximize();
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			driver.get("http://automationpractice.com/index.php");
			// driver.get("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0");
			StartupPage stpage = new StartupPage(driver);
			WebElement topmenu = stpage.topmenu1;
			topmenu.click();
			WebElement blackcolor = stpage.blackcolor;
			blackcolor.click();
			WebElement dresses = stpage.dresses;
			dresses.click();
			WebElement eveningdress = stpage.eveningdress;
			eveningdress.click();
			WebElement product = stpage.product;

			actions.moveToElement(product).perform();
			WebElement qw = stpage.qview;
			if (qw.isDisplayed()) {
				qw.click();
			}

			driver.switchTo().frame(stpage.iframe);

			System.out.println(stpage.verifyContent());

			stpage.selectsize();
			stpage.addtocart.click();

			stpage.successMsgVerify();

			stpage.proceedtoCheckout1();
			stpage.proceedtoCheckout2();

			Login login = new Login(driver);
			login.loginUser();

			login.placeOrder();
			login.verifyOrderContent();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}
}
