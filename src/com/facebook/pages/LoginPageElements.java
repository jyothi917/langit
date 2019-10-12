package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {
	
	@FindBy(id="email") private WebElement usernameTB;
	public void setUsername(String un)
	{
		usernameTB.sendKeys(un);
	}
	
	@FindBy(id="pass") private WebElement passwordTB;
	public void setPassword(String pwd)	{
		passwordTB.sendKeys(pwd);
	}
	
	@FindBy(id="loginbutton") private WebElement loginBtn; 
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public LoginPageElements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="notificationsCountValue") private WebElement notificationTB;
	public void setNotification()
	{
		notificationTB.click();
	}
	
	
	}


