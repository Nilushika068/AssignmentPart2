package nordeaassignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	public static WebElement element = null;

	// Selects the desired option from the dropdown menu
	public static void selectDropDown(WebDriver driver) {
		WebElement sortByDropdown = driver.findElement(By.xpath("//select[@id='s-result-sort-select']")); // Find the dropdown element
		Select select = new Select(sortByDropdown); // Create a Select object and associate it with the dropdown element
		select.selectByValue("price-desc-rank"); // Select the desired option by its value
		sortByDropdown.sendKeys(Keys.RETURN); // Simulate pressing the "RETURN" key
	}
	// Sort and select the result
	public static void sortResult(WebDriver driver) {
		selectDropDown(driver); // Call the method to select the desired option from the dropdown
	}
	// Selecting the second header element
	public static WebElement selectSecondElement(WebDriver driver) {
	
		WebDriverWait wd=new WebDriverWait(driver,Duration.ofSeconds(10));

		By elementLocatorSearchResult=By.xpath("//div[@data-component-type='s-search-result']");
		wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocatorSearchResult));
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
	
		if(searchResults!=null && searchResults.size() >1) {
			WebElement secondResult = searchResults.get(1); // Get the second result element
			secondResult.click(); 	
			
		}
		
		// Click on the second result element
		return element;
	}

	// CLicking on the details of the second result
	public static void secondElement(WebDriver driver) {
		element = selectSecondElement(driver);
	}

	// Finding the String in the Header Details
	public static WebElement headerDetails(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='productTitle']"));
		return element;
	}


}