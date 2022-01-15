package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class AccountListPage extends BasePage {
    public static final By BREADFCRUMBS_LABEL = By.xpath("//nav[@aria-label='Breadcrumbs']//span");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BREADFCRUMBS_LABEL);
    }


    public AccountListPage open() {
        driver.get(BASE_URL + "/lightning/o/Account/list");
        log.info("Открытие формы аккаунта");
        return this;
    }

    public AccountModalPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        log.info("Клик на кнопку New");
        return new AccountModalPage(driver);
    }
}
