package pages;

import elements.*;
import models.Account;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    public static final By MODAL_TITLE = By.xpath("//h2[@class='slds-modal__title slds-hyphenate slds-text-heading--medium']");
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By CLICK_DROPDOWN_ACCOUNTNAME = By.xpath("//*[contains(@class,'modal-body')]//ul//li//lightning-base-combobox-item//span[@class='slds-media__body']//lightning-base-combobox-formatted-text");
    public static final By CLICK_DROPDOWN_REPORTSTO = By.xpath("//*[contains(@class,'modal-body')]//lightning-base-combobox-formatted-text[@title='Alex Alex']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    public ContactDetailsPage create(Contact contact) {
        new InputContacts(driver, "Salutation").selectOptionInpur(contact.getSalutation());
        new InputContacts(driver, "First Name").write(contact.getFirstName());
        new InputContacts(driver, "Last Name").write(contact.getLastName());
        new InputContacts(driver, "Account Name").writeSearch(contact.getAccountName());
        clickCreateAccountName();
        new InputContacts(driver, "Title").write(contact.getTitle());
        new InputContacts(driver, "Phone").write(contact.getPhone());
        new InputContacts(driver, "Mobile").write(contact.getMobile());
        new InputContacts(driver, "Email").write(contact.getEmail());
        new InputContacts(driver, "Reports To").writeSearch(contact.getReportsTo());
        clickCreateReportoTo();
        new TextAreaContacts(driver, "Mailing Street").write(contact.getMailingStreet());
        new InputContacts(driver, "Mailing City").write(contact.getMailingCity());
        new InputContacts(driver, "Mailing Zip/Postal Code").write(contact.getMailingZip());
        new InputContacts(driver, "Mailing State/Province").write(contact.getMailingState());
        new InputContacts(driver, "Mailing Country").write(contact.getMailingCountry());
        new TextAreaContacts(driver, "Other Street").write(contact.getOtherStreet());
        new InputContacts(driver, "Other City").write(contact.getOtherCity());
        new InputContacts(driver, "Other Zip/Postal Code").write(contact.getOtherZip());
        new InputContacts(driver, "Other State/Province").write(contact.getOtherState());
        new InputContacts(driver, "Other Country").write(contact.getOtherCountry());
        new InputContacts(driver, "Fax").write(contact.getFax());
        new InputContacts(driver, "Home Phone").write(contact.getHomePhone());
        new InputContacts(driver, "Other Phone").write(contact.getOtherPhone());
        new InputContacts(driver, "Asst. Phone").write(contact.getAsstPhone());
        new InputContacts(driver, "Assistant").write(contact.getAssistant());
        new InputContacts(driver, "Department").write(contact.getDepartment());
        new InputContacts(driver, "Birthdate").write(contact.getBirthdate());
        new TextAreaContacts(driver, "Description").write(contact.getDescription());

        return clickSave();
    }

    public ContactDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }

    public void clickCreateAccountName() {
        driver.findElement(CLICK_DROPDOWN_ACCOUNTNAME).click();
    }

    public void clickCreateReportoTo() {
        driver.findElement(CLICK_DROPDOWN_REPORTSTO).click();
    }


}
