package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

@Log4j2
public class AccountModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'inlineTitle')]");
    public static final By CHECKBOX = By.xpath("//div[contains(@class,'modal-body')]//*[@type='checkbox']");
    public static final By CHEACH_DROPDOWN_PARENTACCOUNT = By.xpath("//div[contains(@class,'modal-body')]//div[@class='listContent']//ul//li//child::a[1]");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        log.info("Модатьное окно открыто");
        return isExist(MODAL_TITLE);

    }

    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebSite());
        new DropDown(driver, "Type").selectOption(account.getType());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Parent Account").write(account.getParentAccount());
        clickCreateParentAccount();
        new DropDown(driver, "Industry").selectOption(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new TextArea(driver, "Description").write(account.getDescription());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());

        clickCheckbox();
        log.info("Аккаунт создан");
        return clickSave();

    }

    public AccountDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Нажата кнопка Save");
        return new AccountDetailsPage(driver);
    }

    public void clickCheckbox() {
        driver.findElement(CHECKBOX).click();
    }

    public void clickCreateParentAccount() {
        driver.findElement(CHEACH_DROPDOWN_PARENTACCOUNT).click();
    }

}
