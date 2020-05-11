package com.itvdn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class MavenListenerTests {

    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.trace("Before Suite method");
    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.debug("Before Test method");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Before Class method");
    }

    @BeforeGroups(groups = {"include-group"})
    public void beforeGroups() {
        LOGGER.warn("Before Groups method");
    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.error("Before Method method");
    }

    @Test(groups = {"include-group"})
    public void testMethodOne() {
        LOGGER.fatal("Test method one belonging to include group.");
    }

    @Test(groups = {"include-group"})
    public void testMethodTwo() {
        LOGGER.fatal("Test method two belonging to include group.");
    }

    @Test(groups = {"include-group", "exclude-group"})
    public void testMethodThree() {
        LOGGER.fatal("Test method three belonging to exclude/include groups.");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.error("After Method method");
    }

    @AfterGroups(groups = {"include-group"})
    public void afterGroups() {
        LOGGER.warn("After Groups method");
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("After Class method");
    }

    @AfterTest
    public void afterTest() {
        LOGGER.debug("After Test method");
    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.trace("After Suite method");
    }

}