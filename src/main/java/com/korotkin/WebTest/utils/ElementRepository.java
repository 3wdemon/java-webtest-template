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

import com.korotkin.WebTest.pages.GoogleSearchPage;
import com.korotkin.WebTest.pages.GoogleSearchResultsPage;
import com.korotkin.WebTest.pages.KorotkinPage;

public class ElementRepository {

	/**
	 * Get element
	 * @param c
	 * @return
	 */
	public static Hashtable<String, String> getElements(Class<?> c)
	{
		// Can be used from DB 
		// Ex. "SELECT id,path from class = c"
		
		Hashtable<String, String> retVal = new Hashtable<String, String>();

		if (c == GoogleSearchPage.class)
		{
			retVal.put(GoogleSearchPage.CMD_SEARCH, "[name=btnK]");
			retVal.put(GoogleSearchPage.TXT_QUERY, "input[name=q]");
		}
		if ( c == GoogleSearchResultsPage.class)
		{
			retVal.put(GoogleSearchResultsPage.FIRST_RESULT_LINK, "h3:first-child > a");			
		}
		if (c == KorotkinPage.class)
		{
			retVal.put(KorotkinPage.CONTACT_US, "a[href*='mail']");
		}

		return retVal;
	}

}
