package stepdefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nordeaassignment.HomePage;
import nordeaassignment.SearchResultPage;

public class SearchSteps {
	static WebDriver driver;
	String baseUrl = "http://amazon.com";

	@Given("User has to be on Amazon home page")
	public void user_has_to_be_on_amazon_home_page() {
		System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		SearchSteps.driver=driver;
		driver.get(baseUrl); // Call the URL
	//	driver.manage().timeouts().until(20, TimeUnit.SECONDS);
		WebDriverWait wd=new WebDriverWait(driver,Duration.ofSeconds(10));
		wd.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("twotabsearchtextbox"))));
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@When("User search for {string}")
	public void user_search_for(String string) {
		
		HomePage.fillSearchBox(driver, "Nikon");
	}

	@When("Clicks on the search button")
	public void clicks_on_the_search_button() {
		HomePage.clickSearchButton(driver);
	}

	@When("User is on the search result page")
	public void user_is_on_the_search_result_page() {
		System.out.println("User is on the search result page");
	}

	@Then("User select highest to lowest on the sort dropdown menu")
	public void user_select_highest_to_lowest_on_the_sort_dropdown_menu() throws Exception {
		SearchResultPage.sortResult(driver);
		System.out.println("Item have been Sorted");
	}

	@Then("User select the second product from the list")
	public void user_select_the_second_product_from_the_list() {
		SearchResultPage.secondElement(driver);
		System.out.println("Second product selected");	

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	

	}

	@Then("User can confirm if the details header contains the text {string}")
	public void user_can_confirm_if_the_details_header_contains_the_text(String string) {
		String details = SearchResultPage.headerDetails(driver).getText();
		System.out.println(details);
		assert details.contains("Nikon D3X") : "Product topic/header does not contain 'Nikon D3X'";
		//assertTrue(Details.contains(string));

	}

	@Then("Browser should close")
	public void browser_should_close() {
		driver.close();
		System.out.println("The browser has closed. Thank you!");
	}


}
