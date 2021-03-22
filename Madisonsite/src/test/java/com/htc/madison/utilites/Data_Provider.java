package com.htc.madison.utilites;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.htc.madison.constants.Constants;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;



public class Data_Provider {

	@DataProvider(name = "Madison")
	public Object[][] Madison_Valid_And_Invalid_RegisterData(Method m) {
		Object[][] loginDataSet = null;
		ExcelFileManager excelfile = new ExcelFileManager(Constants.EXCELFILE_PATH);
		if (m.getName().equals("Valid_And_Invalid_Registration")) {
			loginDataSet = excelfile.getDataAsHashMap(Constants.REGISTRATION_SHEETNAME);
		} else if (m.getName().equals("Valid_And_Invalid_Login")) {
			loginDataSet = excelfile.getDataAsHashMap(Constants.LOGIN_SHEETNAME);
		}

		return loginDataSet;

	}

}
