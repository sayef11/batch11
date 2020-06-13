package day13;

import Reusable_methods.Reusable_Library;
import Reusable_methods.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class list_boolean_report {

    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {

        driver = Reusable_Library.setDriver();
        reports = new ExtentReports("src//main//java//HTML_report//AutomationReport.html",true);

    }

    @Test
    public void yahoo() throws InterruptedException {

        logger = reports.startTest("Yahoo Verification");

        logger.log(LogStatus.INFO,"Navigating to Yahoo");

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3500);
        logger.log(LogStatus.INFO,"Getting the list");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        System.out.println("link count" + linkCount.size());

        if (linkCount.size() == 12) {
            System.out.println("link count matches and it is" + linkCount.size());
            logger.log(LogStatus.PASS,"link count matches and it is" +linkCount.size());
        } else {
            System.out.println("link count doesn't match and link count is" + linkCount.size());
            logger.log(LogStatus.FAIL,"link count doesn't match and link count is" + linkCount.size());
        }
        Reusable_Library_loggers.click(driver, "//*[@id='header-signin-link']", "SIGN IN",logger);
        Thread.sleep(4000);

        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();

        if (checkboxState == true) {
            System.out.println("checkbox is selected");
            logger.log(LogStatus.PASS,"checkbox is selected" +checkboxState);
        } else {
            System.out.println("checkbox is not selected ");
            logger.log(LogStatus.FAIL," checkbox doesn't match" +checkboxState);
        }
        reports.endTest(logger);
    }

    @AfterSuite
    public void closeDriver() {
        reports.flush();
        //driver.quit();

    }

}//end of java class
