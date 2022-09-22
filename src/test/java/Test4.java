import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test4 {
    public static void main(String[] args) {
        //Selenium ile radio butonlara tıklama

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButonLabel= driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        boolean isEnabled = yesRadioButonLabel.isEnabled(); //tıklanabilirliği
        if (isEnabled) {
            yesRadioButonLabel.click();
            System.out.println("Clicked Yes radio button!");
        }

        WebElement yesRadioButonInput = driver.findElement(By.id("yesRadio"));
        boolean isSelected = yesRadioButonInput.isSelected();
        if (isSelected){
            System.out.println("Yes radio button is selected!");
        }

        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(output.getText());

        //---
        WebElement noRadioButon = driver.findElement(By.id("noRadio"));
        System.out.println(noRadioButon.isEnabled());
    }
}
