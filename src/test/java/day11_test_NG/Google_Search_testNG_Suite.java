package day11_test_NG;

import Reusable_methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Google_Search_testNG_Suite {
    //local driver must be declare outside so that we can call it on all annotation method
    WebDriver driver;


    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
        driver.navigate().to("https://www.google.com");

    }//end of before method

    @AfterSuite
    public void quitDriver() {
        driver.quit();

    } //after method ends

    @Test(priority = 1)
    public void GoogleSearch() throws InterruptedException {
        //enter keyword
        Reusable_Library.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");

        Reusable_Library.submit(driver, "//*[@name='btnK'] ", "Google Search Button");
        Thread.sleep(2000);


    }//1 ends


    @Test(priority = 2)
    public void Capture() {

        String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");

        String[] arraySearch = searchResult.split(" ");
        System.out.println("The result is " + arraySearch[1]);


    }//2 ends


}//end of java class
