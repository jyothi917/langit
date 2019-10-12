package com.facebook.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.facebook.generic.lib.BaseTest;

public class FbInvalidLoginTest {
	@Test
	public void invalidlogin() throws Throwable
	{
		
		BaseTest bt=new BaseTest();
		String actualTitle=bt.openBrowser();
		String expected="Facebook – log in or sign up";
		assertEquals(actualTitle, expected);
		bt.loginWithInvalid("Invalid");

	}

}
