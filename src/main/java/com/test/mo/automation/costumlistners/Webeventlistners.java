package com.test.mo.automation.costumlistners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class Webeventlistners extends AbstractWebDriverEventListener implements WebDriverEventListener {

	public static final Logger log = Logger.getLogger(Webeventlistners.class.getName());

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log("Before navigating to: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		log("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		log("Element value changed to: " + element.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Trying to click on: " + element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {

		log("Clicked on: " + element.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		log("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		log("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log("Navigated forward to next page");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		log("Exception occured: " + error);
		Reporter.log("Exception occured:", false);
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// log("Trying to find Element By : " + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	@Override
	public void beforeScript(String script, WebDriver driver) {

		System.out.println("Just before beforeScript " + driver);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println("Just after afterScript " + driver);

	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);

		log.getAppender(data);

	}
}
