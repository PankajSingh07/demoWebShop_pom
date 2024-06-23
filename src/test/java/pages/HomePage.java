package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver = null;
	
	By searchBar = By.id("small-searchterms");
	By searchbtn = By.xpath("//input[@type='submit']");
	By productTitle = By.xpath("//h2[@class='product-title']");
	By addToCartbtn = By.id("add-to-cart-button-31");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyCorrectPagetTitle(){	
		String pageTitle = driver.getTitle();
		return pageTitle.equals("Demo Web Shop");
	}
	
	public void verifyHomePageTitle(){
		if (verifyCorrectPagetTitle() == true) {
			System.out.println("Page Title matched!");
		}
		else {
			System.out.println("Page Title NOT matched!!");
		}
	}
	
	public void seachProduct(WebDriver driver, String product) {

		driver.findElement(searchBar).sendKeys(product);;
	}
	
	public void clickSearchBtn(WebDriver driver) {

		driver.findElement(searchbtn).click();;
	}
	
	public void selectProduct(WebDriver driver) {

		driver.findElement(productTitle).click();
	}
	
	public void addToCart(WebDriver driver) {

		driver.findElement(addToCartbtn).click();;
	}

}
