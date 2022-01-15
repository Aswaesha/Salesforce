package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;
@Log4j2
public class TextAreaContacts {
    WebDriver driver;
    String label;

    String textAreaLocator = "//*[contains(@class,'modal-body')]//label[text()='%s']/ancestor::lightning-textarea//div//textarea";


    public TextAreaContacts(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void write(String text) {
        log.info("Writing text '%s' TextArea with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);
    }
}
