package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;
    private Logger log;
    @FindBy(xpath = "//input[@name='name_on_card']")
    @CacheLookup
    private WebElement nameOnCard;
    @FindBy(xpath = "//input[@name='card_number']")
    @CacheLookup
    private WebElement cardNumber;
    @FindBy(xpath = "//input[@name='cvc']")
    @CacheLookup
    private WebElement cvcNumber;
    @FindBy(xpath = "//input[@name='expiry_month']")
    @CacheLookup
    private WebElement expiryMonth;
    @FindBy(xpath = "//input[@name='expiry_year']")
    @CacheLookup
    private WebElement expiryYear;
    @FindBy(xpath = " //button[@id='submit']")
    @CacheLookup
    private WebElement payAndConfirmOrder;
    private String ExpectedPageTitle="Automation Exercise - Payment";
    public PaymentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public void verifyPaymentPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            log.info("Payment page is displayed");
        else
            log.info("Payment page is not displayed");
    }
    public void enterPaymentDetails(){
        nameOnCard.sendKeys("Smruti");
        cardNumber.sendKeys("997845672345");
        cvcNumber.sendKeys("234");
        expiryMonth.sendKeys("03");
        expiryYear.sendKeys("2030");
      log.info("Payment Details are entered");
    }
    public void clickOnPayAndConfirmOrder(){
        payAndConfirmOrder.click();
        log.info("Successfully clicked on Pay and Confirm Order");
    }

    
}
