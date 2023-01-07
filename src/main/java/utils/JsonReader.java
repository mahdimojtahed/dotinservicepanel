package utils;


import com.google.gson.Gson;
import models.LegalCustomer;
import models.RealCustomer;

class RealJsonContent {
    String firstName;
    String lastName;
    String fatherName;
    String birthDay;
    String nationalCode;
    String customerNumber;
}

class LegalJsonContent {
    String corpName;
    String registrationDate;
    String financialCode;
    String customerNumber;
}

public class JsonReader {
    static RealJsonContent realJsonContent;
    static LegalJsonContent legalJsonContent;
    static Gson gson = new Gson();

    public static RealCustomer handleRealCustomer(String JSONString) {
        realJsonContent = gson.fromJson(JSONString, RealJsonContent.class);
        return new RealCustomer(
                realJsonContent.firstName,
                realJsonContent.lastName,
                realJsonContent.fatherName,
                realJsonContent.birthDay,
                realJsonContent.nationalCode,
                realJsonContent.customerNumber
        );
    }
    public static LegalCustomer handleLegalCustomer(String JSONString) {
        legalJsonContent = gson.fromJson(JSONString, LegalJsonContent.class);
        return new LegalCustomer(
                legalJsonContent.corpName,
                legalJsonContent.registrationDate,
                legalJsonContent.financialCode,
                legalJsonContent.customerNumber
        );
    }

}
