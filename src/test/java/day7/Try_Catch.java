package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Try_Catch {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("htttps://www.google.com");
        Thread.sleep(3000);







    }






}
