package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

	WebDriver driver = null;

	By checkoutGuestbtn = By.xpath("//input[@type='button' and @value='Checkout as Guest']");
	By firstName = By.id("BillingNewAddress_FirstName");
	By lastName = By.id("BillingNewAddress_LastName");
	By email = By.id("BillingNewAddress_Email");
	By company = By.id("BillingNewAddress_Company");
	By country = By.id("BillingNewAddress_CountryId");
	By state = By.id("BillingNewAddress_StateProvinceId");
	By city = By.id("BillingNewAddress_City");
	By address1 = By.id("BillingNewAddress_Address1");
	By address2 = By.id("BillingNewAddress_Address2");
	By zipCode = By.id("BillingNewAddress_ZipPostalCode");
	By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	By continueBtn = By.xpath("//input[@type='button' and @title='Continue']");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	};

	public void clickCheckoutGuestbtn(WebDriver driver) {

		driver.findElement(checkoutGuestbtn).click();
	}

	public void enterFirstName(WebDriver driver, String fname) {

		driver.findElement(firstName).sendKeys(fname);
	}

	public void enterLastName(WebDriver driver, String lname) {

		driver.findElement(lastName).sendKeys(lname);
	}

	public void enterEmail(WebDriver driver, String emailid) {

		driver.findElement(email).sendKeys(emailid);
	}

	public void enterCompanyName(WebDriver driver, String companyName) {

		driver.findElement(company).sendKeys(companyName);
	}

	public void selectCountry(WebDriver driver, String countryName) throws InterruptedException {

		Select select = new Select(driver.findElement(country));
		select.selectByVisibleText(countryName);
		Thread.sleep(1000);
	}

	public void selectState(WebDriver driver, String stateName) throws InterruptedException {

		Select select = new Select(driver.findElement(state));
		select.selectByVisibleText(stateName);
		Thread.sleep(1000);
	}

	public void enterCityname(WebDriver driver, String cityName) {

		driver.findElement(city).sendKeys(cityName);
	}

	public void enterAddressLine1(WebDriver driver, String addr1) {

		driver.findElement(address1).sendKeys(addr1);
	}

	public void enterAddressLine2(WebDriver driver, String addr2) {

		driver.findElement(address2).sendKeys(addr2);
	}

	public void enterZipCode(WebDriver driver, String zip) {

		driver.findElement(zipCode).sendKeys(zip);
	}

	public void enterPhoneNumber(WebDriver driver, String pnumber) {

		driver.findElement(phoneNumber).sendKeys(pnumber);
	}

	public void clickContinueBtn(WebDriver driver) {

		driver.findElement(continueBtn).click();
	}

}
