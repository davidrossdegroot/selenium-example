package qa.webdriver.util;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage  {

	public static final String searchFieldName = "search_query";
	public static final String searchButtonName = "search_submit";
	public static final String suggestIons = "div.nav-search-text div#search-suggestions ul li";

	@FindBy(name = searchFieldName ) public WebElement searchField;
	@FindBy(name = searchButtonName ) public WebElement searchButton;

	/**
	 * Method: isLoaded()
	 * Overidden method from the LoadableComponent class.
	 * This method must contain an Assert on visibility of an element in order
	 *  to trigger another call of load() if element is not found.
	 * @return	void
	 * @throws	null
	 */
	protected void isLoaded() throws Error {    	
		boolean loaded = false;
		if ( !(searchField == null ) ) {
			try {
				if ( searchField.isDisplayed() ) {
					loaded = true;
				}
			} catch ( ElementNotVisibleException e ) {
			}
		}
		Assert.assertTrue( "Etsy search field is not yet displayed.", loaded );
	}

}
