package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String[] city = new String[3];
        city[0] = "Queens";
        city[1] = "Manhattan";
        city[2] = "bronx";


        for (int i = 0; i < city.length; i++) {
            /*driver.get("https://www.google.com");*/
            driver.navigate().to("https://www.google.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);


            driver.findElement(By.name("q")).sendKeys(city[i]);
            driver.findElement(By.name("btnK")).submit();
            Thread.sleep(3000);


            String message = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = message.split(" ");
            System.out.println("My city is " + city[i] + " && " + " The number return as " + arrayResult[1]);


        }

        driver.quit();


    }

}
