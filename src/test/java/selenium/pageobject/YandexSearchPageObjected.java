package selenium.pageobject;

import org.junit.Assert;
import org.junit.Test;
import selenium.pageobject.pages.YaResultsPage;
import selenium.pageobject.pages.YaruPage;

public class YandexSearchPageObjected extends BaseTest {

    @Test
    public void search() {

        YaruPage yarupage = new YaruPage(getDriver()).enterQuery("Otus");
        YaResultsPage yaresultspage = yarupage.clickSearch();

        Assert.assertEquals(
                "OTUS - Онлайн-образование – Профессиональные курсы",
                yaresultspage.getFirstResultTitle()
        );
    }

}
