package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class DropDown {
    WebDriver driver;
    String label;

    String dropdownLocator = "//div[contains(@class,'modal-body')]//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]/div[@class='uiMenu']";
    String optionLocator = "//div[contains(@class,'visible')]//a[text()='%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info("Writing text '%s' dropdown with label '%s'\n", option, this.label);
        log.info(String.format(dropdownLocator, this.label) + "\n");
        log.info(String.format(dropdownLocator, option) + "\n");
        driver.findElement(By.xpath(String.format(dropdownLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }


}

