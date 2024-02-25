package stepDefinition;

import automationUtilities.BaseSteps;
import automationUtilities.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectClasses.HomePage;
import pageObjectClasses.SignUpLoginPage;
import pageObjectClasses.UserHomePage;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OpenLogInPageStepDef extends BaseSteps {
    //public static WebDriver driver;
    private HomePage homePage;
    private SignUpLoginPage signupLoginPage;
    private UserHomePage userHomepage;
    private BaseSteps baseSteps;
    private Logger log;
    private WebDriver driver= BrowserFactory.getDriverInstance();

    @Given("user navigates to the application")
    public void user_navigates_to_the_application() {
        log=LogManager.getLogger(this.getClass().getName());
        baseSteps = new BaseSteps();
        log.info("User trying to  navigate to application");
        baseSteps.openURL(driver);
        homePage = new HomePage(driver);
        signupLoginPage = new SignUpLoginPage(driver);
        userHomepage = new UserHomePage(driver);


    }

    @When("user clicks on signup or login link")
    public void user_clicks_on_signup_or_login_link() {
        log.info("User  trying to click on log in link");
        homePage.clickSignUpOrLoginLink();

    }

    @Then("signup or login page should be displayed")
    public void signup_or_login_page_should_be_displayed() {
        log.info("Verifying SignUp/Login Page is displayed");
        signupLoginPage.verifySignUpOrLoginPageTitle();
    }
    @And("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String userName, String password) {
        log.info("User is entering user Name and password");
        signupLoginPage.enterUserName(userName);
        signupLoginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        log.info("user is clicking on Login button");
        signupLoginPage.clickLoginButton();
    }

    @Then("application should navigate to logged in user home page")
    public void applicationShouldNavigateToLoggedInUserHomePage() {
        log.info("User is verifying application is navigated to user Home Page");
        userHomepage.verifyUserHomepagePageTitle();
    }

    @And("user clicks on logout link")
    public void userClicksOnLogoutLink() {
        log.info("User is trying to click on logout link");
        userHomepage.clickLogoutLink();
    }

    @And("user enters username  and password")
    public void userEntersUsernameAndPassword(DataTable userCredential) {
        log.info("user is trying to enter credentials using MAp");
        // DataTable as Map implementation
        List<Map<String, String>> credentialMap = userCredential.asMaps(String.class, String.class);
        for (Map<String, String> value : credentialMap) {
            log.info(value.get("username") + "====================>" + value.get("password"));
        }
        signupLoginPage.enterUserName(credentialMap.get(0).get("username"));
        signupLoginPage.enterPassword(credentialMap.get(0).get("password"));
    }

    @And("user enters username  and password as below")
    public void userEntersUsernameAndPasswordAsBelow(DataTable userCredential) {
        log.info("user is trying to enter credentials using list");
         // Data Table as Lists implementation
        List<List<String>>credentialList=userCredential.asLists(String.class);
        for(List<String> value:credentialList){
            log.info(value.get(0)+"===================="+value.get(1));
        }
        signupLoginPage.enterUserName(credentialList.get(0).get(0));
        signupLoginPage.enterPassword(credentialList.get(0).get(1));
    }
}
