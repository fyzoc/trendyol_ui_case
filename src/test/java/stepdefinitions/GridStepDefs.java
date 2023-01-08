package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;
import utilities.Driver;
import java.net.MalformedURLException;
import java.net.URL;
public class GridStepDefs {
    WebDriver driver;
    @Given("user is on homePage Url with Chrome")
    public void userIsOnHomePageUrlWithChrome() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Given("user is on homePage Url with Firefox")
    public void userIsOnHomePageUrlWithFirefox() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),new FirefoxOptions());
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
}

