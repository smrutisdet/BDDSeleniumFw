package stepDefinition;

import automationUtilities.BaseSteps;
import automationUtilities.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectClasses.*;

public class PlaceOrderStepDef extends BaseSteps {
    private UserHomePage userHomepage;
    private BaseSteps baseSteps;
    private HomePage homePage;
    private ProductsSearchPage productsSearchPage;
    private  ProductDetailsPage productDetailsPage;
    private  ViewCartPage viewCartPage;
    private  CheckoutPage checkoutPage;
    private  PaymentPage paymentPage;
    private OrderConfirmationPage orderConfirmationPage;
    private Logger log;
    private WebDriver driver= BrowserFactory.getDriverInstance();

    @And("user clicks on products button")
    public void userClicksOnProductsButton() {
        log=LogManager.getLogger(this.getClass().getName());
        homePage = new HomePage(driver);
        homePage.clicksProductsLink();
        log.info("User clicks on Products Link");
    }
    @And("user enters product search string as {string}")
    public void userEntersProductSearchStringAs(String searchItem) {
        productsSearchPage=new ProductsSearchPage(driver);
        productsSearchPage.searchForItem(searchItem);
        log.info("User enters the search item");
    }
    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        productsSearchPage.clickOnSearchButton();
        log.info("User clicks on search button");
    }

    @Then("user clicks on view products")
    public void userClicksOnViewProducts() {
        productsSearchPage.clickOnViewProduct();
        log.info("User clicks on view product button from search result");
    }

    @And("in product details page user clicks on Add to cart button")
    public void inProductDetailsPageUserClicksOnAddToCartButton() {
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.verifyProductDetailsPageTitle();
        log.info("Verify user is in Product Details Page");
        productDetailsPage.clickOnAddToCartButton();
        log.info("User clicks on Add To Cart Button");
    }

    @And("user clicks on Continue Shopping on the displayed pop up window")
    public void userClicksOnContinueShoppingOnTheDisplayedPopUpWindow() {
        productDetailsPage.clickOnContinueShoppingButton();
        log.info("User clicks on Continue Shopping Button");
    }

    @Then("user clicks on cart link and navigates to view cart page")
    public void userClicksOnCartLinkAndNavigatesToViewCartPage() {
        log.info("user clicks on cart link");
        productDetailsPage.clickOnViewCartLink();
        viewCartPage=new ViewCartPage(driver);
        log.info("user verifies the application is in View Cart page");
        viewCartPage.verifyViewCartPageTitle();
    }
    @Then("user verifies the {string} added in the cart")
    public void userVerifiesTheAddedInTheCart(String searchedItem) {
        log.info("Verify if added item is in cart");
        Assert.assertTrue(viewCartPage.verifyCartItem(searchedItem));
    }
    @Then("user clicks on proceeds To Checkout")
    public void userClicksOnProceedsToCheckout() {
        log.info("user clicks on Proceed To Checkout button");
        viewCartPage.clicksOnProceedToCheckoutLink();
    }
    @And("user clicks on place order")
    public void userClicksOnPlaceOrder() {
        checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickOnPlaceOrderButton();
    }
    @And("user enter payment details and clicks on Pay and Confirm Order")
    public void userEnterPaymentDetailsAndClicksOnPayAndConfirmOrder() {
        paymentPage=new PaymentPage(driver);
        paymentPage.verifyPaymentPageTitle();
        paymentPage.enterPaymentDetails();
        paymentPage.clickOnPayAndConfirmOrder();
    }
    @And("user navigates to order Confirmation page")
    public void userNavigatesToOrderConfirmationPage() {
        orderConfirmationPage=new OrderConfirmationPage(driver);
        Assert.assertTrue(orderConfirmationPage.verifyOrderConfirmationPageTitle());
    }
}
