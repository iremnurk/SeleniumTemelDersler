import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test3 {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        //Selenium ile checkbox'a tıklama
        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        boolean isEnabled = sportCheckbox.isEnabled();
        System.out.println(isEnabled); //tıklanıp tıklanmama etkileşim durumu

        WebElement sportCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));

        if (isEnabled) {
            try {
                sportCheckbox.click();
                System.out.println("Entered try block!");
            } catch (ElementClickInterceptedException e) {
                sportCheckboxLabel.click();
                System.out.println("Entered catch block!");
            }
        }

        boolean isSleceted = sportCheckbox.isSelected();
        System.out.println(isSleceted);
    }
}