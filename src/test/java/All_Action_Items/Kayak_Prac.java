package All_Action_Items;


import Reusable_methods.Reusable_Library;
import Reusable_methods.Reusable_Library_loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Prac {

    //making web driver local
    WebDriver driver;
    //creating read file from excel
    Workbook readableFile;
    //read sheet from excel
    Sheet readableSheet;
    //write file
    WritableWorkbook writableFile;
    //write sheet
    WritableSheet writableSheet;
    ExtentTest logger;
    ExtentReports reports;

    //under before suite defining driver and read write files
    @BeforeSuite

    public void defineDriver() throws IOException, BiffException, InterruptedException {


        readableFile = Workbook.getWorkbook(new File("src//main//resources//Kayak_Information_AI.xls"));

        readableSheet = readableFile.getSheet(0);

        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_Information_AI_results.xls"), readableFile);

        writableSheet = writableFile.getSheet(0);

        driver = Reusable_Library.setDriver();

        Thread.sleep(1000);

        reports = new ExtentReports("src//main//java//HTML_report//KayakReport.html",true);


    } //before suite ends

    // under test passing for loop and all other locators
    @Test

    public void Kayak_Test() throws InterruptedException, WriteException {

        // to get the rows from excel
        int rows = writableSheet.getRows();

        logger = reports.startTest("kayak test");

        for (int i = 1; i < rows; ++i) {

            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(3000);

            //clicking search button
            Reusable_Library_loggers.mouseClick(driver, "//*[@class='_ieU _ia1']", "Choose Searching Bar",logger);
            Thread.sleep(3000);

            // airport name passing info
            String airportName = writableSheet.getCell(0, i).getContents();
            Reusable_Library_loggers.userKeys(driver, "//*[@name='pickup']", airportName, "Passing airport name",logger);
            Thread.sleep(3000);

            // clicking on specific airport info
            Reusable_Library_loggers.mouseClick(driver, "//*[@class='smarty-icon-wrapper']", "Airport Name",logger);

            //calendar tab end date choose
            Reusable_Library_loggers.mouseClick(driver, "//*[contains(@id,'dateRangeInput-display-end')]", "calendarEndDate",logger);
            Thread.sleep(2500);

            //passing end date on calendar
            String endDate = writableSheet.getCell(3, i).getContents();
            Reusable_Library_loggers.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", endDate, "End Date",logger);
            Thread.sleep(2500);

            //clicking outside somewhere on web page
            Reusable_Library_loggers.click(driver, "//*[@class='title-section']", "click outside",logger);
            Thread.sleep(2500);

            //clicking on end time box
            Reusable_Library_loggers.click(driver, "//*[contains(@id,'dateRangeInput-end-time-select-display-status')]", "calendarEndDate",logger);
            Thread.sleep(2700);

            //passing end time info
            String endTime = writableSheet.getCell(4, i).getContents();
            Reusable_Library_loggers.mouseClick(driver, "//*[contains(@id,'dateRangeInput-end-time-select') and @data-title='" + endTime + "']", "Time",logger);
            Thread.sleep(2500);

            //clicking info of start date
            Reusable_Library_loggers.mouseClick(driver, "//*[contains(@id,'dateRangeInput-display-start')]", "start time",logger);
            Thread.sleep(3000);

            //passing start date info
            String startDate = writableSheet.getCell(1, i).getContents();
            Reusable_Library_loggers.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", startDate, "date start",logger);
            Thread.sleep(2500);

            //clicking outside page
            Reusable_Library_loggers.click(driver, "//*[@class='title-section']", "click",logger);
            Thread.sleep(2500);

            //clicking on start time
            Reusable_Library_loggers.mouseClick(driver, "//*[contains(@id,'dateRangeInput-start-time-select')]", "start time",logger);
            Thread.sleep(3000);


            //passing start time info
            String startTime = writableSheet.getCell(2, i).getContents();
            Reusable_Library_loggers.mouseClick(driver, "//*[='"+startTime+"']", "StartTime",logger);
            Thread.sleep(2700);

            //submit click
            Reusable_Library_loggers.click(driver, "//*[contains(@id,'submit-wrapper')]", "clicking on submit",logger);
            Thread.sleep(2500);

            //checking cars size checkbox
            String chooseCheckBox = writableSheet.getCell(5, i).getContents();
            System.out.println("printing out " + chooseCheckBox);
            Reusable_Library_loggers.click(driver, "//*[@id='cars-topFilter-"+chooseCheckBox+"-checkbox_icon']", "checking cars size",logger);
            Thread.sleep(3000);

            //view deal box
            Reusable_Library_loggers.clickByIndex(driver, "//*[contains(text(),'View Deal')]", 1, "view deal",logger);
            Thread.sleep(2500);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//declaring array list for handling tabs
            driver.switchTo().window(tabs.get(1));//switching the tabs to second tab
            Thread.sleep(2500);

            //capturing the pick up & drop off info
            String vehicleDetails = Reusable_Library_loggers.captureText(driver, "//*[contains(@class, 'summarySection') or @class ='res_summary']", "Pick & drop Information",logger);
            System.out.println(vehicleDetails);
            Label Text = new Label(6, i, vehicleDetails); //6 is the column and 1 is the row
            System.out.println("capturing" + Text);
            writableSheet.addCell(Text);

            driver.close();//closing the tab/current page
            driver.switchTo().window(tabs.get(0));//switching back to first page
            Thread.sleep(3000);

            driver.manage().deleteAllCookies();

        }//for loop ends

        reports.endTest(logger);
    }

    @AfterSuite
    public void closeDriver() throws InterruptedException, IOException, WriteException {

        Thread.sleep(4000);
        writableFile.write();
        writableFile.close();
        readableFile.close();
        reports.flush();


    }//After suite ends


}
