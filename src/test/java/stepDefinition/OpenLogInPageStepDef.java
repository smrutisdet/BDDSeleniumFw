package stepDefinition;
import automationUtilities.BaseSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectClasses.HomePage;
import pageObjectClasses.SignUpLoginPage;
import pageObjectClasses.UserHomePage;

import java.util.List;

public class OpenLogInPageStepDef extends BaseSteps{
    //public static WebDriver driver;
    private HomePage homePage;
    private SignUpLoginPage signupLoginPage;
    private UserHomePage userHomepage;
    private BaseSteps baseSteps;
    @Given("user navigates to the application")
    public void user_navigates_to_the_application() {
        baseSteps=new BaseSteps();
        baseSteps.openURL();
        homePage=new HomePage(driver);
        signupLoginPage=new SignUpLoginPage(driver);
        userHomepage=new UserHomePage(driver);

    }
    @When("user clicks on signup or login link")
    public void user_clicks_on_signup_or_login_link() {
       homePage.clickSignUpOrLoginLink();
    }
    @Then("signup or login page should be displayed")
    public void signup_or_login_page_should_be_displayed() {
        signupLoginPage.verifySignUpOrLoginPageTitle();
    }

    @And("user closes the browser")
    public void userClosesTheBrowser() {
        baseSteps.closeBrowser();
    }

    @And("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String userName, String password) {
        signupLoginPage.enterUserName(userName);
        signupLoginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        signupLoginPage.clickLoginButton();
    }

    @Then("application should navigate to logged in user home page")
    public void applicationShouldNavigateToLoggedInUserHomePage() {
        userHomepage.verifyUserHomepagePageTitle();
    }

    @And("user clicks on logout link")
    public void userClicksOnLogoutLink() {
        userHomepage.clickLogoutLink();
    }

    @And("user enters username  and password")
    public void userEntersUsernameAndPassword(DataTable userCredential) {
        List<List<String>>credentialList=userCredential.asLists(String.class);
        for(List<String> value:credentialList){
            System.out.println(value.get(0)+"===================="+value.get(1));
        }
        signupLoginPage.enterUserName(credentialList.get(0).get(0));
        signupLoginPage.enterPassword(credentialList.get(0).get(1));
    }
}
