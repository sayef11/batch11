package day9;/*package day9;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class statefarm_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = CustoRereusable_library.setDriver();

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10463");

        ArrayList<String> productType = new ArrayList<>();
        productType.add("Auto");
        productType.add("Homeowner");

    for (int i = 0;i<zipCode.size();i++) {
        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.statefarm.com");

        Thread.sleep(2500);

        //call my reusable method to compare title
        CustoRereusable_library.verifyTitle(driver, "Auto, Life Insurance");
        //call my reusable method to select product drop down
        CustoRereusable_library.dropdownByText(driver,"//*[@id='popDropdown']",productType.get(i),"Drop Down");
        //call my reusable method to enter a zipcode
        CustoRereusable_library.userKeys(driver, "//*[@id='quote-main-zip-code-input']", zipCode.get(i), "Zipcode");
        //call my reusable method to click on quote
        CustoRereusable_library.click(driver, "//*[text()='Start Quote']", "Start Quote");

        //capture the result
        String textResult = CustoRereusable_library.captureText(driver,"//h1[contains(text(),'Quote']","Quote");
        String[] testArray = textResult.split(" ");
        System.out.println("My Array result is " + testArray[0]);
        }//end of loop
    }//end of main



}//end of java class

 */
