package JustMyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_Cus_Lib {

    public static int waitingtime = 10;

    //Here we will create a method to call webdriver from outside classes
    public static WebDriver driverSet() {
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);
        return driver;

    }// end of webdriver method

    // now to verify any title of a website or page we will create a method to call for later

    public static void verifyAnyTitle(WebDriver driver, String expectedTitle) {

        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title of the page matches with " + expectedTitle);
        } else {
            System.out.println("Title of the page doesn't matches with expected " + actualTitle);

        }


    }// end of title verifying method

    // now we will create a method to locate any element from a page or send values to that element
    public static void sendValues(WebDriver driver, String locator, String elementName, String userInput) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        try {
            System.out.println("Now checking on this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {

            System.out.println("Unable to locate this element " + elementName + " " + e);

        }


    }// sendKeys method ends

    public static void methodClick(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        try {
            System.out.println("Now clicking on this particular element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();

        } catch (Exception e) {

            System.out.println("Unable to click on the element " + elementName + " " + e);


        }


    }// end of click method


    public static void methodSubmit(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        try {
            System.out.println("Now submitting on this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();

        } catch (Exception e) {
            System.out.println("Unable to submit on this element " + elementName + " " + e);
        }


    }// end of submit method


    public static String captureText(WebDriver driver, String locator, String elementName) {

        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        String result = null;
        try {
            System.out.println("Capturing the text from this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture this element " + elementName + " " + e);
        }
        return result;
    }// end of capture method

    public static void dropdownSelect(WebDriver driver, String locator, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        try {
            System.out.println("Selecting value from this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select d_down = new Select(element);
            d_down.selectByVisibleText(userInput);
        } catch (Exception e) {

            System.out.println("Unable to select from this element dropdown " + elementName + " " + e);
        }

    }// end of dropdown method

    public static void mouseHover(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        Actions hoverMouse = new Actions(driver);

        try {
            System.out.println(" Hovering over this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            hoverMouse.moveToElement(element).perform();

        } catch (Exception e) {

            System.out.println("Unable to hover over this element " + elementName + " " + e);

        }

    }// end of mouseHover method


    public static void mouseClick(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingtime);
        Actions clickMouse = new Actions(driver);
        try {
            System.out.println("Clicking on this element using mouse click " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            clickMouse.moveToElement(element).click().perform();

        } catch (Exception e) {

            System.out.println("Unable to click from mouse on this element " + elementName + " " + e);

        }

    }// end of mouse click method

}
