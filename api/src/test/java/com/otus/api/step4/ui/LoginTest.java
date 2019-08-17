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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LoginTest {
    @Value("${url.login}")
    private String url;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;

    @Value("${user.nickname}")
    private String userName;


    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @Before
    public void setUpBasePath() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Autowired
    private UserService user;


    @Test
    public void iCanLogin() {
        driver.get(url);
        driver.findElement(By.cssSelector("#log_in")).click();
        driver.findElement(By.cssSelector("#nw_username")).sendKeys(userLogin);
        driver.findElement(By.cssSelector("#nw_password")).sendKeys(userPass);
        driver.findElement(By.cssSelector("#nw_submit")).click();

        String text = driver.findElement(By.cssSelector("#loggedInMenu")).getText();
        user.saveCookies(driver.manage().getCookies());
        assertThat(text, equalTo(userName));
    }

    @Test
    public void wrongPass() {
        driver.get(url);
        driver.findElement(By.cssSelector("#log_in")).click();
        driver.findElement(By.cssSelector("#nw_username")).sendKeys(userLogin);
        driver.findElement(By.cssSelector("#nw_password")).sendKeys(userPass + "fail");
        driver.findElement(By.cssSelector("#nw_submit")).click();

        String text = driver.findElement(By.cssSelector("div[class^='styles__error__']")).getText();
        assertThat(text, equalTo("Incorrect authentication credentials."));
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
