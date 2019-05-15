package fligths.pages;

import fligths.utils.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;
    protected static GetProperties properties = new GetProperties();
    protected Actions actions;
    protected WebDriverWait wait;
    protected static String titulo;

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean validateTitle(String titulo){
        return getTitle().equals(titulo);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void addWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void selectByText(WebElement select, String text){
        Select combo = new Select(select);
        combo.selectByVisibleText(text);
    }
}
