package models;

import com.github.javafaker.Faker;

import java.lang.module.ModuleDescriptor;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class AccountFactory {


    static Faker faker = new Faker();
    public static Account get(){
        return  Account.builder()
                .accountName(faker.name().username())
                .webSite(faker.internet().url())
                .type("Investor")
                .phone(faker.phoneNumber().cellPhone())
                .fax(faker.phoneNumber().phoneNumber())
                .parentAccount("TestAccountName")
                .industry("Apparel")
                .employees(faker.number().digit())
                .annualRevenue("$" + faker.number().digit())
                .description(faker.harryPotter().spell())
                .billingStreet(faker.address().streetAddress())
                .billingCity(faker.address().city())
                .billingState(faker.address().state())
                .billingZip(faker.address().zipCode())
                .billingCountry(faker.address().country())
                .build();
        log.info("Ввод данных произошел успешно");
    }
}


