package com.test.mo.automation.uiaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.mo.automation.testbase.Testbase;

public class test extends Testbase {
	
	WebDriver driver;
	
	@FindBy(xpath=".//input[@id='login_input_username']")
	WebElement loginName;
	
	
	@FindBy(xpath="//input[@id='login_input_password']")
	WebElement loginPwd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;

	public test(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void login() throws InterruptedException{
		loginName.sendKeys("vignesh");
		loginPwd.sendKeys("vignesh@123");
		Thread.sleep(10000);
		loginButton.click();
	}
	
}
