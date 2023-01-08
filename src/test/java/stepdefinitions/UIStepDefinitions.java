package stepdefinitions;

import com.opencsv.CSVWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class UIStepDefinitions {
    HashMap<String, Integer> mapOfLinks = new HashMap<String, Integer>();
    HomePage homePage = new HomePage();
    @Given("user is on homePage")
    public void user_is_on_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Then("user verifies that home page is visible successfully")
    public void userVerifiesThatHomePageIsVisibleSuccessfully() {
        //Assert.assertEquals("https://www.trendyol.com/",Driver.getDriver().getCurrentUrl());
    }
    @And("user get list of all boutique name in a list")
    public void userGetListOfAllBoutiqueNameInAList() throws InterruptedException, IOException {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = homePage.boutiqueList;
        //  for(int i =0; i< links.size();i++){
        //    System.out.println("texts: " + links.get(i).getText());
        //  }
        //System.out.println(links);
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            //System.out.println(url);
            if (url == null || url.isEmpty()) {
                //  System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            if (!url.startsWith(ConfigReader.getProperty("base_url"))) {
                //    System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = (Integer) huc.getResponseCode();
                if (respCode >= 400) {
                    //  System.out.println(url+" is a broken link");
                    // System.out.println(respCode);
                } else {
                    // System.out.println(url+" is a valid link");
                    // System.out.println(respCode);
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mapOfLinks.put(url, respCode);
        }
        for (int i = 0; i < mapOfLinks.size(); i++) {
            //System.out.println(i + "boutiqueUrl :" + linkedList.get(i));
        }
        System.out.println("mapOfLinks = " + mapOfLinks);
        System.out.println("mapOfLinks.size() = " + mapOfLinks.size());

        Set<String> urls = mapOfLinks.keySet();
        System.out.println("urls = " + urls);

        Collection<Integer> respCodes = mapOfLinks.values();
        System.out.println("respCodes.size() = " + respCodes.size());
        System.out.println("respCodes = " + respCodes);

        Set<Map.Entry<String, Integer>> setMapForm = mapOfLinks.entrySet();

        for (Map.Entry<String, Integer> w : setMapForm) {
            System.out.println("url: " + w.getKey() + " respCode: " + w.getValue());
        }
        String eol = System.getProperty("line.separator");
        try (Writer writer = new FileWriter("C:\\Users\\HP\\IdeaProjects\\trendyol_case\\src\\test\\resources\\testdata\\list_link&respnscodes.csv")) {
            for (Map.Entry<String, Integer> entry : setMapForm) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @When("user click on login button")
    public void userClickOnLoginButton() throws InterruptedException {
        homePage.login.click();
        // Assert.assertTrue(homePage.textLogin.isDisplayed());
    }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        Driver.closeDriver();
    }

    @And("report duration when scrolled through the images")
    public void reportDurationWhenScrolledThroughTheImages() {
    }

    @And("user enters {string}")
    public void userEnters(String keyword) {
        switch (keyword) {
            case "email":
                homePage.login_email.sendKeys(ConfigReader.getProperty("email"));
                break;
            case "password":
                homePage.login_password.sendKeys(ConfigReader.getProperty("password"));
                break;
        }
    }

    @When("user close advertisement alert")
    public void userCloseAdvertisementAlert() {
        homePage.closeAdv.click();
    }

    @Then("user verifies that on the sign in page is visible successfully")
    public void userVerifiesThatOnTheSignInPageIsVisibleSuccessfully() throws InterruptedException, IOException {
        Thread.sleep(2000);
        Assert.assertEquals("Hesabım", homePage.myAccount.getText());
        ReusableMethods.clickWithJS(homePage.myAccount);
        //Assert.assertEquals("https://www.trendyol.com/hesabim/siparislerim",Driver.getDriver().getCurrentUrl());
        // Actions actions = new Actions(Driver.getDriver());
        //actions.contextClick(homePage.myAccount).build();
        //Thread.sleep(1000);
        //ReusableMethods.getScreenshot("screen01");
        //ReusableMethods.clickWithJS(homePage.logout);
    }

    @When("user click on submit button")
    public void userClickOnSubmitButton() {
        homePage.submit.click();
    }
}
