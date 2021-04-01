package com.htc.madison.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.madison.BaseTest;

public class LoginTest extends BaseTest {
	@Test(dataProviderClass = com.htc.madison.utilites.Data_Provider.class, dataProvider = "Madison")
	@Parameters("SheetName")
	public void Valid_And_Invalid_Login(Map<String, String> mapData) throws IOException, InterruptedException {
		login.Login_To_Page(mapData.get("emailid"), mapData.get("password"));
		/*
		 * System.out.println(mapData.get("assert"));
		 * System.out.println(homepage.assert_login());
		 */
		Assert.assertEquals(homepage.assert_login(), mapData.get("assert"));
}
	}