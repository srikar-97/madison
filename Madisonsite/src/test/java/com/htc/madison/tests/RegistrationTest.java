package com.htc.madison.tests;

import org.testng.annotations.Test;

import com.htc.madison.BaseTest;
import com.htc.madison.pages.RegistrationPage;

import org.testng.Assert;
import java.io.IOException;
import java.util.Map;


public class RegistrationTest extends BaseTest {
	

	@Test(dataProviderClass = com.htc.madison.utilites.Data_Provider.class, dataProvider = "Madison")
	public void Valid_And_Invalid_Registration(Map<String, String> mapData) throws IOException, InterruptedException {

		RegistrationPage registration = new RegistrationPage(this.driver);

		registration.Registration_To_Page(mapData.get("firstname"), mapData.get("middlename"), mapData.get("lastname"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
		registration.assertcheckBy();
		Assert.assertEquals(registration.assertcheckBy(),mapData.get("assert"));
		

	}
}
