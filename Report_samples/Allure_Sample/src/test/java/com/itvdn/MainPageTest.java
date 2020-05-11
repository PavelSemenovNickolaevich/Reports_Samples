package com.itvdn;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import itvdn.DriverWrapper;
import itvdn.MainPage;
import itvdn.SearchPage;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageTest {

    final DriverWrapper driverWrapper = new DriverWrapper();

    @Before
    public void setUp() {
        driverWrapper.init();
    }

    @After
    public void tearDown() {
        driverWrapper.close();
    }

    @Attachment
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driverWrapper.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @DisplayName("Human-readable test name")
    @Description("Some detailed test description")
    public void search() {
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.search("QA");

        // Способ прикрепить приложение №1
        Allure.addAttachment("My attachment", "yeah, I am an Attachment!");

        // Способ прикрепить приложение №2
        takeScreenshot();

        SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
        List<WebElement> results = searchPage.getResults();
        Assert.assertEquals(10, results.size());
    }

    @Test
    public void simpleTestFailure() {
        assertThat(2, is(3));
    }

    @Test
    @Ignore
    @Description("I am ignored(")
    public void simpleTestIgnore() {
    }
}