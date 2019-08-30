package com.otus.selenium.lesson7;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestProxy {

    @Test
    public void bmpTest() throws Exception {
        // запуск прокси сервера

        // получение Selenium proxy
        ProxyServer server = new ProxyServer(4444);
        server.start();
        Proxy proxy = server.seleniumProxy();
        proxy.setHttpProxy("localhost:4444");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver = new ChromeDriver(capabilities);
        server.newHar("testlink");
        driver.get("http://localhost/testlink/");

        // получение данных HAR
        Har har = server.getHar();
        System.out.println(har);
        // здесь будет обработка полученных данных

        driver.quit();

    }
}