package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    String accountName;
    String webSite;
    String type;
    String phone;
    String fax;
    String parentAccount;
    String industry;
    String employees;
    String annualRevenue;
    String description;
    String billingStreet;
    String billingCity;
    String billingState;
    String billingZip;
    String billingCountry;
}
