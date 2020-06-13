package Reusable_methods;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.read.biff.BiffException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

//mmmoy
    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException, BiffException {
        driver = Reusable_Library_loggers.setDriver();
        reports = new ExtentReports("src//main//java//HTML_report//TestReport.html", true);
    }

    @BeforeMethod
    public void getMethodName(Method methodName) {
        logger = reports.startTest(methodName.getName());

    }

    @AfterMethod
    public void endTest() {

        reports.endTest(logger);

    }

    @AfterSuite
    public void closeInfo() {

        driver.quit();
        reports.flush();

    }

}
