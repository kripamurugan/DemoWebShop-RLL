package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ECommercePage_addtocart {

	private final WebDriver driver;

	@FindBy(css = "a.ico-login")
	private WebElement loginLink;

	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;

	@FindBy(css = "input[value='Log in']")
	private WebElement loginButton;

	@FindBy(css = "button[type='submit'][name='register-button']")
	private WebElement registerButton;

	@FindBy(css = "input[value='Add to cart']")
	private WebElement addToCartButton;

	@FindBy(css = "div.product")
	private WebElement product;

	@FindBy(css = "div.cart-item")
	private WebElement cartItem;

	@FindBy(css = "input[value='Remove']")
	private WebElement removeButton;

	@FindBy(css = "span.cart-label")
	private WebElement cartLabel;

	@FindBy(css = "div.cart-status")
	private WebElement cartStatus;

	@FindBy(xpath = "//a[contains(@href, '/books')][1]")
	private WebElement bookmenu;

	@FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
	private WebElement validatesbutton;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")
	private WebElement Iconlist1;

	@FindBy(xpath = "//a[normalize-space()='Copy of Computing and Internet EX']")
	private WebElement Iconlist2;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Fiction']")
	private WebElement Iconlist3;

	@FindBy(xpath = "//a[normalize-space()='Fiction EX']")
	private WebElement Iconlist4;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Health Book']")
	private WebElement Iconlist5;

	@FindBy(xpath = "//a[normalize-space()='Science']")
	private WebElement Iconlist6;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement Shoppingcart;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement Shopingproduct;

	public ECommercePage_addtocart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public void validatebutton() {
		validatesbutton.click();
	}

	public void Iconlists1() {
		Iconlist1.click();
	}

	public void Iconlists2() {
		Iconlist2.click();
	}

	public void Iconlists3() {
		Iconlist3.click();
	}

	public void Iconlists4() {
		Iconlist4.click();
	}

	public void Iconlists5() {
		Iconlist5.click();
	}

	public void Iconlists6() {
		Iconlist6.click();
	}

	public void shoppingcart() {
		Shoppingcart.click();
	}

	public void shoppingpro() {
		Shopingproduct.click();
	}

	public void performLogin(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	public void clickAddToCartButton() {
		addToCartButton.click();
	}

	public void clickOnProduct(int index) {
		driver.findElements(By.cssSelector("div.product")).get(index).click();
	}

	public void clickOnCartItem(int index) {
		driver.findElements(By.cssSelector("div.cart-item")).get(index).click();
	}

	public void clickbookmenu() {
		bookmenu.click();
	}

	public void clickRemoveButton() {
		removeButton.click();
	}

	public String getCartLabelText() {
		return cartLabel.getText();
	}

	public String getCartStatusText() {
		return cartStatus.getText();
	}

}
