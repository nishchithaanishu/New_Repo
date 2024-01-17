package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOf_WebElement {
	public static void main(String[] args) {
        // Set the path to the chromedriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//span[text()='Mobiles & Tablets']")).click();

        // Find the list of web elements using a locator strategy (e.g., XPath, CSS selector, etc.)
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_1kidPb']/span"));

        // Iterate through the elements and extract text
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
        }

//        WebElement text=elements.get(0);
        // Close the browser window
        driver.quit();
    }
}

