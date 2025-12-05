package com.cucumberpom.base;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    public static WebDriver webDriver;
    public static Properties properties;

    public BaseTest() {
        properties = new Properties();
        //obtengo el archivo de configuraciones
        try (FileInputStream fileInputStream = new FileInputStream("src/test/java/com/cucumberpom/config/config.properties")) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            /*Logger logger= LoggerFactory.getLogger(BaseTest.class);
            logger.error("Fallo al abrir el archivo", e);//recomendación ia por buenas practicas en vez de printTackTrace
            */
        }

    }
    public static void initBrowser(){
        String modo= System.getProperty("execMode");
        String browser=properties.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome") && modo.equals("headless")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1366,768");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--enable-automation");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--incognito");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-popup-blocking");
            WebDriverManager.chromedriver().setup();
            webDriver= new ChromeDriver(options);
        }
        if (browser.equalsIgnoreCase("chrome") && !modo.equals("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            webDriver= new ChromeDriver(options);
        }
        webDriver.manage().window().maximize();


    }
}
