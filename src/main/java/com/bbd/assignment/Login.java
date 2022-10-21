package com.bbd.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login extends AbstractComponent {

//Design Pattern: Using Page Object and Factory Implementation
	WebDriver driver;

	// TODO Auto-generated method stub
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By email = By.xpath("//*[@id=\"email\"]");
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailid;
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
	WebElement submitbtn;

	public void loginUser() {
		emailid.sendKeys("femina@bbd.co.za");
		password.sendKeys("F12345");
		submitbtn.click();
		navigateForward();

	}

	@FindBy(xpath = "//*[@id=\"id_address_delivery\"]")
	WebElement selectAddress;
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
	WebElement btnproceed;
	@FindBy(xpath = "//*[@id=\"cgv\"]")
	WebElement checkbox;
	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
	WebElement cbtn;
	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement paymnt;
	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	WebElement cartnavigation;

	public void placeOrder() {
		Select deliveryAddress = new Select(selectAddress);
		deliveryAddress.selectByValue("754691");
		btnproceed.click();
		navigateForward();
		checkbox.click();
		cbtn.click();
		navigateForward();
		paymnt.click();
		navigateForward();
		cartnavigation.click();
		navigateForward();
	}

	@FindBy(xpath = "//*[contains(text(),'Your order on My Store')]")
	List<WebElement> list;

	public void verifyOrderContent() {
		String str = "Your order on My Store is complete.Please send us a bank wire with\r\n" + "- Amount $52.99\r\n"
				+ "- Name of account owner Pradeep Macharla\r\n" + "- Include these details xyz\r\n"
				+ "- Bank name RTP\r\n"
				+ "- Do not forget to insert your order reference UWRANUXOB in the subject of your bank wire.\r\n"
				+ "An email has been sent with this information.\r\n"
				+ "Your order will be sent as soon as we receive payment.\r\n"
				+ "If you have questions, comments or concerns, please contact our expert customer support team. .\r\n"
				+ "\r\n" + "N	";
		if (list.size() > 0) {
			System.out.println(str);
		} else {
			System.out.println("Failed");
		}
	}

}
