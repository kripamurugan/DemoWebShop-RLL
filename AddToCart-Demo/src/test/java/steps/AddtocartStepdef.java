package steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ECommercePage_addtocart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtocartStepdef {

	private final WebDriver driver;
	private final ECommercePage_addtocart eCommercePage_addtocart;

	public AddtocartStepdef() {
		driver = new ChromeDriver();
		eCommercePage_addtocart = new ECommercePage_addtocart(driver);
	}

	@Given("User navigates to the URL")
	public void userNavigatesToURL() {
		eCommercePage_addtocart.navigateToURL("http://demowebshop.tricentis.com");
	}

	@When("User performs the login process")
	public void userPerformsLoginProcess() {
		eCommercePage_addtocart.clickLoginLink();
		eCommercePage_addtocart.performLogin("demouser1234@gmail.com", "123456");
	}

	@Then("Validate the login is successful")
	public void validateLoginProcess() {
		String e1 = driver.getTitle();
		String e2 = "Demo Web Shop";
		Assert.assertEquals(e2, e1);

	}

	@And("User clicks on book menu")
	public void Userclickbookmenu() {
		eCommercePage_addtocart.clickbookmenu();

	}

	@Then("User validates whether all books have addtocart button")
	public void validatescartbutton() throws InterruptedException {
		driver.manage().window().maximize();
		eCommercePage_addtocart.Iconlists1();
		String buttonxpath = "//input[@class='button-1 add-to-cart-button']";
		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product1");

		} else {
			System.out.println("Button is not present product1");
		}
		driver.navigate().back();

		eCommercePage_addtocart.Iconlists2();
		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product2");

		} else {
			System.out.println("Button is not present product2");
		}
		captureScreenshot(driver, "screenshot1.png");

		driver.navigate().back();

		eCommercePage_addtocart.Iconlists3();

		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product3");

		} else {
			System.out.println("Button is not present product3");
		}
		driver.navigate().back();

		eCommercePage_addtocart.Iconlists4();
		Thread.sleep(2000);
		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product4");

		} else {
			System.out.println("Button is not present product4");
		}
		captureScreenshot(driver, "screenshot2.png");
		driver.navigate().back();

		eCommercePage_addtocart.Iconlists5();
		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product5");

		} else {
			System.out.println("Button is not present product5");
		}
		driver.navigate().back();

		eCommercePage_addtocart.Iconlists6();
		if (isElementPresentByXPath(driver, buttonxpath)) {

			System.out.println("Button is present in product6");

		} else {
			System.out.println("Button is not present product6");
		}
		captureScreenshot(driver, "screenshot3.png");
		driver.navigate().back();

	}

	@And("User add third book to cart")
	public void addthirdbooktocart() {
		eCommercePage_addtocart.Iconlists3();
		eCommercePage_addtocart.validatebutton();
		eCommercePage_addtocart.shoppingcart();

	}

	@Then("Validate the third book is successfully added to the cart")
	public void validatethirdbook() {
		String Shopingproduct = "//tbody[1]//td[@class='product']//a[text()='Fiction']";
		if (isElementPresentByXPath(driver, Shopingproduct)) {
			System.out.println("Third product added to cart");

		} else {
			System.out.println("Cart is empty");
		}
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//td/input[@type='checkbox']"));
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		eCommercePage_addtocart.shoppingpro();

	}

	@And("User adds any 3 products to the cart")
	public void addanythreeproducts() {
		eCommercePage_addtocart.Iconlists1();
		eCommercePage_addtocart.validatebutton();
		driver.navigate().back();
		eCommercePage_addtocart.Iconlists3();
		eCommercePage_addtocart.validatebutton();
		driver.navigate().back();
		eCommercePage_addtocart.Iconlists5();
		eCommercePage_addtocart.validatebutton();
		driver.navigate().back();
	}

	@And("User deletes any two products from the cart")
	public void deletetwoproducts() {
		eCommercePage_addtocart.shoppingcart();
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//td/input[@type='checkbox']"));
		for (int i = 0; i < Math.min(2, checkboxes.size()); i++) {
			checkboxes.get(i).click();
		}
		eCommercePage_addtocart.shoppingpro();

	}

	@Then("Validate the cart after deleting the products")
	public void validateproductafterdelete() {
		WebElement table = driver.findElement(By.xpath("//table/tbody"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		if (rowCount == 1) {
			System.out.println("Validation passed: Only one product in the cart.");
		} else {
			System.out.println("Validation failed: Multiple product in the cart.");
		}

	}

	private static boolean isElementPresentByXPath(WebDriver driver, String xpath) {
		return !driver.findElements(By.xpath(xpath)).isEmpty();
	}

	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(fileName);
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
			System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot: " + e.getMessage());
		}
	}

	// Close the WebDriver after all scenarios
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

