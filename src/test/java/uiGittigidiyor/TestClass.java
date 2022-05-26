package uiGittigidiyor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.log4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestClass {


    @Test
    public void test() throws InterruptedException, IOException {


        log4j.baslangic("Test baslar");

        Pages pages = new Pages();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        log4j.info("Gittigidiyor sitesi acilir");

        pages.aramaKutusu.sendKeys("bilgisayar" + Keys.ENTER);
        log4j.info("Bilgisayar kelimesi aranir");

        pages.cookies.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript ("window.scrollBy (0,10000)");
        pages.ikinciSayfa.click();
        log4j.info("2.sayfa gidilir");

        String secondUrl = "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2";
        Assert.assertEquals(secondUrl,Driver.getDriver().getCurrentUrl());
        log4j.info("2.sayfa assert edilir");

        js.executeScript ("window.scrollBy (0,300)");
        Thread.sleep(3000);
        pages.birinciUrun.click();
        pages.cookiesIki.click();
        log4j.info("rastgle urun secilir");

        File file = new File("src/test/java/uiGittigidiyor/secilenUrun.txt");
        FileWriter fileWriter = new FileWriter(file);

        String urunBilgisiText = pages.urunBilgisi.getText();
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);
        String urunFiyati = pages.urunFiyati.getText();

        fileWriter.write(urunBilgisiText + " " + urunFiyati);

        fileWriter.close();
        log4j.info("secilen urun ve fiyatı txt dosyasina yazdirilir");


        js.executeScript ("window.scrollBy (0,500)");
        Thread.sleep(2000);
        pages.sepeteEkle.click();
        log4j.info("Urun sepete eklenir");

        Thread.sleep(2000);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(pages.sepet).perform();
        Thread.sleep(2000);
        pages.sepeteGit.click();

        Assert.assertEquals("fiyatlar uyuşmuyor" ,urunFiyati, pages.sepettekiFiyati.getText());
        log4j.info("sepetteki fiyat ile urun fiyatı karsilastirilir");

        Select select = new Select(pages.sepetMiktari);
        select.selectByValue("2");

        Assert.assertTrue("iki adet urun yok", pages.sepettekiUrunSecilmis.isDisplayed());
        log4j.info("iki adet ürün olduğu assert edilir");
        Thread.sleep(2000);

        pages.urunleriSil.click();

        Thread.sleep(3000);
        log4j.info("epetteki ürünler silinir");

        Assert.assertTrue(pages.bosSepet.isDisplayed());
        log4j.info("sepetin bos oldugu assert edilir");

        Driver.closeDriver();
        log4j.info("Sayfa Kapanir.");

        log4j.bitis("***** Test Bitti *****");
    }
}
