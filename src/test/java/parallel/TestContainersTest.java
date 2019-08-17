package parallel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.output.OutputFrame;

import java.io.File;

public class TestContainersTest {
    protected WebDriver driver;

    @Rule
    public BrowserWebDriverContainer container = new BrowserWebDriverContainer()
            .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_FAILING, new File("./target/"))
            .withCapabilities(new ChromeOptions());

    @Before
    public void setUp()   {
        driver = container.getWebDriver();
        container.followOutput(frame -> System.out.println(((OutputFrame)frame).getUtf8String()));
    }

    @After
    public void tearDown() {
        String output = container.getLogs(OutputFrame.OutputType.STDOUT);
        String error = container.getLogs(OutputFrame.OutputType.STDERR);

        System.out.println(output);
        System.err.println(error);
    }
}
