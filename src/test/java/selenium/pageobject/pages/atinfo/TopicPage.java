package selenium.pageobject.pages.atinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopicPage extends Page {
    private final WebDriver driver;
    private final Verifier verifier = new Verifier();

    private final static By title = By.cssSelector("a.fancy-title");

    public TopicPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getTopicTitle() {
        return driver.findElement(title);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public class Verifier {
        public void verifyTitleIs(String titleToBe) {
            assertThat(getTitle(), equalTo(titleToBe));
        }
    }

}
