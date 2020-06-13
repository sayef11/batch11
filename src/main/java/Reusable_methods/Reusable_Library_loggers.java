package Reusable_methods;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Reusable_Library_loggers {

    static int timeout = 5;


    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws IOException, InterruptedException {
       // Runtime.getRuntime().exec("taskkill /F /IM chromedriver11.exe/T");
        //Thread.sleep(2000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver11.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver, String expectedTitle,ExtentTest logger) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Expected title matches with Actual " + expectedTitle);
            logger.log(LogStatus.PASS,"Expected title matches with Actual" + expectedTitle);
        } else {
            System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is " + actualTitle);
        }
    }//end of verify title method


    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Selecting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
        }
    }//end of drop down by text method

    //method to enter user input on send keys
    public static void userKeys(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter a value on element " + elementName+ " " + e);
        }
    }//end of sendkeys method

    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,"imageName");
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Submitting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
        }
    }//end of click method

    //method to return text from an element
    public static String captureText(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            System.out.println("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println(elementName+ " is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
        }

        return result;
    }//end of click method

    public static void mouseHover(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions hoverMouse = new Actions(driver);

        try {
            System.out.println("Unable to hover over this element " + elementName);
            logger.log(LogStatus.INFO,"Unable to hover over this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            hoverMouse.moveToElement(element).perform();

        } catch (Exception e) {

            System.out.println("Unable to hover over this element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover over this element " + elementName+ " " + e);

        }

    }// end of mouseHover method


    public static void mouseClick(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions clickMouse = new Actions(driver);
        try {
            System.out.println("Clicking on this element using mouse click " + elementName);
            logger.log(LogStatus.INFO,"Unable to click on this element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            clickMouse.moveToElement(element).click().perform();

        } catch (Exception e) {

            System.out.println("Unable to click from mouse on this element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on this element " + elementName + " " + e);
        }

    }// end of mouse click method


    //method to click by index on an element
    public static void clickByIndex(WebDriver driver, String locator, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value by index " +  index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index + " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index " + index + " on element " + elementName + " " + e);
        }
    }//end of click method

    //method to enter user input on send keys
    public static void userTypeAndHitEnter(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
        }
    }//end of userTypeAndHitEnter method

    public static void mouseclick2(WebDriver driver, String locator, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions clickMouse = new Actions(driver);
        try {
            System.out.println("Clicking on this element using mouse click " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            clickMouse.moveToElement(element).click().perform();
            element.sendKeys(userInput);

        } catch (Exception e) {

            System.out.println("Unable to click from mouse on this element " + elementName + " " + e);

        }


    }


    public static void getScreenShot(WebDriver driver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_report//Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }


 /*  public static KeyEnter(WebDriver driver, String locator, String userInput, String elementName){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
       Keys Enter = new Keys.ENTER;


        try {
            System.out.println("Clicking on this element using mouse click " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            clickEnter.moveToElement(element).perform();
            element.sendKeys(userInput);

        } catch (Exception e) {

            System.out.println("Unable to click from mouse on this element " + elementName + " " + e);

        }

        return KeyEnter;


    }*/

}//end of java class

