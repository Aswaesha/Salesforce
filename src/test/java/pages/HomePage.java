package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public static final By MENU_HOME_LINK = By.xpath("//span[@class='slds-truncate' and text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(BASE_URL + "/lightning/page/home");
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MENU_HOME_LINK);
    }
}
