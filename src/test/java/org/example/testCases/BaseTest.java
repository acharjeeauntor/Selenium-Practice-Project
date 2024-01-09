package org.example.testCases;

import org.example.utilities.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;


public class BaseTest {

    public static Config config = new Config();
    public static String baseUrl = config.getBaseUrl();
    public static String user = config.getUsername();
    public static String pass = config.getPassword();


    public static WebDriver driver;

    @Parameters({"browser","headless"})
    @BeforeClass
    public void appSetUp(String br,String mode) throws IOException, InterruptedException {


        if (br.equals("chrome")) {
            if(mode.equals("true")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }

        } else if (br.equals("firefox")) {
            if(mode.equals("true")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }else {
                driver = new FirefoxDriver();
            }

        }else if(br.equals("safari")) {
            driver = new SafariDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
