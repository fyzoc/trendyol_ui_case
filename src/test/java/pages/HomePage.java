package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='modal-close']")
    public WebElement closeAdv;
    @FindBy(xpath= "(//p[@class='link-text'])[1]")
    public WebElement login;
    @FindBy(xpath= "//h3[text()='Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!']")
    public WebElement textLogin;
    @FindBy(tagName = "a")
    public List<WebElement> boutiqueList;
    @FindBy(id = "login-email")
    public WebElement login_email;
    @FindBy(id = "login-password-input")
    public WebElement login_password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//div[@class='link account-user']")
    public WebElement myAccount;
    @FindBy(linkText = "(//div[@class='icon-container'])[1]")
    public WebElement myAccounticon;
    @FindBy(xpath= "//.[text()='testfeytest@gmail.com']")
    public WebElement userName;
    @FindBy(linkText = "Çıkış Yap")
    public WebElement logout;

}