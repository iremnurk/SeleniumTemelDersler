import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Test7 {
    public static void main(String[] args) throws IOException {
        //**Selenium Kırık Linkler ve Kırık Görseller
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        //Kırıkolmayan link
        HttpClient client = HttpClientBuilder.create().build(); //client oluşturma
        HttpGet request = new HttpGet("https://demoqa.com/");
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Çalışan link StatusCode: "+statusCode);

        //Kırık Link
        HttpClient client1=HttpClientBuilder.create().build();
        HttpGet request1=new HttpGet("http://the-internet.herokuapp.com/status_codes/500");
        HttpResponse response1=client1.execute(request1);
        int statusCode1 = response1.getStatusLine().getStatusCode();
        System.out.println("Kırık Link StatusCode: "+statusCode1);


        //Kırık görselleri bulma
        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl = brokenImage.getAttribute("src");
        System.out.println(brokenImageUrl);

        HttpClient client2 = HttpClientBuilder.create().build();
        HttpGet request2 = new HttpGet("https://demoqa.com/");
        HttpResponse response2 = client2.execute(request2);
        int statusCode2 = response2.getStatusLine().getStatusCode();
        System.out.println(statusCode2);

        if (statusCode2 == 200) {
            System.out.println("Valid image!");
        } else if (statusCode2 == 500) {
            System.out.println("Broken image!");
        }
    }
}
