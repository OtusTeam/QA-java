package com.otus.api.step4.ui;

import com.otus.api.step4.AppConfig;
import com.otus.api.step4.service.UserService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SearchTest {

    @Value("${url.hub}")
    private String url;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;

    @Value("${user.nickname}")
    private String userName;

    @Autowired
    private UserService user;


    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @Before
    public void setUpBasePath() {
        driver = new ChromeDriver();
        driver.get(url);
        user.getUiCookies().forEach(c -> driver.manage().addCookie(c));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.manage().getCookies());
        driver.get(url);
    }

    @Test
    public void asAuthorizedUerICanSearchImages() {
        driver.findElement(By.cssSelector("input[data-testid='autocompleteInput']")).sendKeys("testlink", Keys.ENTER);
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl, containsStringIgnoringCase("q=testlink&type=image"));
    }

    @Test
    public void asAuthorizedUserICanSearchPlugins() {
        driver.findElement(By.cssSelector("input[data-testid='autocompleteInput']")).sendKeys("log", Keys.ENTER);
        driver.findElement(By.cssSelector("div[data-testid='tabs'] button:last-child")).click();
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl, containsStringIgnoringCase("q=log&type=plugin"));
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
