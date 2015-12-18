package com.battleboats.jsf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreateCustomer {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/BattleBoats/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateCustomer() throws Exception {
    driver.get(baseUrl + "/BattleBoats/faces/Player.xhtml");
    driver.findElement(By.name("j_idt2:j_idt4")).clear();
    driver.findElement(By.name("j_idt2:j_idt4")).sendKeys("7");
    driver.findElement(By.name("j_idt2:j_idt6")).clear();
    driver.findElement(By.name("j_idt2:j_idt6")).sendKeys("llovegood");
    driver.findElement(By.name("j_idt2:j_idt8")).clear();
    driver.findElement(By.name("j_idt2:j_idt8")).sendKeys("Luna Lovegood");
    driver.findElement(By.name("j_idt2:j_idt10")).click();
    driver.findElement(By.name("j_idt2:j_idt13")).click();
    try {
      assertEquals("llovegood", driver.findElement(By.xpath("//form[@id='j_idt2']/table/tbody/tr[10]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
//      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
      if (acceptNextAlert) {
//        alert.accept();
      } else {
//        alert.dismiss();
      }
      return "";// alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
