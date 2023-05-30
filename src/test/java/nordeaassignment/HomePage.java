package nordeaassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;

	// Search TextBox
		public static WebElement searchBox(WebDriver driver) {
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
