package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class TextArea {
    WebDriver driver;
    String label;

    String textAreaLocator = "//div[contains(@class,'modal-body')]//span[text()='%s']/ancestor::label/parent::div//textarea";


    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing text '%s' TextArea with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);

    }
}
