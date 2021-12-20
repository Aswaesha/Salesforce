package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {

    public static final By DETAILS_LINK = By.xpath("//a[@id='detailTab__item']");
    String fieldValue = "//records-lwc-detail-panel//span[text()='%s']/ancestor::force-record-layout-item//lightning-formatted-text";
    String linkValue = "//records-lwc-detail-panel//force-record-layout-item//span[text()='%s']//ancestor::force-record-layout-item//div//slot//lightning-formatted-phone//a";
    String nameValue = "//records-lwc-detail-panel//slot//lightning-formatted-name";
    String typeValue = "//span[text()='%s']//ancestor::force-record-layout-item//force-hoverable-link//div//a//slot//slot/span";
    String emailValue = "//div[@class='slds-truncate']//a";
    String adressValue = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-address/a";

    public String getFieldValueByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }

    public String getFieldValueByLink(String fieldName) {
        return driver.findElement(By.xpath(String.format(linkValue, fieldName))).getText();
    }

    public String getFieldValueByNameOfPage(String fieldName) {
        return driver.findElement(By.xpath(String.format(nameValue, fieldName))).getText();
    }

    public String getFieldValueByTypeOfPage(String fieldName) {
        return driver.findElement(By.xpath(String.format(typeValue, fieldName))).getText();
    }

    public String getFieldValueByEmail(String fieldName) {
        return driver.findElement(By.xpath(String.format(emailValue, fieldName))).getText();
    }

    public String getFieldValueByAdress(String fieldName) {
        return driver.findElement(By.xpath(String.format(adressValue, fieldName))).getText();
    }

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }
}
