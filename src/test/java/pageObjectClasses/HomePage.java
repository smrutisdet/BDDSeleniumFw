package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    private String ExpectedPageTitle="Automation Exercise - Signup / Login";
    @FindBy(xpath = "//a[@href='/login']")
    @CacheLookup
    private WebElement signUpOrLogInLink;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickSignUpOrLoginLink(){
        signUpOrLogInLink.click();
        System.out.println("Clicked on SignUp Or Login Link");
    }
    /*public void verifySignUpOrLoginPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            System.out.println("SignUp Or Login page is displayed");
        else
            System.out.println("SignUp Or Login page is not displayed");
    }*/

}
