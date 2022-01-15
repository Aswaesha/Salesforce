package tests;

import models.Account;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactsTest extends BaseTest {

    @Test(description= "New contact")
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("aleksa.bah-mpsm@force.com", "Q1w2e3r4t5y6u7");
        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();

        assertTrue(isContactModalOpen, "Попап не открылся");
        Contact contact = new Contact("Ms.", "Alex", "Ivina", "TestAccountName", "Project",
                "122345", "+375441234567", "qwertyuiop@gmail.com", "Alex Alex", "str. Sovetskaya", "Minsk",
                "123456", "Minskaya obl.", "Belarus", "str. Pobedy", "Moskow", "789456",
                "Moskow obl.", "Russia", "(982)7456321", "789456", "987456",
                "123456678", "Ivan", "Engineering", "12/12/2021", "bla bla bla");
        boolean isDetailsPageOpen = contactModalPage
                .create(contact)
                .isPageOpen();
        Assert.assertTrue(isDetailsPageOpen, "Страница Details не открылась.");


        Assert.assertEquals(contactDetailsPage.getFieldValueByName("Title"), contact.getTitle(), "Текст не соответствует Title");
        Assert.assertEquals(contactDetailsPage.getFieldValueByName("Department"), contact.getDepartment(), "Текст не соответствует Department");
        Assert.assertEquals(contactDetailsPage.getFieldValueByName("Description"), contact.getDescription(), "Текст не соответствует Description");
        Assert.assertEquals(contactDetailsPage.getFieldValueByName("Birthdate"), contact.getBirthdate(), "Текст не соответствует Birthdate");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Phone"), contact.getPhone(), "Текст не соответствует Phone");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Mobile"), contact.getMobile(), "Текст не соответствует Mobile");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Fax"), contact.getFax(), "Текст не соответствует Fax");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Home Phone"), contact.getHomePhone(), "Текст не соответствует Home Phone");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Other Phone"), contact.getOtherPhone(), "Текст не соответствует Other Phone");
        Assert.assertEquals(contactDetailsPage.getFieldValueByLink("Asst. Phone"), contact.getAsstPhone(), "Текст не соответствует Asst. Phone");
        Assert.assertEquals(contactDetailsPage.getFieldValueByNameOfPage("Name"), contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName(), "Текст не соответствует Name");
        Assert.assertEquals(contactDetailsPage.getFieldValueByTypeOfPage("Reports To"), contact.getReportsTo(), "Текст не соответствует Reports To");
        Assert.assertEquals(contactDetailsPage.getFieldValueByTypeOfPage("Account Name"), contact.getAccountName(), "Текст не соответствует Account Name");
        Assert.assertEquals(contactDetailsPage.getFieldValueByEmail("Email"), contact.getEmail(), "Текст не соответствует Email");
        Assert.assertEquals(contactDetailsPage.getFieldValueByAdress("Mailing Address"), contact.getMailingStreet() + "\n" + contact.getMailingCity() + ", " + contact.getMailingState() + " " + contact.getMailingZip() + "\n" + contact.getMailingCountry(), "Текст не соответствует Mailing Address");
        Assert.assertEquals(contactDetailsPage.getFieldValueByAdress("Other Address"), contact.getOtherStreet() + "\n" + contact.getOtherCity() + ", " + contact.getOtherState() + " " + contact.getOtherZip() + "\n" + contact.getOtherCountry(), "Текст не соответствует Other Address");


    }
}
