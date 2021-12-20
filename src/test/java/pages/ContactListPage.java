package pages;

import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage {

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }

    public ContactListPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    public ContactModalPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new ContactModalPage(driver);
    }

}
