package com.sqa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sqa.drivers.DriverSingleton;
import com.sqa.utils.TestCases;
import com.sqa.utils.Utils;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    static WebDriver driver;

    static ExtentTest extentTest;
    static ExtentReports reports = new ExtentReports("target/extent-report.html");


    @Before
    public static void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        TestCases[] test = TestCases.values();
        extentTest = reports.startTest(test[Utils.testCount].getTestCaseName());
        Utils.testCount++;

    }

    // automation screenshot
    @AfterStep
    public void getResultStatus (Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName())
                    .replace(" ","_");
            extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
                    +extentTest.addScreenCapture(screenshotPath));
        }
    }

    @After
    public void endTestCase(){
        reports.endTest(extentTest);
        reports.flush();
    }


    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}
