package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown  {
    WebDriver driver;
    String label;

    String dropdownLocator = "//div[contains(@class,'modal-body')]//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]/div[@class='uiMenu']";
    String optionLocator = "//div[contains(@class,'visible')]//a[text()='%s']";





    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        System.out.printf("Writing text '%s' dropdown with label '%s'\n", option, this.label);
        System.out.printf(String.format(dropdownLocator,this.label)+"\n");
        System.out.printf(String.format(dropdownLocator,option)+"\n");
        driver.findElement(By.xpath(String.format(dropdownLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }


}

