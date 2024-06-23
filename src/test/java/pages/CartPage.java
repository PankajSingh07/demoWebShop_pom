package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	
	WebDriver driver = null;
	
	By shoppingCartBtn = By.xpath("//span[@class='cart-label' and text()='Shopping cart']");
	By termOfSerive = By.id("termsofservice");
	By checkoutBtn = By.id("checkout");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void gotoCartPage(WebDriver driver) {

		driver.findElement(shoppingCartBtn).click();
	}

	public void acceptTerms(WebDriver driver) {

		driver.findElement(termOfSerive).click();;
	}

	public void clickCheckoutbtn(WebDriver driver) {

		driver.findElement(checkoutBtn).click();
	}

}
