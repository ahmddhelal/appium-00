package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Main {

   AndroidDriver driver ;

   By usernameTxtBox = By.id("etMobile");
   By passwordTxtBox = By.id("etPassword");
   By loginBtn = By.id("btnDone");
   private final static Duration waitTime = Duration.ofSeconds(10);

   public void waitForVisibility(By locator) {
      WebDriverWait wait = new WebDriverWait(driver, waitTime);
      wait.until(ExpectedConditions.visibilityOf(element(locator)));
   }
   public WebElement element(By locator) {
      return driver.findElement(locator);
   }
   public void sendText(By locator, String text) {
      waitForVisibility(locator);
      element(locator).sendKeys(text);
   }

   public void click(By locator) {
      waitForVisibility(locator);
      element(locator).click();
   }


   @Test
   public void app() throws MalformedURLException {
      DesiredCapabilities caps = new DesiredCapabilities();

      caps.setCapability("platformName", "ANDROID");
      caps.setCapability("appium:platformVersion", "14");
      caps.setCapability("appium:deviceName", "Pixel3a");
      caps.setCapability("appium:app", System.getProperty("user.dire")+"src/test/resources/apks/app-omega-release.apk");
      caps.setCapability("appium:automationName", "UiAutomator2");

      driver = new AndroidDriver(new URL(" http://172.23.128.1:4723/"), caps);

      sendText(usernameTxtBox, "AAAA");
      sendText(passwordTxtBox, "BBBB");
      click(loginBtn);
   }

}