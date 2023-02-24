package HeadHunters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

//        WebDriverManager.chromedriver().setup(); //TODO Авто_установка_веб_драйвера
//        WebDriver webDriver = new ChromeDriver();  //TODO Запуск драйвера v1.0

        WebDriver webDriver = WebDriverManager.chromedriver().create(); //TODO v1.2 Chrome
//        WebDriver webDriver =WebDriverManager.firefoxdriver().create(); //TODO FireFox


        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //todo ждать 10с и еще раз найти не явные ожидания
        webDriver.manage().window().setSize(new Dimension(1280, 1024)); //TODO размер окна

        webDriver.get("https://demowebshop.tricentis.com/"); //todo открыть страныицу

        webDriver.findElement(By.linkText("Register")).click(); //todo найти элемент по тексту "Register" и кликнуть

        webDriver.findElement(By.id("gender-male")).click(); //todo выбрать пол (М)

        webDriver.findElement(By.id("FirstName")).sendKeys("Tester"); //todo ввести имя
        webDriver.findElement(By.id("LastName")).sendKeys("Testerov"); //todo ввести фамилию

        webDriver.findElement(By.id("Email")).sendKeys("xxx1993@xxx.com"); //todo ввести email

        webDriver.findElement(By.id("Password")).sendKeys("111111"); //todo ввести пароль
        webDriver.findElement(By.id("ConfirmPassword")).sendKeys("111111"); //todo подтвердить пароль

        webDriver.findElement(By.id("register-button")).click(); //todo нажать кнопку зарегистироваться

        webDriver.findElement(By.linkText("Log in")).click(); //todo Перейти на форму авторизации

        webDriver.findElement(By.id("Email")).sendKeys("xxx1993@xxx.com"); //todo ввести email
        webDriver.findElement(By.id("Password")).sendKeys("111111"); //todo ввести пароль
        webDriver.findElement(By.name("RememberMe")).click(); //todo запомнить меня
        webDriver.findElement(By.xpath("//input[@value='Log in']")).click(); //todo нажать войти

        webDriver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[3]//div[1]//div[2]//div[3]//div[2]//input[1]")).click(); //todo Добавить ноут
                Thread.sleep(5000);
        webDriver.findElement(By.xpath("(//input[@value='Add to cart'])[5]")).click(); //todo собрать комп

//        new WebDriverWait(webDriver,10,500).until(ExpectedConditions.presenceOfElementLocated(By.xpath("product_attribute_74_5_26")));
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@id='product_attribute_74_5_26_82']")).click();
        webDriver.findElement(By.xpath("//input[@id='product_attribute_74_6_27_85']")).click();
        webDriver.findElement(By.id("product_attribute_74_3_28_87")).click();
        webDriver.findElement(By.xpath("//input[@id='add-to-cart-button-74']")).click(); //todo добавить комп

        webDriver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click(); //todo перейти в корзину
        webDriver.findElement(By.xpath("//option[@value='66']")).click();

//        Actions actions = new Actions(webDriver);
//
//        actions.click(webDriver.findElement(By.id("CountryId"))).build().perform();
//        webDriver.findElement(By.xpath("//option[@value='66']"));
        webDriver.findElement(By.id("termsofservice")).click(); //todo согласие
        webDriver.findElement(By.id("checkout")).click(); //todo проверить
        webDriver.findElement(By.xpath("//option[@value='66']")).click(); //todo страна
        webDriver.findElement(By.id("BillingNewAddress_City")).sendKeys("Belgorod"); //todo Город
        webDriver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Belgorod"); //todo адрес
        webDriver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("309202"); //todo индекс
        webDriver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("+7999999999"); //todo номер
        webDriver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click(); //todo продолжить
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click(); //todo шаг2 продолжить
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
//        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']")).click(); //todo шаг3 продолжить
        Thread.sleep(3000);
        webDriver.findElement(By.id("paymentmethod_2")).click(); //todo шаг4
        webDriver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click(); //todo шаг4 продолжить
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Tester Testerov");
        webDriver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("0000 0000 0000 0000");
        webDriver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("999");
        webDriver.findElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]")).click();  //todo шаг5 продолжить
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//input[@value='Confirm']")).click(); //todo шаг6 продолжить
//        Thread.sleep(3000);

        Thread.sleep(5000);

        webDriver.quit();
    }
}
