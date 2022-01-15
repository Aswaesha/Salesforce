package pages;

import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://alexandrabukh3.lightning.force.com";
    public static final By NEW_BUTTON = By.xpath("//a[@href='javascript:void(0);']/div[@title='New']");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public abstract boolean isPageOpen();

    protected boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();

        } catch (NoSuchElementException ex) {
            log.error(">>> !!!" + ex.getMessage());
            return false;
        }

    }


}
