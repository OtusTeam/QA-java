package selenium.pageobject.tests.yandex;

import org.junit.Assert;
import org.junit.Test;
import selenium.pageobject.pages.yandex.YaResultsPage;
import selenium.pageobject.pages.yandex.YaruPage;
import selenium.pageobject.tests.BaseTest;

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
