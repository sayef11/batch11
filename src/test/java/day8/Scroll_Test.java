package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_Test {

    public static void main(String[] args) throws InterruptedException {

//set the chrome path
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver11.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);


        //navigate to met life home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        //wait few seconds

        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-5000)");
        Thread.sleep(1000);
try {


    WebElement homeValue = driver.findElement(By.cssSelector("#homeval"));
   WebElement loanTerm = driver.findElement(By.cssSelector("#loanterm"));
    jse.executeScript("arguments[0].scrollIntoView(true);", homeValue);
}
catch (Exception e){

    System.out.println("Unable to locate " + e);

}



    }


}
