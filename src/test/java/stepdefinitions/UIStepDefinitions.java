package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class UIStepDefinitions {
    HomePage homePage = new HomePage();
    @Given("user is on homePage")
    public void user_is_on_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        homePage.login.click();
    }
}
