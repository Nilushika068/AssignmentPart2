package nordeaassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public static WebElement element = null;

	// Search TextBox
		public static WebElement searchBox(WebDriver driver) {
			
			WebDriverWait wd=new WebDriverWait(driver,Duration.ofSeconds(10));
			By elementLocatorSearch=By.id("twotabsearchtextbox");
			wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocatorSearch));
			
 			element = driver.findElement(By.id("twotabsearchtextbox"));
			return element;
		}

		// Locates and returns the search button WebElement.
		public static WebElement searchButton(WebDriver driver) {
			
			
			
			element = driver.findElement(By.xpath("//input[@type='submit']"));
			return element;
		}

		// Clicks on the search button element
		public static void clickSearchButton(WebDriver driver) {
			element = searchButton(driver);
			element.click();
		}

		// filling the search box with the provided search text
		public static void fillSearchBox(WebDriver driver, String search) {
			element = searchBox(driver);
			element.sendKeys(search);
		}

	}
