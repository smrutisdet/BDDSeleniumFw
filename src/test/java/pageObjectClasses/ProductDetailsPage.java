package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private WebDriver driver;
    private Logger log;
    private boolean flag;
    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    @CacheLookup
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    @CacheLookup
    private WebElement continueShoppingButton;
    @FindBy(xpath = " //a[@href='/view_cart']")
    @CacheLookup
    private WebElement viewCartLink;


    private String ExpectedPageTitle="Automation Exercise - Product Details";
    public ProductDetailsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public boolean verifyProductDetailsPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            log.info("Products Details page is displayed");
            flag=true;
        }
        else {
            log.info("Products Details page is not displayed");
            flag=false;
        }
        return flag;
    }
    public void clickOnAddToCartButton(){
        addToCartButton.click();
        log.info("User Clicked on add To Cart button successfully");
    }
    public void clickOnContinueShoppingButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        continueShoppingButton.click();
        log.info("Clicked on continue shopping button successfully");
    }
    public void clickOnViewCartLink(){
        viewCartLink.click();
        log.info("Clicked on View Cart Link successfully");
    }

}
