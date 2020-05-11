package com.itvdn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XmlListenerTests {
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeMethod
    @Parameters({"test-name"})
    public void beforeMethod(String testName) {
        long id = Thread.currentThread().getId();
        LOGGER.info("Before test " + testName + ". Thread id is: " + id);
    }

    @Test
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        LOGGER.info("Simple test-method One. Thread id is: " + id);
    }

    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        LOGGER.info("Simple test-method Two. Thread id is: " + id);
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        LOGGER.info("After test-method. Thread id is: " + id);
    }
}
