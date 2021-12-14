package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        return this;

    }

    public HomePage login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
//        Actions action = new Actions(driver);
//        action.click().sendKeys("").contextClick().clickAndHold().
        return new HomePage(driver);
    }
}
