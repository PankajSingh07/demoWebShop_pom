package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class PrdudctCheckoutTest {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, IOException {

		productCheckout();
	}

	public static void productCheckout() throws InterruptedException, IOException {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Report/Results.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Purchase a product",
				"Search a product -> Go to checkout page and " + "fill the billing details");

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/config/config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserSelected = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		System.out.println(URL);

//		if (browserSelected == "chrome") {
//			WebDriverManager.chromedriver().setup();
//		    driver = new ChromeDriver();	
//		} else if(browserSelected == "firefox") {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("No browser selected!!");
//		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(URL);

		HomePage homepage = new HomePage(driver);
		CartPage cartpage = new CartPage(driver);
		CheckoutPage checkoutpage = new CheckoutPage(driver);

//		String homePageTitle = homepage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "Demo Web Shop","Home page title not matched");

		String productSearched = prop.getProperty("product");

		homepage.verifyHomePageTitle();
		test.log(Status.INFO, "Following steps search the product and go to product details page");
		homepage.seachProduct(driver, productSearched);
		homepage.clickSearchBtn(driver);
		test.pass("Product searched on the Home page");
		homepage.selectProduct(driver);
		test.pass("Select the searched product and naviage to product landing page");
		homepage.addToCart(driver);
		test.pass("Add the product to the shopping cart");

		test.log(Status.INFO, "Following steps add the product to the cart and go to chekout page");
		cartpage.gotoCartPage(driver);
		cartpage.acceptTerms(driver);
		test.pass("Add product cart and selecet the terms of service checkbox");
		cartpage.clickCheckoutbtn(driver);
		test.pass("Navigate to the checkout page");

		test.info("Steps below add the billing details on checkout page");
		checkoutpage.clickCheckoutGuestbtn(driver);
		checkoutpage.enterFirstName(driver, "John");
		checkoutpage.enterLastName(driver, "Kelli");
		checkoutpage.enterEmail(driver, "kelli.johndws@gmail.com");
		checkoutpage.enterCompanyName(driver, "DSW ltd.");
		checkoutpage.selectCountry(driver, "United States");
		checkoutpage.selectState(driver, "California");
		checkoutpage.enterCityname(driver, "San Jose");
		checkoutpage.enterAddressLine1(driver, "A Avenue");
		checkoutpage.enterAddressLine2(driver, "34th Street");
		checkoutpage.enterZipCode(driver, "94089");
		checkoutpage.enterPhoneNumber(driver, "(555) 555-1234");
		checkoutpage.clickContinueBtn(driver);
		test.pass("Billing address added");
		Thread.sleep(2000);
		driver.close();

		extent.flush();
	}

}
