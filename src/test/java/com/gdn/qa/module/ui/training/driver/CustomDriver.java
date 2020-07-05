package com.gdn.qa.module.ui.training.driver;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class CustomDriver implements DriverSource {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @lombok.SneakyThrows
    @Override
    public WebDriver newDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://argo12.gosoft.web.id:4444/wd/hub").toURL(),
                capabilities
        );
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
