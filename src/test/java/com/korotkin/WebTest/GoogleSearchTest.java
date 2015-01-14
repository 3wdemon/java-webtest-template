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
package com.korotkin.WebTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.korotkin.WebTest.exception.NoQueryException;
import com.korotkin.WebTest.pages.GoogleSearchPage;
import com.korotkin.WebTest.pages.GoogleSearchResultsPage;
import com.korotkin.WebTest.pages.KorotkinPage;
import com.korotkin.WebTest.utils.WebBrowser;

/**
 * Start Test cases
 * @author yehuda
 *
 */
public class GoogleSearchTest {
	
	private WebBrowser browser;
	
	@BeforeClass
	public void BeforeClass(){
		browser = WebBrowser.getInstance();
	}
		
	@Test
	public void GoogleSearch_Test() throws NoQueryException{
		
		GoogleSearchPage wp = new GoogleSearchPage(browser);
		wp.setSearchQuery("Korotkin co.il");
		GoogleSearchResultsPage results = wp.clickSearch(); 		
		Assert.assertNotNull(results);
		
		KorotkinPage kpage= results.clickFirstResult();
		Assert.assertEquals(kpage.getContactusHref(),"mailto:info@korotkin.co.il");
	}
	
	@Test(expectedExceptions = NoQueryException.class)
	public void EmptySearch_Test() throws NoQueryException{
		GoogleSearchPage wp = new GoogleSearchPage(browser);
		wp.setSearchQuery("");		
	}	
	
}
