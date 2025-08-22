package ozgur.crmTool.core.utilities.validation;

import ozgur.crmTool.business.requests.customer.CreateCustomerRequest;
import ozgur.crmTool.business.requests.customer.UpdateCustomerRequest;
import ozgur.crmTool.core.utilities.exception.BusinessException;

import java.util.regex.Pattern;


public class CustomerValidationUtility {
    private static final int MAX_EMAIL_LENGTH=100;
    private static final int MAX_NAME_LENGTH=100;
    private static final int MAX_PHONE_LENGTH=20;
    private static final int MAX_COMPANY_NAME_LENGTH=100;
    private static final int MAX_CUSTOMER_TYPE_LENGTH=50;
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PHONE_REGEX = "^$|^[+]?[(]?[0-9]{1,4}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";

    private static void validateName(String name) throws BusinessException {
        if(name.isEmpty())
            throw new BusinessException("Customer name cannot be empty");
        else if(name.length()>MAX_NAME_LENGTH)
            throw new BusinessException("Customer name is too long");
    }

    private static void validateEmail(String email) throws BusinessException {
        if(email.isEmpty())
            throw new BusinessException("Customer email cannot be empty");

        else if(email.length() > MAX_EMAIL_LENGTH)
            throw new BusinessException("Email length is too long");

        else if(!Pattern.matches(EMAIL_REGEX, email))
            throw new BusinessException("Invalid email format");

    }

    private static void validatePhone(String phone) throws BusinessException {
        if(phone.length() > MAX_PHONE_LENGTH)
            throw new BusinessException("Phone length is too long");

        else if(!Pattern.matches(PHONE_REGEX,phone))
            throw new BusinessException("Invalid phone format");
    }

    private static void validateCompanyName(String companyName) throws BusinessException {
        if(companyName.length() > MAX_COMPANY_NAME_LENGTH)
            throw new BusinessException("Company name length is too long");
    }

    private static void validateCustomerType(String customerType) {
        if(customerType.length() > MAX_CUSTOMER_TYPE_LENGTH)
            throw new BusinessException("Customer type length is too long");
    }

    public static void validateCreateCustomer(CreateCustomerRequest customerRequest) throws BusinessException {
        validateName(customerRequest.getName());
        validateEmail(customerRequest.getEmail());
        validatePhone(customerRequest.getPhone());
        validateCompanyName(customerRequest.getCompanyName());
        validateCustomerType(customerRequest.getCustomerType());
    }

    public static void validateUpdateCustomer(UpdateCustomerRequest updateCustomerRequest) throws BusinessException {
        validateName(updateCustomerRequest.getName());
        validateEmail(updateCustomerRequest.getEmail());
        validatePhone(updateCustomerRequest.getPhone());
        validateCompanyName(updateCustomerRequest.getCompanyName());
        validateCustomerType(updateCustomerRequest.getCustomerType());
    }


}
