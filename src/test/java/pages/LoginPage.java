package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


import static org.testng.Assert.assertTrue;
@Log4j2
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
        log.info("Открытие страцицы");
        return this;
    }

    public HomePage login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        log.info("Ввод имя пользователя");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Ввод пароля");
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Клик на кнопку залогиниться");
        return new HomePage(driver);
    }
}
