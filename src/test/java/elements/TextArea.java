package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;

    String textAreaLocator = "//div[contains(@class,'modal-body')]//span[text()='%s']/ancestor::label/parent::div//textarea";


    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void write(String text) {
        System.out.printf("Writing text '%s' TextArea with label '%s'\n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);

    }
}
