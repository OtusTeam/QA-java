package com.otus.selenium.pageobject.tests.yandex;

import org.junit.Assert;
import org.junit.Test;
import com.otus.selenium.pageobject.pages.yandex.YaResultsPage;
import com.otus.selenium.pageobject.pages.yandex.YaruPage;

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
