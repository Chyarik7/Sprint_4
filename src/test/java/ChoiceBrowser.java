package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.concurrent.TimeUnit;

public class ChoiceBrowser {
    WebDriver driver;

    // Выбор браузера
    @Before

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

//      FirefoxOptions options2 = new FirefoxOptions();
//      options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//      WebDriverManager.firefoxdriver().setup();
//      driver = new FirefoxDriver(options);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    // Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

}