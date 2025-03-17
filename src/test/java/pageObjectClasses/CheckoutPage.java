package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private Logger log;
    @FindBy(xpath="//a[contains(text(),'Place Order')]")
    @CacheLookup
    private WebElement placeOrderButton;
    private String ExpectedPageTitle="Automation Exercise - Checkout";
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public void verifyCheckoutPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            log.info("Check Out page is displayed");
        else
            log.info("Check Out  page is not displayed");
    }
    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
        log.info("Clicked on Place Order button");
    }
}
