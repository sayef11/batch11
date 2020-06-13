package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

    public static void main(String[] args) throws InterruptedException {

        String search_path = "//*[@ name = 'field-keywords' or @id='twotabsearchtextbox']";
        String value_path = "//*[@value='Go']";
        String img_path = "//*[contains,(@class,'s-image')]";




        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //and can be used to here//
        //we use // to skip the value holder on a website
        // [] is used for one or more property
        driver.findElement(By.xpath(search_path)).sendKeys("laptop");
        //driver.findElement(By.className("nav-input")).submit();//
        driver.findElement(By.xpath(value_path)).submit();
        Thread.sleep(3000);

        //driver.findElement(By.className("s-image")).click();
        //works mainly for links and images findelements
        driver.findElements(By.xpath(img_path)).get(6).click();

        Thread.sleep(3000);
        driver.quit();


    }//main method ends

}//main class ends
