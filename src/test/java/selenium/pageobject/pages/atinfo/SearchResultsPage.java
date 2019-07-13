package selenium.pageobject.pages.atinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SearchResultsPage extends Page {
    private final Verifier verifier = new Verifier();

    private final static By searchQuery = By.cssSelector("input.search.search-query");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public Verifier getVerifier() {
        return verifier;
    }


    public class Verifier {
        public void verifySearchInputContainsText(String text) {
            WebElement element = driver.findElement(searchQuery);

            assertThat(element.getAttribute("value"), equalTo(text));
        }
    }
}
