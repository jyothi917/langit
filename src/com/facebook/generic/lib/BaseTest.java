package com.facebook.generic.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.facebook.pages.LoginPageElements;

public class BaseTest implements AutoConstants{
	public static WebDriver driver;
	Filelib flib=new Filelib();
	LoginPageElements lp; 
	
	public String openBrowser() throws Throwable
	{
		String browserValue = flib.getPropertyKeyValue(PROP_PATH, "browser");
		if(browserValue.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if(browserValue.equals("firefox"))
		{
			//System.setProperty(GECKO_KEY, GECKO_VALUE);

			driver=new FirefoxDriver();			
		}
		else
		{
			System.out.println("Enter correct browser");
		}

		driver.get(flib.getPropertyKeyValue(PROP_PATH,"url"));


		return driver.getTitle();

	}



	public void loginToApp() throws Throwable
	{
		lp=new LoginPageElements(driver);
		Thread.sleep(2000);
		lp.setUsername(flib.getPropertyKeyValue(PROP_PATH, "username"));
		lp.setPassword(flib.getPropertyKeyValue(PROP_PATH, "password"));
		lp.clickLogin();

	}
	public void loginWithInvalid(String str) throws Throwable
	{
		lp=new LoginPageElements(driver);
		int rc=flib.getRowCount(EXCEL_PATH, str);

		for(int i=1;i<=rc;i++)
		{
			String username=flib.getExcelData(EXCEL_PATH, str, i, 0);
			lp.setUsername(username);
			String pwd=flib.getExcelData(EXCEL_PATH, str, i, 1);
			lp.setPassword(pwd);
			lp.clickLogin();
		}

	}

	public void readNotifications()
	{
		lp=new LoginPageElements(driver);
		lp.setNotification();
	}

	public void closeBrowser()
	{
		driver.quit();
	}

}
