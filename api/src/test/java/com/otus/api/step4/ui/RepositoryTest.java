package com.otus.api.step4.ui;

import com.otus.api.step4.AppConfig;
import com.otus.api.step4.model.Repositories;
import com.otus.api.step4.service.RepoService;
import com.otus.api.step4.service.UserService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class RepositoryTest {
    @Value("${url.login}")
    private String url;

    @Value("${url.cloud}")
    private String cloudUrl;

    @Autowired
    private UserService user;
    @Autowired
    private RepoService repo;


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
        driver.get(url);
        user.getUiCookies().forEach(c -> driver.manage().addCookie(c));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.manage().getCookies());
        driver.get(url);
    }

    @Test
    public void iCanGetRepositoryList() {
        Repositories reps = repo.withCookies(user.getCookies(userLogin, userPass))
                .getRepositories("last_updated", 1, userName);
        List<WebElement> items = driver.findElements(By.cssSelector("div[data-testid='repositoryList'] a"));
        assertThat(items.size(), equalTo(reps.getCount()));
    }

    @Test
    public void iCanCreateRepository() {
        driver.findElement(By.cssSelector("button[data-testid='createRepoBtn']")).click();

        String repo = UUID.randomUUID().toString();
        String repoName = UUID.randomUUID().toString().subSequence(0, 10).toString();
        driver.findElement(By.cssSelector("input[data-testid='repoNameField']")).sendKeys(repoName);
        driver.findElement(By.cssSelector("input[data-testid='repoDescriptionField']")).sendKeys(repo);
        driver.findElement(By.cssSelector("button[data-testid='submit']")).click();

        String title = driver.findElement(By.cssSelector("div[data-testid='repoOverviewTitle']")).getText();

        assertThat(title, containsStringIgnoringCase(userName));
        assertThat(title, containsStringIgnoringCase(repoName));

    }

    @Test
    public void iCanDeleteRepository() {
        driver.get(cloudUrl + "/repository/list");

        String repoUrl = driver.findElement(By.cssSelector("a[data-testid='repositoryRowLink']")).getAttribute("href");

        driver.get(repoUrl + "/settings");
        driver.findElement(By.cssSelector("button[data-testid='deleteRepo']")).click();

        String repoName = substractRepoName(repoUrl);

        driver.findElement(By.cssSelector("input[data-testid='imageNameField']")).sendKeys(repoName);
        driver.findElement(By.cssSelector("button[data-testid='confirm']")).click();


    }

    @Test
    public void iCanAddWebHookToRepositoryRepository() {
        driver.get(cloudUrl + "/repository/list");

        String repoUrl = driver.findElement(By.cssSelector("a[data-testid='repositoryRowLink']")).getAttribute("href");

        driver.get(repoUrl + "/webhooks");

        String webhookName = "WH_" + UUID.randomUUID().toString().subSequence(0, 4);
        driver.findElement(By.cssSelector("input[data-testid='webhookName']")).sendKeys(webhookName);
        driver.findElement(By.cssSelector("input[data-testid='webhookUrl']")).sendKeys("https://otus.ru/");
        driver.findElement(By.cssSelector("button[data-testid='webhookSubmit']")).click();

        driver.navigate().refresh();
        String itemText = driver.findElement(By.cssSelector("div[data-testid='webhookItem']")).getText();

        assertThat(itemText, containsStringIgnoringCase(webhookName));
        assertThat(itemText, containsStringIgnoringCase("https://otus.ru/"));
    }

    private String substractRepoName(String repoUrl) {
        String[] repoUrlParts = repoUrl.split("/");
        return repoUrlParts[repoUrlParts.length - 1];
    }

    private void logIn() {
        driver.get(url);
        driver.findElement(By.cssSelector("#log_in")).click();
        driver.findElement(By.cssSelector("#nw_username")).sendKeys(userLogin);
        driver.findElement(By.cssSelector("#nw_password")).sendKeys(userPass);
        driver.findElement(By.cssSelector("#nw_submit")).click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
