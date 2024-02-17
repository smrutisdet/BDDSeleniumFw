package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLoginPage {
    private WebDriver driver;
    private String ExpectedPageTitle="Automation Exercise - Signup / Login";
    @FindBy(xpath = "//input[@data-qa='login-email']")
    @CacheLookup
    private WebElement emailIdTextBox;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    @CacheLookup
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    @CacheLookup
    private WebElement loginButton;
    public SignUpLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterUserName(String userName){
        emailIdTextBox.sendKeys(userName);
        System.out.println("Entered User name as :"+userName);
    }
    public void enterPassword(String password){
        passwordTextBox.sendKeys(password);
        System.out.println("Entered password is  :"+password);
    }
    public void clickLoginButton(){
        loginButton.click();
        System.out.println("Clicked on login button");
    }
    public void verifySignUpOrLoginPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            System.out.println("SignUp Or Login page is displayed");
        else
            System.out.println("SignUp Or Login page is not displayed");
    }

}
