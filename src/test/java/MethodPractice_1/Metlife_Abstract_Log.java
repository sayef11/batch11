package MethodPractice_1;

import Reusable_methods.Abstract_Class;
import Reusable_methods.Reusable_Library;
import Reusable_methods.Reusable_Library_loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Metlife_Abstract_Log extends Abstract_Class {

    @Test(priority = 1)
    public void MetLifeVerifyTitle() throws IOException, InterruptedException {
        Reusable_Library_loggers.setDriver();
        Thread.sleep(3000);
        Reusable_Library_loggers.verifyTitle(driver, "Insurance and Employee Benefits | MetLife", logger);
        Thread.sleep(3000);

    }// verifying title test ends

    @Test(priority = 2)
    public void PPO_Verify_Test() throws InterruptedException {

        ArrayList<String> Zipcode = new ArrayList<>();//declare arraylist for zipCode
        Zipcode.add("11230");
        Zipcode.add("11226");
        Zipcode.add("11241");

        ArrayList<String> dentalProgram = new ArrayList<>();//declare arraylist for dentalProgram
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> referralCode = new ArrayList<>();//declare arrayList for referralcode
        referralCode.add("3256");
        referralCode.add("8974");
        referralCode.add("9420");

        driver.navigate().to("https://www.metlife.com/");//navigate to MetLife.com
        Thread.sleep(3000);//system will wait 3 sec before move on to next step

        Reusable_Library_loggers.mouseHover(driver, "//*[contains(text(),'SOLUTIONS')]", "Hovering Solutions Tab", logger);
        Thread.sleep(3000);

        Reusable_Library_loggers.mouseClick(driver, "//*[contains(text(),'MetLife TakeAlong Dental')]", "Clicking The Tab", logger);
        Thread.sleep(3000);

        Reusable_Library_loggers.verifyTitle(driver, "MetLife TakeAlong Dental | MetLife", logger);
        Thread.sleep(3000);

        for (int i = 0; i < dentalProgram.size(); ++i) {

            Reusable_Library_loggers.mouseClick(driver, "//*[contains(text(),'Enroll Now')]", "Enroll tab click", logger);
            Thread.sleep(3000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());//declaring array list for handling tabs
            driver.switchTo().window(tabs.get(1));//switching the tabs to second tab
            Thread.sleep(3000);


            Reusable_Library_loggers.userKeys(driver,"//*[@id='txtZipCode']",Zipcode.get(i),"Passing zipcodes",logger);
            Thread.sleep(3000);
            Reusable_Library_loggers.mouseClick(driver, "//*[@id = 'txtZipCodetxt']", "Entering Zipcodes", logger);
            Thread.sleep(3000);

            Reusable_Library_loggers.mouseClick(driver, "//*[@class = '" + dentalProgram.get(i) + "']", "Checking dental programs", logger);
            Thread.sleep(3000);


            Reusable_Library_loggers.mouseClick(driver, "//*[@id ='topenrolltab']", "Program Option", logger);
            Thread.sleep(3000);

            Reusable_Library_loggers.userKeys(driver, "//*[@id = 'txtBxPromocode']", referralCode.get(i), "Passing refferal codes", logger);
            Thread.sleep(3000);

            Reusable_Library_loggers.mouseClick(driver, "//*[@name='btnEnroll']", "clicking the go button", logger);
            Thread.sleep(3000);

            Reusable_Library_loggers.captureText(driver, "//*[@id ='lblRefCodeError']", "capturing the error text", logger);
            Thread.sleep(3000);

            Reusable_Library_loggers.mouseClick(driver, "//*[@id='withoutrefcode']", "going without refferal code", logger);
            Thread.sleep(3000);

            String capture = Reusable_Library_loggers.captureText(driver, "//*[@class='col-sm-8']", "getting the exact name", logger);
            Thread.sleep(3000);
            if (capture.contains(dentalProgram.get(i))) {
                System.out.println("The result matches");
                logger.log(LogStatus.PASS, "Name matches");

            } else {
                System.out.println("The result did not match " + capture);
                logger.log(LogStatus.FAIL, "The result did not match " + capture);
            }

            driver.close();//closing the tab/current page
            driver.switchTo().window(tabs.get(0));//switching back to first page
            Thread.sleep(3000);


        }//loop ends


    }//test 2 ends


}//class ends












