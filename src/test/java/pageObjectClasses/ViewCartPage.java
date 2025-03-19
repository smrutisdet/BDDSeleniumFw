package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {
    private WebDriver driver;
    private Logger log;
    private boolean flag;
    @FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr[1]/td[2]/h4/a")
    @CacheLookup
    private WebElement CartItem;
    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    @CacheLookup
    private WebElement proceedToCheckOut;
    private String ExpectedPageTitle="Automation Exercise - Checkout";
    public ViewCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public boolean verifyViewCartPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            log.info("View Cart page is displayed");
            flag = true;
        }
        else{
                log.info("View Cart  page is not displayed");
                flag=false;
            }
        return flag;
    }
    public boolean verifyCartItem(String searchedItem){
        if(CartItem.getText().equalsIgnoreCase(searchedItem)) {
            log.info("Added item is present in cart");
            flag = true;
        }
        else {
            log.info("Added item is missing from cart");
            flag = false;
        }
        return flag;
    }
    public void clicksOnProceedToCheckoutLink(){
        proceedToCheckOut.click();
        log.info("Clicked on proceed To Check Out link");
    }

}
