package com.trendyol;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void loginPageTest(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sema Nur\\Desktop\\TestTrendyol\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.trendyol.com";

        driver.get(baseUrl);

        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver,10);

        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();

        //reklam kapat
        WebElement reklam = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        reklam.click();

        //Assert.assertEquals("Trendyol'da Satış Yap", driver.getTitle());

        //Giriş yap navbarda görünene kadar bekler ve tıklar
        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#accountBtn"))));
        //WebElement navBarLogin = driver.findElement(By.cssSelector("#accountBtn"));
        navBarLogin.click();

        //Email textbox'ı için veri gönderir
        // WebElement email = driver.findElement(By.xpath("//input[@name='login email']"));
       // WebElement email = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='login email']"))));
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login email']")));
        //email.clear();
        email.sendKeys("testtrendyol0@gmail.com");


        //Password textbox'ı için veri gönderir
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login-password']")));
        //password.clear();
        password.sendKeys("test.1234");


        //Giriş Yap Butonuna Tıklar
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@type,'sub')]")));
        loginBtn.click();

        //Assert.assertEquals("Trendyol'da Satış Yap", driver.getTitle());


    }

    @Test
    public void SearchTest(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sema Nur\\Desktop\\TestTrendyol\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.trendyol.com";

        driver.get(baseUrl);

        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver,10);

        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();

        //reklamı kapatır
        WebElement reklam = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        reklam.click();

        //search kutucuğuna bilgisayar kelimesini yazar
        WebElement search = driver.findElement(By.xpath("//input[@class='search-box']"));
        search.sendKeys("bilgisayar");
        search.sendKeys(Keys.ENTER);

    }
    @Test
    public void urunEkleSil(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sema Nur\\Desktop\\TestTrendyol\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.trendyol.com";

        driver.get(baseUrl);
        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver,20);
        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();
        //reklamı kapatır
        WebElement reklam = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        reklam.click();

        //Giriş yap navbarda görünene kadar bekler ve tıklar
        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#accountBtn"))));
        navBarLogin.click();

        //Email textbox'ı için veri gönderir
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login email']")));
        email.sendKeys("testtrendyol0@gmail.com");

        //Password textbox'ı için veri gönderir
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='login-password']")));
        password.sendKeys("test.1234");

        //Giriş Yap Butonuna Tıklar
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@type,'sub')]")));
        loginBtn.click();

        //search kutucuğuna bilgisayar kelimesini yazar
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='search-box']")));
        search.sendKeys("bilgisayar");
        search.sendKeys(Keys.ENTER);

        //ürüne tıklar
        WebElement urun = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='https://cdn.dsmcdn.com//ty2/product/media/images/20200504/14/618411/70098090/1/1_org.jpg']")));
        urun.click();

        //tıklanan ürünü sepete ekler
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "sepeteEkle");
        WebElement sepeteEkle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='add-to-bs-tx']")));
        sepeteEkle.click();

        //sepetime girer
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("window.scrollBy(0,-350)", "sepetim");
        WebElement sepetim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon navigation-icon-basket']")));
        sepetim.click();

        //ürünü sepetten siler
        WebElement sepettenSil = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='i-trash']")));
        sepettenSil.click();
        WebElement silBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/button[2]")));  
        silBtn.click();                                      // iki farklı sil butonu çıkıyor. Diğer butonun xpath =//*[@class='btn-item btn-remove']

        //Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.", driver.getTitle());

    }


   /* public void random(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sema Nur\\Desktop\\TestTrendyol\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.trendyol.com";
        driver.get(baseUrl);
        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();    //browser'ı maksimum boyuta getirir

        WebElement reklam = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));     //reklamı kapatır
        reklam.click();
        WebElement search = driver.findElement(By.xpath("//input[@class='search-box']"));     //search kutucuğuna bilgisayar kelimesini yazar
        search.sendKeys("bilgisayar");
        search.sendKeys(Keys.ENTER);

        Random rnd = new Random();
        int index = rnd.nextInt(24)+1;  //rastgele bir sayı seçilir

        List<WebElement> urunlerIsimListesi = (List<WebElement>) driver.findElement(By.xpath("//div[@class='search-app-container']"));
        String urunIsmi = urunlerIsimListesi.get(index).getText();  //rastgele bir ürün ismi karşılaştırmak için alınır
        List<WebElement> urunListesi = (List<WebElement>) driver.findElement(By.xpath());
        urunListesi.get(index).click();   //arama sonrası çıkan ürünlerden rastgele tıklama
        String urunSayfasindakiIsmi = driver.findElement(By.xpath()).getText();
        Assert.assertEquals("", urunSayfasindakiIsmi, urunIsmi );

    }*/
}
