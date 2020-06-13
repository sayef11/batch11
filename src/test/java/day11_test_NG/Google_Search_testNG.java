package day11_test_NG;

import Reusable_methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Google_Search_testNG {
    //local driver must be declare outside so that we can call it on all annotation method
    WebDriver driver;
    ArrayList<String> cars = new ArrayList();

    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
        //driver.navigate().to("https://www.google.com");
        cars.add("BMW");
        cars.add("Toyota");


    }//end of before method

    @AfterMethod
    public void quitDriver(){
        driver.quit();

    } //after method ends

    @Test
    public void GoogleSearch() throws InterruptedException {
        for (int i=0; i<cars.size();++i) {
            driver.navigate().to("https://www.google.com");
            //enter keyword
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "Search Field");
            Thread.sleep(2000);
            Reusable_Library.submit(driver, "//*[@name='btnK'] ", "Google Search Button");
            Thread.sleep(2000);

            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");

            String[] arraySearch = searchResult.split(" ");
            System.out.println("The result is " + arraySearch[1]);
            System.out.println("The result is " + arraySearch[1]);
        }

    }//end of google test





}//end of java class
