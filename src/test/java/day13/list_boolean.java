package day13;

import Reusable_methods.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class list_boolean {

    WebDriver driver;


    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {

        driver = Reusable_Library.setDriver();


    }

    @Test
    public void yahoo() throws InterruptedException {

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3500);
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        System.out.println("link count" + linkCount.size());

        if (linkCount.size() == 12) {
            System.out.println("link count matches and it is" + linkCount.size());
        } else {
            System.out.println("link count doesn't match and link count is" + linkCount.size());
        }
        Reusable_Library.click(driver, "//*[@id='header-signin-link']", "SIGN IN");
        Thread.sleep(4000);

        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();

        if (checkboxState == true) {
            System.out.println("checkbox is selected");
        } else {
            System.out.println("checkbox is not selected ");
        }

    }

    @AfterSuite
    public void closeDriver() {

        //driver.quit();

    }

}//end of java class
