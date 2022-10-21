package com.bbd.assignment;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {

	public static void main(String[] args) {
		// Microsoft Edge
		System.setProperty("webdriver.edge.driver", "C:/Users/bbdnet10169/Documents/Jars/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			Actions actions = new Actions(driver); 
			
			
			// Drag and drop


			//----------------------------------------------------------------------------------------------------------------------------------------
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a")).click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			actions.dragAndDrop(drag, drop).perform();
			// Button
			
			driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a"))
					.click();

			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a")))
					.click();
			// Locating the element from Sub Menu
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement btn = driver.findElement(By.xpath("/html/body/div/button"));

			// To mouseover on sub menu actions.moveToElement(btn);

			// build()- used to compile all the actions into a single step
			actions.click().build().perform();
			WebElement btn2 = driver.findElement(By.xpath("/html/body/div/input"));
			actions.moveToElement(btn2);
			actions.click().build().perform();

			WebElement btn3 = driver.findElement(By.xpath("/html/body/div/a"));
			actions.moveToElement(btn3);
			actions.click().build().perform(); // Css button

			WebElement cssbtn1 = driver.findElement(By.xpath("/html/body/button"));

			// To mouseover on sub menu actions.moveToElement(cssbtn1);

			// build()- used to compile all the actions into a single step
			actions.click().build().perform();
			WebElement cssbtn2 = driver.findElement(By.xpath("/html/body/input"));
			actions.moveToElement(cssbtn2);
			actions.click().build().perform();

			WebElement cssbtn3 = driver.findElement(By.xpath("/html/body/a"));
			actions.moveToElement(cssbtn3);
			actions.click().build().perform();

			// Checkboxradio
			driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[4]/a"))
					.click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement radio1 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]"));
			radio1.click();
			radio1 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[2]"));
			radio1.click();
			radio1 = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[3]"));
			radio1.click();

			WebElement checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[1]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[3]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[4]"));
			checkbox.click();

			WebElement nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[1]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[2]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[3]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[4]"));
			nestedCheckbox.click();

			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[1]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[3]"));
			checkbox.click();
			checkbox = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[4]"));
			checkbox.click();

			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[1]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[2]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[3]"));
			nestedCheckbox.click();
			nestedCheckbox = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[4]"));
			nestedCheckbox.click();

			// Control group
			driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[5]/a"))
					.click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"car-type-button\"]"));
			dropdown.click();
			WebElement carTypeMenu = driver.findElement(By.xpath("//*[@id=\"car-type-menu\"]"));
			List<WebElement> options = carTypeMenu.findElements(By.className("ui-menu-item"));
			options.stream().filter(a -> a.getText().equals("SUV")).findFirst().get().click();
			dropdown.click();
			options.stream().filter(a -> a.getText().equals("Truck")).findFirst().get().click();
			dropdown.click();
			options.stream().filter(a -> a.getText().equals("Van")).findFirst().get().click();

			// second
			WebElement dropdown1=driver.findElement(By.xpath("//*[@id=\"ui-id-8-button\"]"));
			dropdown1.click();
			WebElement ctype=driver.findElement(By.xpath("//*[@id=\"ui-id-8-menu\"]"));
			List<WebElement> list=ctype.findElements(By.className("ui-menu-item"));
			if(list.get(3).getText().equals("SUV")) {
				list.get(3).click();
			}
			
			System.out.println(dropdown1.getText());
			
			
 
			driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"))
					.click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
			Thread.sleep(2000);
			String target_year = "2020";
			String target_month = "April";
			String[] m1 = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			String target_date = "1";
			String space = " ";
			String targetmy = target_month + space + target_year;
			WebElement y = driver.findElement(By.className("ui-datepicker-year"));
			String selected_year = y.getText();
			WebElement m = driver.findElement(By.className("ui-datepicker-month"));
			String selected_month = m.getText();

			// Concatenate selected month and year strings
			String ym = selected_month + selected_year;
			while (ym != targetmy) {

				if (((Integer.parseInt(target_year)) < Integer.parseInt(selected_year))) {

					// WebElement
					// prew=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]"));

					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]"))).click();
				} else if (((Integer.parseInt(target_year)) > Integer.parseInt(selected_year))) {
					WebElement next = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));

					next.click();
				} else {
					if (target_month.equals(selected_month)) {
						WebElement d = driver.findElement(
								By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
										+ target_date + "']"));
						d.click();

						Thread.sleep(10000);
						break;
					} else {
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]"))).click();

					}
				}

				y = driver.findElement(By.className("ui-datepicker-year"));
				selected_year = y.getText();
				m = driver.findElement(By.className("ui-datepicker-month"));
				selected_month = m.getText();
				ym = selected_month + space + selected_year;

			}
			//Dialog			
			driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[7]/a"))
			.click();
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	System.out.println(driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]")).getText());
	System.out.println(driver.findElement(By.id("dialog")).getText());
	actions.dragAndDropBy(driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]")), 150, 40).build().perform();
	driver.findElement(By.xpath("/html/body/div/div[1]/button")).click();
	
//Tags
	driver.switchTo().defaultContent().findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[13]/a"))
	.click();
driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText("Proin dolor")))).click();

wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText("Aenean lacinia")))).click();
wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText("Nunc tincidunt")))).click();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// driver.quit();
		}
	}
}
