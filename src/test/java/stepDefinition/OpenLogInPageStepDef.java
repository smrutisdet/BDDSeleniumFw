package stepDefinition;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectClasses.HomePage;

public class OpenLogInPageStepDef {
    public static WebDriver driver;
    private HomePage homePage;
    String expectedLoginPageTitle="Automation Exercise - Signup / Login";
    @Given("user navigates to the application")
    public void user_navigates_to_the_application() {
        driver= new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        System.out.println("Navigated to application");
        homePage=new HomePage(driver);

    }
    @When("user clicks on signup or login link")
    public void user_clicks_on_signup_or_login_link() {
       homePage.clickSignUpOrLoginLink();
    }
    @Then("signup or login page should be displayed")
    public void signup_or_login_page_should_be_displayed() {
        homePage.verifySignUpOrLoginPageTitle();
    }

    @And("user closes the browser")
    public void userClosesTheBrowser() {
        driver.quit();
    }
}
