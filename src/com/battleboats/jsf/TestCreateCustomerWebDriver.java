package com.battleboats.jsf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class TestCreateCustomerWebDriver {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/BattleBoats/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testCreateCustomerWebDriver() throws Exception {
		selenium.open("/BattleBoats/faces/Player.xhtml");
		selenium.type("name=j_idt2:j_idt4", "7");
		selenium.type("name=j_idt2:j_idt6", "llovegood");
		selenium.type("name=j_idt2:j_idt8", "Luna Lovegood");
		selenium.click("name=j_idt2:j_idt10");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=j_idt2:j_idt13");
		selenium.waitForPageToLoad("30000");
		verifyEquals("llovegood", selenium.getText("//form[@id='j_idt2']/table/tbody/tr[10]/td[2]"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
