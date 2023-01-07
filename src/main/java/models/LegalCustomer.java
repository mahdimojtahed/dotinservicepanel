package models;

public class LegalCustomer {
    private String corpName;
    private String registrationDate;
    private String financialCode;
    private String customerNumber;

    public LegalCustomer(String corpName, String registrationDate, String financialCode, String customerNumber) {
        this.corpName = corpName;
        this.registrationDate = registrationDate;
        this.financialCode = financialCode;
        this.customerNumber = customerNumber;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "LegalCustomer{" +
                "corpName='" + corpName + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", financialCode='" + financialCode + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
