import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
    public static void main(String[] args) {
 /*
        Selenium ile Web Elementleri Bulma
         */
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/text-box");
        //driver.manage().window().maximize();  //büyük ekranda açılım

        WebElement fullName=driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("İrem Nur");

        WebElement email=driver.findElement(new By.ByCssSelector(".mr-sm-2[type='email']"));
        email.click();
        email.sendKeys("iremtester12@test.com");

        WebElement currentAddress=driver.findElement(new By.ByCssSelector(".form-control[placeholder='Current Address']"));
        currentAddress.click();
        currentAddress.sendKeys("Trabzon,Türkiye");

        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Trabzon,Türkiye");

        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();


        // Selenium ile web elementindeki text'i bulma

        WebElement fullNameText = driver.findElement(By.xpath("//div/p[@id='name']"));
        String name = fullNameText.getText();
        System.out.println(name);

        WebElement emailText = driver.findElement(By.xpath("//div/p[@id='email']"));
        String emailT = emailText.getText();
        System.out.println(emailT);

        WebElement currentAddressText = driver.findElement(By.xpath("//div[@id='output']//p[@id='currentAddress']"));
        String currentAddressT = currentAddressText.getText();
        System.out.println(currentAddressT);

        WebElement permanentAddressText = driver.findElement(By.xpath("//div[@id='output']//p[@id='permanentAddress']"));
        String permanentAddressT = permanentAddressText.getText();
        System.out.println(permanentAddressT);
    }
}
