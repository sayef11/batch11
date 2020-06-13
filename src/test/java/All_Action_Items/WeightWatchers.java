package All_Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WeightWatchers {


    //Creating main method

    public static void main(String[] args) throws InterruptedException {

        //Calling webdriver inside property
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        //Chromeoptions will perform tasks inside specific arguments, it only works with chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");

        //Calling chromedriver inside webdriver
        WebDriver driver = new ChromeDriver(options);

        // Going to the website
        driver.navigate().to("https://www.weightwatchers.com");
        // 2sec hold
        Thread.sleep(3000);
        // Taking the actual title from the website
        String ActualTitle = driver.getTitle();

        // Creating if statement to get the title and match it with expected title
        if (ActualTitle.equals("Weight Watchers: Weight Loss & Wellness Help")) {

            System.out.println("Title matches with excepted");

        } else {
            System.out.println(" Title doesn't match & the Actual title is " + "\n" + ActualTitle);
        }
        //Statement ends

        //To test 3 different zipcode, creating an array for size 3

        String[] Zipcode = new String[3];
        Zipcode[0] = "11219";
        Zipcode[1] = "11230";
        Zipcode[2] = "11357";

        //For loop starts here
        for (int i = 0; i <= 2; ++i) {

            //This will take us to find a workshop or location link
            driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div/div/ul/li[1]")).click();
            //Hold for 3sec
            Thread.sleep(3000);
            //this will search in the box where zipcodes will be provided
            driver.findElement(By.xpath("//*[@ id='meetingSearch']")).sendKeys(Zipcode[i]);
            //Hold for 3sec
            Thread.sleep(3000);
            //This will click the searchbar to find zipcodes
            driver.findElement(By.xpath("//*[@ class='btn spice-translated']")).submit();
            //Hold for 3sec
            Thread.sleep(3000);

            //Creating statements where we will call every zipcode one by one
            if (i == 0) {

                //This will get number 2 location link from the page for the first zipcode
                driver.findElements(By.xpath("//*[@class='meeting-location__top']")).get(1).click();
                //Hold for 3sec
                Thread.sleep(3000);
                //This will capture the address of the exact workshop place
            }//statement ends

            //Creating else statement to go through the same process before for next zipcode
            else if (i == 1) {

                driver.findElements(By.xpath("//*[@class='meeting-location__top']")).get(3).click();
                Thread.sleep(3000);


                //statement ends
            }

            //Creating else statement to go through the same process before for next zipcode
            else if (i == 2) {
                driver.findElements(By.xpath("//*[@class='meeting-location__top']")).get(0).click();
                Thread.sleep(3000);

            }

            System.out.println (driver.findElement(By.xpath("//*[@class = 'location__container']")).getText());
            //Hold for 3sec
            Thread.sleep(3000);
            //Print out the address from the the page
            //System.out.println("The Address is " + " \n " + Address + " \n ");
            //Hold for 3sec
            //Thread.sleep(3000);
            //Here the chart information for the specific workshop will be captured
            System.out.println (driver.findElement(By.xpath("//*[@class='meeting-detail-bottom-top']")).getText());
            //Here the chart information will be printed
            //System.out.println("The entire chart information follows " + " \n " + Chart + " \n ");
            //Hold for 3sec
            Thread.sleep(3000);


        }//for loop ends


        driver.quit();//will exit the program

    }//main method ends


}//Main class ends






