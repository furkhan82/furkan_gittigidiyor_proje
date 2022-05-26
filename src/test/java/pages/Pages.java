package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Pages {

    public Pages() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//a[@class='tyj39b-5 bEEsJG']")
    public WebElement cookies;

    @FindBy(xpath = "//div[@class='gg-ui-button gg-ui-btn-secondary policy-alert-v2-buttons']")
    public WebElement cookiesIki;

    @FindBy (linkText = "2")
    public WebElement ikinciSayfa;

    @FindBy (xpath = "(//li[@class='sc-1nx8ums-0 dyekHG'])[1]")
    public WebElement birinciUrun;

    @FindBy (id = "sp-title")
    public WebElement urunBilgisi;

    @FindBy (xpath = "(//div[@id='sp-price-container']/div/span)[1]")
    public WebElement urunFiyati;

    @FindBy (id = "add-to-basket")
    public WebElement sepeteEkle;

    @FindBy (className = "basket-title")
    public WebElement sepet;

    @FindBy (linkText = "Sepete Git")
    public WebElement sepeteGit;

    @FindBy (xpath = "//p[@class='new-price']")
    public WebElement sepettekiFiyati;

    @FindBy (xpath = "//select[@class='amount']")
    public WebElement sepetMiktari;

    @FindBy (xpath = "//select[@data-value='2']")
    public WebElement sepettekiUrunSecilmis;

    @FindBy (xpath = "( //i[@class='gg-icon gg-icon-bin-medium'])[1]")
    public WebElement urunleriSil;

    @FindBy (xpath = "//div[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']")
    public WebElement bosSepet;



}
