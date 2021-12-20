package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextAreaContacts {
    WebDriver driver;
    String label;

    String textAreaLocator = "//*[contains(@class,'modal-body')]//label[text()='%s']/ancestor::lightning-textarea//div//textarea";


    public TextAreaContacts(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void write(String text) {
        System.out.printf("Writing text '%s' TextArea with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);
    }
}
