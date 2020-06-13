package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Tabs_metlife {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(1000);

        try {
            driver.findElement(By.cssSelector(".header__navigation-container-menu-item")).click();
        }
        catch (Exception e) {
            System.out.println("Unable to click on solutions " + e );

        }
        Thread.sleep(2000);
        try {

            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        }
        catch (Exception e) {
            System.out.println("Unable to click on dental insurance tab " + e );

        }
        Thread.sleep(3000);
        try {

            driver.findElement(By.cssSelector("#takealongdental_product_card_tile_1738502282_content-productActionButtonLink")).click();
        }
        catch (Exception e) {

            System.out.println("Unable to Enroll " + e );

        }
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));

        try {

            driver.findElement(By.cssSelector("#txtZipCode")).sendKeys("11219");
        }
        catch (Exception e) {

            System.out.println("Unable to enter zipCode " + e );

        }// zipcode ends

        Thread.sleep(2000);
        //this will close zipcode page
        driver.close();
        //get back to the previous tab
        driver.switchTo().window(tabs.get(0));
        //hold for 1.5sec
        Thread.sleep(1500);
        //quiting the driver from the browser
        driver.quit();


    }//main method ends




}//main class ends
