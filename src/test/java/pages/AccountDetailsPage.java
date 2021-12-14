package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {
    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String fieldValue = "//records-lwc-detail-panel//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";
    String linkValue = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-phone/a";
    String linkEmpValue = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-number";
    String linkAdressValue = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-address/a";
    String linkPAccountValue = "//records-lwc-detail-panel//span[text()='Parent Account']//ancestor::force-record-layout-item//div//div//slot//force-hoverable-link//div//a//span";

    public String getFieldValueByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }

    public String getFieldValueByLink(String fieldName) {
        return driver.findElement(By.xpath(String.format(linkValue, fieldName))).getText();
    }

    public String getFieldValueBylightning(String fieldName) {
        return driver.findElement(By.xpath(String.format(linkEmpValue, fieldName))).getText();
    }

    public String getFieldValueByAdress(String fieldName) {
        return driver.findElement(By.xpath(String.format(linkAdressValue, fieldName))).getText();
    }

    public String getFieldValueByPAccount(String fieldName) {
        return driver.findElement(By.xpath(String.format(linkPAccountValue, fieldName))).getText();
    }

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }
}
