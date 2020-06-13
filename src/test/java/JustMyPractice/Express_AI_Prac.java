package JustMyPractice;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Express_AI_Prac {

    public static void main(String[] args) throws InterruptedException, IOException, BiffException {
        //at first I need to define system my location for my excel file
        Workbook readFile = Workbook.getWorkbook(new File("src//Resource//Practice_EX_Express.xls"));

        //after i get the location now i have to call the sheet from that excel by calling it as index array
        Sheet readSheet = readFile.getSheet(0);

        //After reading the file we will call the system to write this file in order to send the outputs to this file
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src//Resource//Practice_EX_Express_details.xls"), readFile);

        //now calling the sheet to make it writable
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //now to get the rows from the sheet we are calling it inside the system
        int rows = writableSheet.getRows();

        WebDriver driver = Practice_Cus_Lib.driverSet();


        //String Size = writableSheet.getCell(0,i).getContents();


        //creating a for lopp so that we can go over all the rows that are there inside the sheet
        for (int i = 1; i < rows; ++i) {


            driver.navigate().to("https://www.express.com");
            Thread.sleep(2800);

            //using mouseHover action on the website
            Practice_Cus_Lib.mouseHover(driver, "//*[@role='menuitem']", "Women");
            Thread.sleep(2800);


            //using mouseclick to click on the tab
            Practice_Cus_Lib.mouseClick(driver, "//*[contains(text(),'Dresses')]", "Dresses");
            Thread.sleep(2800);

            //Choosing the first dress from the page by mouse hover
            Practice_Cus_Lib.mouseHover(driver, "//*[@class='_1ddDj _136PD']", "First Dress");
            Thread.sleep(2500);

            //clicking on the first page by clicking it
            Practice_Cus_Lib.mouseClick(driver, "//*[@class='_1ddDj _136PD']", "First Option");
            Thread.sleep(2500);

            String Size = writableSheet.getCell(0, i).getContents();
            Practice_Cus_Lib.mouseClick(driver, "//*[text()='" + Size + "']", "Sizes");
            Thread.sleep(2700);

            Practice_Cus_Lib.mouseClick(driver, "//*[contains(text(),'Add to Bag')]", "Adding to Bag");
            Thread.sleep(2500);

            Practice_Cus_Lib.mouseHover(driver, "//div[3]/div[1]/button[1]", "Going over bag icon");
            Thread.sleep(2000);

            Practice_Cus_Lib.mouseClick(driver, "//*[contains(text(),'View Bag & Check Out')]", "View bag");
            Thread.sleep(3000);

            //have to get quantity from excel by select dropdown
            String Quantity = writableSheet.getCell(1, i).getContents();
            Practice_Cus_Lib.dropdownSelect(driver, "//*[@id='qdd-0-quantity']", Quantity, "Select quantity");
            Thread.sleep(4000);

            Practice_Cus_Lib.mouseClick(driver, "//*[@id='continue-to-checkout']", "check-out");
            Thread.sleep(3000);

            Practice_Cus_Lib.mouseClick(driver, "//*[contains(text(),'Continue as Guest')]", "as a guest");
            Thread.sleep(3000);
        }


    }

}
