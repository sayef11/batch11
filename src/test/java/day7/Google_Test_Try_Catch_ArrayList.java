package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_Try_Catch_ArrayList {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ArrayList<String> cars = new ArrayList<>();
        cars.add("Lexus");
        cars.add("BMW");
        cars.add("Toyota");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));

        //for (int i=0; i<cars.size(); ++i) {

            /*driver.get("https://www.google.com");*/
            driver.navigate().to("https://www.metlife.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

          /*  try {

                driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
            }
            catch (Exception e) {
                System.out.println("Unable to enter data " + e );

            }
            Thread.sleep(2000);
            try {

                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            }    // Thread.sleep(3000);
            catch (Exception e) {

                System.out.println("Unable to click on the item " + e );

            }

            Thread.sleep(3000);
            try {
                String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                String[] arrayResult = message.split(" ");
                System.out.println(" The number return as " + arrayResult[1]);
            } catch (Exception e) {

                System.out.println("My city is unable to capture " + e );

            }

        }*/
        driver.quit();
}//main method ends

    }//main class ends


