package fligths.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
    private WebDriver driver = null;
    private static GetProperties properties = new GetProperties();
    private static String browser = properties.getString("BROWSER").toUpperCase();

    public WebDriver getDriver(){
        if(driver == null){
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        if(browser.equals("CHROME")){
            driver = new ChromeDriver(getChromeOptions());
        } else if(browser.equals("FIREFOX")){
            driver = new FirefoxDriver();
        }  else if(browser.equals("IE")){
            driver = new InternetExplorerDriver();
        }
        else {
            System.out.println("Navegador seleccionado no soportado. Se utiliza chrome por defecto");
            driver = new ChromeDriver(getChromeOptions());
        }
        return driver;
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        return options;
    }

    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
