package com.facebook.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.facebook.generic.lib.BaseTest;

public class FbValidLoginTest extends BaseTest {
	BaseTest bt=new BaseTest();
	@Test(priority=1)
	public void openFB() throws Throwable
	{
		
		String actualTitle=bt.openBrowser();
		String expectedTile = "Facebook – log in or sign up";
		assertEquals(actualTitle, expectedTile);
		//assertNotEquals(expectedTile, actualTitle);
		//assertTrue(false);
		//assertFalse(true);
	}
	
	@Test(priority=2)
	public void loginFB() throws Throwable
	{
		bt.loginToApp();
	}
	
	@Test(priority=3)
	public void notif() throws InterruptedException
	{
		Thread.sleep(4000);
		bt.readNotifications();
	}
}