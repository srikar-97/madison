package com.htc.madison.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.htc.madison.utilites.Utility;

public class HomePage extends BasePage{
	@FindBy(xpath = "//div[@class='block-content']//ul//li[@class='current']//a//strong")
	private WebElement dashboardBy;
	@FindBy(xpath = "//strong[contains(text(),\"Hello, Indraganti sai srikar!\")]")
	private WebElement assertcheckBy;
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchproducts;
	@FindBy(xpath = "//button[@class='button search-button']")
	private WebElement clicksearch;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void Home_Page(String search) {
		try {
			Utility.waitToBeVisibile(dashboardBy, driver);
			dashboardBy.click();
			searchproducts.click();
			searchproducts.sendKeys(search);
			clicksearch.click();
		} catch (NoSuchElementException | StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}
	}

	public WebDriver driver() {
		return driver;
	}

	public String assert_login() {
		return assertcheckBy.getText();

	}
}
