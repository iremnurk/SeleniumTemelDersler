import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        /*
        Selenium - Window/Tab ile etkileşim
         */

        WebElement tabButton=driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs=new ArrayList<>(driver.getWindowHandles()); //kaç pencere var ona bakar
        System.out.println("pencere sayısı:"+tabs.size());

        driver.switchTo().window(tabs.get(1)); //belirtilen taba geçer
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.close(); //sayfayı kapatır,
        // driver close() ile kill edilmiyor.
        // quit() driver'ı kill eder




    }


}
