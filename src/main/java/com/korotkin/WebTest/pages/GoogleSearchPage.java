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
package com.korotkin.WebTest.pages;

import com.korotkin.WebTest.exception.NoQueryException;
import com.korotkin.WebTest.utils.UrlRepository;
import com.korotkin.WebTest.utils.WebBrowser;
import com.korotkin.WebTest.utils.WebPage;
import com.korotkin.WebTest.utils.UrlRepository.Url;

public class GoogleSearchPage extends WebPage {

	public static final String CMD_SEARCH = "search";
	public static final String TXT_QUERY = "query";

	public boolean loggedin = true;

	public GoogleSearchPage(WebBrowser browser) {
		super(browser, UrlRepository.getUrl(Url.GOOGLE));
	}

	public void setSearchQuery(String query) {
		getElement(TXT_QUERY).sendKeys(query);
	}

	public GoogleSearchResultsPage clickSearch() {
		click(CMD_SEARCH);
		return new GoogleSearchResultsPage(browser);
	}

	public GoogleSearchResultsPage GoogleSearchResults(String query) throws NoQueryException {

		if (query.isEmpty())
			throw new NoQueryException();

		setSearchQuery(query);
		return clickSearch();
	}

}
