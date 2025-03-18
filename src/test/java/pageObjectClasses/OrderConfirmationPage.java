package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private WebDriver driver;
    private Logger log;
    private boolean flag;

    private String ExpectedPageTitle="Automation Exercise - Order Placed";
    public OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public Boolean verifyOrderConfirmationPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            log.info("Order confirmation page is displayed");
            flag = true;
        }
        else {
            log.info("order confirmation  page is not displayed");
            flag = false;
        }
        return flag;
    }

}
