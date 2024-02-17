package pageObjectClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
    private WebDriver driver;
    private String ExpectedPageTitle="Automation Exercise";
    @FindBy(xpath = "//a[@href='/logout']")
    @CacheLookup
    private WebElement logoutLink;
    public UserHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void verifyUserHomepagePageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            System.out.println("User Home page is displayed");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("User Home page is not displayed");
            Assert.assertTrue(false);
        }
    }
    public void clickLogoutLink(){
        logoutLink.click();
        System.out.println("Clicked on logout link");
    }

}
