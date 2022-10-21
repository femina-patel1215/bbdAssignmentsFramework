package com.bbd.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StartupPage extends AbstractComponent{

	WebDriver driver;
	
	// TODO Auto-generated method stub
	public StartupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement topmenu1;
	@FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li[3]/label/a")
	WebElement blackcolor;

	@FindBy(xpath = "//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img")
	WebElement dresses;

	@FindBy(xpath = "//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a")
	WebElement eveningdress;

	@FindBy(className = "ajax_block_product")
	WebElement product;

	@FindBy(className = "quick-view")
	WebElement qview;

	@FindBy(className = "fancybox-iframe")
	WebElement iframe;

	@FindBy(xpath = "//*[@id=\"product\"]/div/div/div[2]/h1")
	WebElement name;

	@FindBy(xpath = "//*[@id=\"product\"]/div/div/div[3]/form/div/div/div/p/span")
	WebElement price;

	@FindBy(xpath = "//*[@id=\"product\"]/div/div/div[2]/p")
	WebElement model;

	@FindBy(xpath = "//*[@id=\"product\"]/div/div/div[2]/p[2]")
	WebElement condition;

	@FindBy(xpath = "//*[@id=\"product\"]/div/div/div[2]/div/div/p")
	WebElement desc;

	public String verifyContent() {
		if (name.getText().equals("Printed Dress")
				&& price.getText().equals("$50.99")
				&& model.getText().equals("Model demo_4")
				&& condition.getText().equals("Condition New")
				&& desc.getText().equals("Printed evening dress with straight sleeves with black thin waist belt and ruffled linings."))
			return "PASS";
					
		else
			return "Fail";

	}
	@FindBy(id="group_1")
	WebElement sizeEle;
	@FindBy(id="add_to_cart")
	WebElement addtocart;
	
	public void selectsize() {
		Select size=new Select(sizeEle);
		size.selectByValue("2");
	}
	
	
	By MsgWait=By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	 WebElement msg;
	public void successMsgVerify() {
		waitForElementApper(MsgWait);
		if(msg.getText().equals("Product successfully added to your shopping cart")) {
			System.out.println("Message verified");
		}
		else {
			System.out.println("Message incorrect");
		}
	}
@FindBy(xpath ="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")	
WebElement checkout1;
public void proceedtoCheckout1() {
	checkout1.click();
	navigateForward();
}
@FindBy(xpath ="//*[@id=\"center_column\"]/p[2]/a[1]/span")	
WebElement checkout2;
public void proceedtoCheckout2() {
	checkout2.click();
}
}
