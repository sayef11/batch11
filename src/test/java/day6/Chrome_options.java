package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_options {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions commands = new ChromeOptions();
        commands.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(commands);

        driver.navigate().to("https://www.netflix.com");
        Thread.sleep(5000);
        //System.out.println("My title is " + driver.getTitle());

        String Actualtitle = driver.getTitle();

        if (Actualtitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR"))

        {
            System.out.println("Title matches with expected");


        }

        else

            {

            System.out.println("Title doesn't match " + Actualtitle);

        }

        WebElement Price = driver.findElement(By.xpath("//*[@name='ma']"));
        WebElement Interest = driver.findElement(By.xpath("//*[@name='ir']"));
        WebElement DropDown = driver.findElement(By.xpath("//*[@name='sm']"));

        Interest.clear();
        Interest.sendKeys("10%");
        Price.clear();
        Price.sendKeys("50000");
        Select monthlist = new Select(DropDown);
        monthlist.selectByVisibleText("Jul");


        String[] Year = new String[]{"2005","2010","2020","2030"};
        for (int i=0;i<Year.length;++i){

            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@text()='"+Year[i]+"']")).click();



        }

        //driver.findElement(By.xpath("//*[@name='sy']")).click();
        //Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[text()='" +Year[i]+ "']")).click();






    }


}
