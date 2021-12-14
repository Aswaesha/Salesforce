package tests;


import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {


    @Test
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("taeyeononni-hegd@force.com", "Q1w2e3r4t5y6u7");

        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();

        assertTrue(isAccountModalOpen, "Попап не открылся");
        Account account = new Account("TestAccountName", "www.onliner.by", "Investor", "+375447777777", "37544889977", "Aramark", "Apparel", "1,200", "$120,000", "Full time", "str Mazorova", "Gomel", "Gomel obl.", "246053", "Belarus");
        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .isPageOpen();
        Assert.assertTrue(isDetailsPageOpen, "Страница Details не открылась.");


        Assert.assertEquals(accountDetailsPage.getFieldValueByName("Account Name"), account.getAccountName(), "Текст не соответствует Account Name");
        Assert.assertEquals(accountDetailsPage.getFieldValueByName("Type"), account.getType(), "Текст не соответствует Type");
        Assert.assertEquals(accountDetailsPage.getFieldValueByLink("Phone"), account.getPhone(), "Текст не соответствует Phone");
        Assert.assertEquals(accountDetailsPage.getFieldValueByLink("Fax"), account.getFax(), "Текст не соответствует Fax");
        Assert.assertEquals(accountDetailsPage.getFieldValueByPAccount("Parent Account"), account.getParentAccount(), "Текст не соответствует Parent Account");
        Assert.assertEquals(accountDetailsPage.getFieldValueByName("Industry"), account.getIndustry(), "Текст не соответствует Industry");
        Assert.assertEquals(accountDetailsPage.getFieldValueBylightning("Employees"), account.getEmployees(), "Текст не соответствует Employees");
        Assert.assertEquals(accountDetailsPage.getFieldValueByName("Annual Revenue"), account.getAnnualRevenue(), "Текст не соответствует Annual Revenue");
        Assert.assertEquals(accountDetailsPage.getFieldValueByName("Description"), account.getDescription(), "Текст не соответствует Description");
        Assert.assertEquals(accountDetailsPage.getFieldValueByAdress("Billing Address"), account.getBillingStreet() + "\n" + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingZip() + "\n" + account.getBillingCountry(), "Адрес не соответствует");
        Assert.assertEquals(accountDetailsPage.getFieldValueByAdress("Shipping Address"), account.getBillingStreet() + "\n" + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingZip() + "\n" + account.getBillingCountry(), "Адрес доставки не соответствует");


    }
}
