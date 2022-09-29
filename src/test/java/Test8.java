import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;


public class Test8 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //**Selenium ile web sayfasında dosya indirme işlemi
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        //Web sayfasından dosya indirme işlemi yapma
        WebElement downloadButon = driver.findElement(By.id("downloadButton"));
        downloadButon.click();

        String path = "C:/Users/iremn/Downloads";
        String fileName = "sampleFile.jpeg";
        Thread.sleep(3000);
        boolean isDownloaded = isFileDownloaded(path,fileName);
        System.out.println(isDownloaded);
         //////////////////////////////////////////////////////////
        //Web sayfasından dosya yükleme işlemi yapma
        WebElement uploadButon = driver.findElement(By.id("uploadFile"));
        uploadButon.sendKeys("C:/Users/iremn/Downloads/test.png");
    }

   public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                files[i].delete();
                return true;
            }
        }
        return false;
    }
}