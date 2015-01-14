/****************************************************
 * The MIT License (MIT) | Copyright (c) 2015 Korotkin <info@korotkin.co.il>
 * 
 *  
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.korotkin.WebTest.utils;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPage {

	protected WebBrowser browser;
	protected Hashtable<String, String> elements;

	public WebPage(WebBrowser browser, String url) {
		elements = ElementRepository.getElements(this.getClass());
		this.browser = browser;
		this.browser.getDriver().get(url);
	}

	public WebPage(WebBrowser browser) {
		elements = ElementRepository.getElements(this.getClass());
		this.browser = browser;
	}

	public String getCssPath(String element) {
		if (!elements.containsKey(element))
			throw new RuntimeException("The element (" + element
					+ ") not exists");

		return elements.get(element);
	}

	public void click(String element) {
		
		//  See: http://stackoverflow.com/questions/15294630/selenium-firefox-command-click-doesnt-work-with-a-found-element
		WebElement we = browser.getDriver().findElement(By.cssSelector(getCssPath(element)));
		JavascriptExecutor executor = (JavascriptExecutor) browser.getDriver();
		executor.executeScript("arguments[0].click();", we);

		// Original way to click
		// browser.getDriver().findElement(By.cssSelector(getCssPath(element))).click();
		
		// Click via Jquery
		/*
		((JavascriptExecutor) browser.getDriver()).executeScript("$(\""
				+ getCssPath(element) + "\").click();");
		*/
	}

	public WebElement getElement(String element) {
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(getCssPath(element))));

		return browser.getDriver().findElement(
				By.cssSelector(getCssPath(element)));
	}

}
