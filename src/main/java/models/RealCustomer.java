package models;

import java.util.Date;

public class RealCustomer {
    private String firstName;
    private String lastName;
    private String father;
    private String birthDate;
    private String nationalCode;
    private String customerNumber;

    public RealCustomer(String firstName, String lastName, String father, String birthDate, String nationalCode, String customerNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.father = father;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", father='" + father + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
