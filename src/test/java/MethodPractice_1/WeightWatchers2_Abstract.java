        //Creating package for the class
package MethodPractice_1;

import Reusable_methods.Abstract_Class;
import Reusable_methods.Reusable_Library_loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

        //Creating main parent class

        public class WeightWatchers2_Abstract extends Abstract_Class {

                //Creating main method

             @Test
                     public void verifyTitle() throws IOException, InterruptedException {

                 Reusable_Library_loggers.setDriver();
                 Thread.sleep(3000);
                // Going to the website
                driver.navigate().to("https://www.weightwatchers.com");
                // 2sec hold
                Thread.sleep(3000);
                // Taking the actual title from the website

                 Reusable_Library_loggers.verifyTitle(driver,"Weight Watchers: Weight Loss & Wellness Help",logger);
                 Thread.sleep(3000);

                //To test 3 different zipcode, creating an array for size 3

                ArrayList<String>Zipcode = new ArrayList<>();
                Zipcode.add("11219");
                Zipcode.add("11230");
                Zipcode.add("11357");

                //For loop starts here
                for (int i = 0; i<Zipcode.size(); ++i) {


                    //This will take us to find a workshop or location link
                    Reusable_Library_loggers.mouseClick(driver,"//*[contains(text(),'Find a Workshop']","finding workshop",logger);
                    Thread.sleep(3000);
                    //this will search in the box where zipcodes will be provided
                   Reusable_Library_loggers.userKeys(driver,"//*[@ id='meetingSearch']",Zipcode.get(i),"passing zipcodes",logger);
                    //Hold for 3sec
                    Thread.sleep(3000);
                    //This will click the searchbar to find zipcodes
                    Reusable_Library_loggers.submit(driver,"//*[@ class='btn spice-translated']","submitting",logger);
                    //Hold for 3sec
                    Thread.sleep(3000);

                    //Creating statements where we will call every zipcode one by one
                    if (i == 0) {
                        //This will get number 2 location link from the page for the first zipcode
                       Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-location__top']", 1,"choosing by index",logger);
                        //Hold for 3sec
                        Thread.sleep(3000);
                        //This will capture the address of the exact workshop place

                    }//statement ends

                    //Creating else statement to go through the same process before for next zipcode
                    else if (i == 1) {

                        Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-location__top']",3,"choosing by index",logger);
                        Thread.sleep(3000);

                        //statement ends
                    }

                    //Creating else statement to go through the same process before for next zipcode

                    else if(i == 2) {
                        Reusable_Library_loggers.clickByIndex(driver,"//*[@class='meeting-location__top']",0,"chossing by index",logger);
                        Thread.sleep(3000);

                    }// statement ends

                    Reusable_Library_loggers.captureText(driver,"//*[@class = 'location__container']","Adresses are",logger);
                    //Hold for 3sec
                    Thread.sleep(3000);
                    //Print out the address from the the page
                    Reusable_Library_loggers.captureText(driver,"//*[@class = 'location__container']","Schedules are",logger);
                    Thread.sleep(3000);

                }//for loop ends



            }

        }//Main class ends
