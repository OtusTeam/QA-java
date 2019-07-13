package selenium.pageobject.pages.atinfo.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pageobject.pages.atinfo.Page;
import selenium.pageobject.pages.atinfo.SearchResultsPage;

import static junit.framework.TestCase.assertTrue;

public class SearchBlock extends Page {
    private final Verifier verifier = new Verifier();
    private final static By searchTerm = By.cssSelector("input.search.search-query");
    private final static By searchFilters = By.cssSelector(".search-advanced-filters");


    public SearchBlock(WebDriver driver) {
        super(driver);
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public SearchResultsPage search(String test) {
        driver.findElement(searchTerm).sendKeys(test, Keys.ENTER);
        return new SearchResultsPage(driver);

    }


    public class Verifier {
        public void verifySearchInputIsPresent() {
            WebElement search = driver.findElement(searchTerm);
            assertTrue(search.isDisplayed());
            assertTrue(search.isEnabled());
        }
    }

}
