package pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsSearchPage {
    private WebDriver driver;
    private Logger log;
    @FindBy(xpath = "//input[@id='search_product']")
    @CacheLookup
    private WebElement searchBox;
    @FindBy(xpath = "//button[@id='submit_search']")
    @CacheLookup
    private WebElement searchButton;
    @FindBy(xpath = "//a[normalize-space()='View Product']")
    @CacheLookup
    private WebElement viewProductButton;
    private String ExpectedPageTitle="Automation Exercise - All Products";
    public ProductsSearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public void verifyProductsPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            log.info("Products Search page is displayed");
        else
            log.info("Products Search page is not displayed");
    }
    public void searchForItem(String searchItem){
        searchBox.sendKeys(searchItem);
        log.info("Entered search item is :"+searchItem);
    }
    public void clickOnSearchButton(){
        searchButton.click();
        log.info("User Clicked on Search button successfully");
    }
    public void clickOnViewProduct(){
        viewProductButton.click();
        log.info("Clicked on view Product button successfully");
    }
}
