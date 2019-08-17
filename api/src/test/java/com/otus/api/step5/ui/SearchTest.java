package com.otus.api.step5.ui;

import com.otus.api.step5.AppConfig;
import com.otus.api.step5.service.UserService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this);

    private MockServerClient mockServerClient;

    @Before
    public void setUpBasePath() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:" + mockServerRule.getPort());
        proxy.setSslProxy("localhost:" + mockServerRule.getPort());

        ChromeOptions optios = new ChromeOptions();
        optios.setProxy(proxy);

        driver = new ChromeDriver(optios);
        driver.get(url);
        user.getUiCookies().forEach(c -> driver.manage().addCookie(c));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);

        mockServerClient = mockServerRule.getClient();

        mockServerClient
                .when(req)
                .respond(resp);
    }

    @Test
    public void asAuthorizedUerICanSearchImages() {
        driver.findElement(By.cssSelector("input[data-testid='autocompleteInput']")).sendKeys("testlink", Keys.ENTER);
        driver.findElement(By.cssSelector("input[data-testid='autocompleteInput']")).sendKeys("log", Keys.ENTER);
        String currentUrl = driver.getCurrentUrl();
        mockServerClient.retrieveLogMessages(req);
        assertThat(currentUrl, containsStringIgnoringCase("q=log&type=image"));
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


    private final String body = "" +
            "{\"count\": 9,\n" +
            "\"next\": \"https://store.docker.com/api/content/v1/products/search/?image_filter=store,official&q=log&page=2&page_size=4\",\n" +
            "\"page\": 1,\n" +
            "\"page_size\": 4,\n" +
            "\"previous\": \"\",\n" +
            "\"summaries\":[]}";
    private final HttpResponse resp = new HttpResponse().withBody(body);
    private final HttpRequest req = new HttpRequest().withQueryStringParameter("q", "log").withQueryStringParameter("type", "image");
}
