package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class InputContacts {
    String contactInputLocator = "//div[contains(@class,'modal-body')]//label[text()='%s']/ancestor::div[@class='slds-form-element__row']//div//div//div//input[contains(@class,'slds-input')]";
    String contactInputLocatorWrite = "//div[contains(@class,'modal-body')]//label[text()='%s']/ancestor::lightning-input//div//input[@class='slds-input']";
    String optionLocator = "//*[contains(@class,'modal-body')]//lightning-base-combobox-item//span[text()='%s']";
    String contactInputLocatorSearch = "//label[text()='%s']/ancestor::lightning-grouped-combobox//div//div//div//div//input";
    WebDriver driver;
    String label;

    public InputContacts(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing text '%s' input with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(contactInputLocatorWrite, this.label))).sendKeys(text);
    }

    public void writeSearch(String text) {
        log.info("Writing text '%s' input with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(contactInputLocatorSearch, this.label))).sendKeys(text);
    }

    public void selectOptionInput(String option) {
        log.info("Writing text '%s' dropdown with label '%s'\n", option, this.label);
        log.info(String.format(contactInputLocator, this.label) + "\n");
        log.info(String.format(contactInputLocator, option) + "\n");
        driver.findElement(By.xpath(String.format(contactInputLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

}
