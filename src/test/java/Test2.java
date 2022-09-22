import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2 {
    public static void main(String[] args) {
        /*
        Selenium Checkbox'a tıklama
         */
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/checkbox");

        //Selenium ile checkbox'a tıklama
        String homeCheckboxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";

        WebElement homeCheckbox = driver.findElement(new By.ByCssSelector(homeCheckboxCssValue));
        homeCheckbox.click();

        homeCheckbox = driver.findElement(new By.ByCssSelector(homeCheckboxCssValue));  //
        String homeCheckboxClassName = homeCheckbox.getAttribute("class");

        if (homeCheckboxClassName.equals("rct-icon rct-icon-check")) {
            System.out.println("Checkbox is checked!");
        } else {
            System.out.println("Checkbox is unchecked!");
        }
    }
}
