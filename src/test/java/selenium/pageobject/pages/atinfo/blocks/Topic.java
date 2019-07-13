package selenium.pageobject.pages.atinfo.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import selenium.pageobject.pages.atinfo.Page;
import selenium.pageobject.pages.atinfo.TopicPage;

public class Topic extends Page {

    @FindBy(css = "a.title")
    private WebElement title;

    @FindBy(css = "a.badge.new-topic")
    private WebElement newTopicBadge;

    public Topic(WebElement row, WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isNew() {
        return newTopicBadge != null && newTopicBadge.isDisplayed();
    }

    public TopicPage openTopic() {
        title.click();
        return new TopicPage(driver);
    }


}
