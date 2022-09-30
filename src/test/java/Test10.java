import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Test10 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        //Selenium ile alert testi yapma

        //Click Button to see alert
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        //On button click, alert will appear after 5 seconds
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //On button click, confirm box will appear - OK
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();

        //On button click, confirm box will appear - Cancel
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();

        //On button click, prompt box will appear
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys("İremNur");
        driver.switchTo().alert().accept();



    }
}
