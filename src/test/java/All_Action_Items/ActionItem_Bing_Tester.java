package All_Action_Items; // package starts here. It acts as parent of a class.Main class works under package.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Main class goes below
public class ActionItem_Bing_Tester {

    //Main method starts below this line. Main method holds all variables,loops...etc
    public static void main(String[] args) throws InterruptedException {


        //to connect selenium webdriver to browser we have to set property and add path of the driver execution file.
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        WebDriver driver = new ChromeDriver();//define webdriver must follow same syntax.


        // creating a string array data type with 5 variables and values.Array Size put on to 5.
        String[] country = new String[5];
        country[0] = "Bangladesh";
        country[1] = "USA";
        country[2] = "New Zeland";
        country[3] = "India";
        country[4] = "Italy";

        String[] states = new String[5];
        states[0] = "Dhaka";
        states[1] = "New York";
        states[2] = "Auckland";
        states[3] = "New Delhi";
        states[4] = "Rome";

        String[] location = new String[5];
        location[0] = "Dhaka Metropolitan";
        location[1] = "Brooklyn";
        location[2] = "Great Barrier Island";
        location[3] = "India Gate";
        location[4] = "Roman Forum";

        String[] sports = new String[5];
        sports[0] = "Bangladesh National Cricket Team";
        sports[1] = "Superbowl";
        sports[2] = "Blackcaps";
        sports[3] = "Indian Premier League";
        sports[4] = "Italian National Football Team";

        String[] places = new String[5];
        places[0] = "Dhaka University";
        places[1] = "Central Park of NY";
        places[2] = "Central Zoo";
        places[3] = "Meghalaya";
        places[4] = "Museum of Rome";


        for (int i = 0; i <=4; i++) {

            driver.navigate().to("https://www.bing.com");// navigate.tp will take us to the url.
            driver.manage().window().maximize();//it will make the browser window max.
            Thread.sleep(3000);  // have to throw an exception.

            driver.findElement(By.name("q")).sendKeys(country[i]);// by.name where you search by name,id,class.
            Thread.sleep(3000);// sleep will hold the screen for a given time.
            driver.findElement(By.name("search")).submit();
            Thread.sleep(3000);


            driver.navigate().to("https://www.yahoo.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.id("header-search-input")).sendKeys(states[i]);// sendKeys are my variables array [].
            Thread.sleep(3000);
            driver.findElement(By.name("p")).submit();
            Thread.sleep(3000);

            driver.navigate().to("https://www.duckduckgo.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.name("q")).sendKeys(location[i]);
            Thread.sleep(3000);
            driver.findElement(By.className("search__button  js-search-button")).click();
            Thread.sleep(3000);

            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.name("q")).sendKeys(sports[i]);
            Thread.sleep(3000);
            driver.findElement(By.name("search")).submit();
            Thread.sleep(3000);

            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.findElement(By.name("q")).sendKeys(places[i]);
            Thread.sleep(3000);
            driver.findElement(By.name("search")).submit();
            Thread.sleep(3000);


            String capture = driver.findElement(By.id("b_tween")).getText();//this will capture the screen
            String[] arrayCatch = capture.split(" ");
            System.out.println(" The search number for each values are " + arrayCatch[0]);//printing the values from the capture.

        }// for loop ending curly bracket


        driver.quit();//this will kill the driver from task memory.

    }// class ends.


}// main method ends.
