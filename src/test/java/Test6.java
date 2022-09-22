

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test6 {
    public static void main(String[] args) {
        //--Selenium Dinamik Elementler
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement textElement = driver.findElement(By.xpath("//div/p[1]"));
        String text = textElement.getText();
        System.out.println(text);

        //Will enable 5 seconds butonuna tıklama
        // 5 saniye sonra tıklama
        WebElement firstButon = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstButon)); //5 saniye tıklanılabilir olana kadar bekle
        firstButon.click();

        //Color Change buton kontrolü class name ı değişiyor
        WebElement colorChangeButon = driver.findElement(By.id("colorChange"));
        String className = colorChangeButon.getAttribute("class");
        System.out.println("Before change : " + className);

        WebDriverWait wait2 = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.attributeToBe(colorChangeButon, "class", "mt-4 text-danger btn btn-primary"));
        className = colorChangeButon.getAttribute("class"); //5 saniye class gelene kadar bekle
        System.out.println("After change : " + className);

        //Visible After 5 Seconds butonuna tıklama
        WebDriverWait wait3 = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter"))); //5 saniye görünür olana kadar bekle
        driver.findElement(By.id("visibleAfter")).click();
    }
}


/*
  WebDriverWait (driver, 5); şeklinde yazıp
  süreden dolayı hata  varsa,
  WebDriverWait (driver, Duration.ofSeconds(5)); şeklinde yazabilir.
 */