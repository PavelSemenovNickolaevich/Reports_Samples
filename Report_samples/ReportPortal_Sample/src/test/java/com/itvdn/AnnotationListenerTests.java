package com.itvdn;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

@Listeners({ReportPortalTestNGListener.class})
public class AnnotationListenerTests {

//        private static final Logger LOGGER = LogManager.getLogger("FileLogger");
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeClass
    public static void setUpBeforeClass() {
        LOGGER.info("This is executed once before any test runs.");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        LOGGER.info("This is executed once after all tests have been run.");
    }

    @BeforeMethod
    public void setUp() {
        LOGGER.info("This is executed once before every test.");
    }

    @AfterMethod
    public void tearDown() {
        LOGGER.info("This is executed once after every test.");
    }

    @Test
    public void passingTest() {
        LOGGER.info("I'm a simple test that passes!");
    }

    @Test
    public void failingTest() {
        LOGGER.info("I fail! :(");
        fail();
    }

    @Test
    public void failingTestWithException() {
        LOGGER.info("I fail with an unexpected Exception!");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void failingTestWithWrongException() {
        LOGGER.info("I fail, because the wrong exception is thrown!");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void passingTestWithExpectedException() {
        LOGGER.info("I pass, although an exception is thrown!");
        throw new RuntimeException();
    }

    @Test(enabled = false)
    public void ignoredTest() {
        LOGGER.info("I'm ignored :-(");
        fail();
    }

    @Test(timeOut = 1000)
    public void passingTestWithTimeout() {
        LOGGER.info("I pass because my exception doesn't take too long.");
    }

    @Test(timeOut = 1000)
    public void failingTestWithTimeout() throws Exception {
        LOGGER.info("I fail because my exception takes too long.");
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
