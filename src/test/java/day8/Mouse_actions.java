package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_actions {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https:www.usps.com");
        Thread.sleep(2000);

        Actions mouse = new Actions(driver);

try {
    WebElement element = driver.findElement(By.cssSelector("#mail-ship-width"));

    mouse.moveToElement(element).perform();

} catch (Exception e){

    System.out.println("Unable to hover " + e);


}
try {
    WebElement calcul =driver.findElement(By.cssSelector(".tool-zip"));
    //WebElement calcu =driver.findElement(By.cssSelector(".tool-cns"));
    //WebElement calc =driver.findElement(By.cssSelector(".tool-calc"));
    mouse.moveToElement(calcul).click().perform();
    //A replica for submit....
    //mouse.moveToElement(calc).sendKeys(Keys.ENTER);

}

catch (Exception e){

    System.out.println("Unable to click");


}





    }



}
