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
//    private UserHomePage userHomepage;
//    private BaseSteps baseSteps;
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
        log.info("User clicks on Products Link");
        homePage.clicksProductsLink();
    }
    @And("user enters product search string as {string}")
    public void userEntersProductSearchStringAs(String searchItem) {
        productsSearchPage=new ProductsSearchPage(driver);
        log.info("User enters the search item");
        productsSearchPage.searchForItem(searchItem);
    }
    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        log.info("User clicks on search button");
        productsSearchPage.clickOnSearchButton();
    }

    @Then("user clicks on view products")
    public void userClicksOnViewProducts() {
        log.info("User clicks on view product button from search result");
        productsSearchPage.clickOnViewProduct();
    }

    @And("in product details page user clicks on Add to cart button")
    public void inProductDetailsPageUserClicksOnAddToCartButton() {
        productDetailsPage=new ProductDetailsPage(driver);
        log.info("Verify user is in Product Details Page");
        Assert.assertTrue(productDetailsPage.verifyProductDetailsPageTitle());
        log.info("User clicks on Add To Cart Button");
        productDetailsPage.clickOnAddToCartButton();

    }

    @And("user clicks on Continue Shopping on the displayed pop up window")
    public void userClicksOnContinueShoppingOnTheDisplayedPopUpWindow() {
        log.info("User clicks on Continue Shopping Button");
        productDetailsPage.clickOnContinueShoppingButton();
    }

    @Then("user clicks on cart link and navigates to view cart page")
    public void userClicksOnCartLinkAndNavigatesToViewCartPage() {
        log.info("user clicks on cart link");
        productDetailsPage.clickOnViewCartLink();
        viewCartPage=new ViewCartPage(driver);
        log.info("user verifies the application is in View Cart page");
        Assert.assertTrue(viewCartPage.verifyViewCartPageTitle());
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
        log.info("Verify that user is in payment page");
        Assert.assertTrue(paymentPage.verifyPaymentPageTitle());
        log.info("user enters payment details and clicks on Pay and Confirm Order");
        paymentPage.enterPaymentDetails();
        paymentPage.clickOnPayAndConfirmOrder();
    }
    @And("user navigates to order Confirmation page")
    public void userNavigatesToOrderConfirmationPage() {
        orderConfirmationPage=new OrderConfirmationPage(driver);
        log.info("user navigates to order Confirmation page");
        //Assert.assertTrue(orderConfirmationPage.verifyOrderConfirmationPageTitle());

    }
}
