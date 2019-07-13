package selenium.pageobject.tests.atinfo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.pageobject.services.AtInfoWebApp;

public class AtInfoDsl extends BaseTest {
    private AtInfoWebApp app;

    @Before
    public void setUpTests() {
        app = new AtInfoWebApp(driver).open();
    }

    @Test
    public void loginButtonShouldBePresent() {
        app.getVerifier().verifyLoginButtonDisplayed();
    }

    @Test
    public void loginButtonOpensLoginForm() {
        app
                .openLoginMenu()
                .getVerifier().verifyHeaderTextIs("Войти");
    }

    @Test
    public void iCanOpenTopicPage() {
        String titleInList = app.getTopics().get(1).getTitle();

        app
                .getTopics()
                .get(1)
                .openTopic()
                .getVerifier().verifyTitleIs(titleInList);
    }

    @Test
    public void searchButtonOpensInput() {
        String searchTerm = "test";
        app
                .openSerachInput()
                .search(searchTerm)
                .getVerifier().verifySearchInputContainsText(searchTerm);
    }

}
