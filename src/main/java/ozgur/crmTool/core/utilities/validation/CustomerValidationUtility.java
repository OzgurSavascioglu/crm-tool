package ozgur.crmTool.core.utilities.validation;

import ozgur.crmTool.core.utilities.exception.BusinessException;


public class CustomerValidationUtility {
    private static final int MAX_EMAIL_LENGTH=100;
    private static final int MAX_NAME_LENGTH=100;
    private static final int MIN_NAME_LENGTH=1;
    private static final int MAX_PHONE_LENGTH=20;
    private static final int MAX_COMPANY_NAME_LENGTH=100;
    private static final int MAX_CUSTOMER_TYPE_LENGTH=50;
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PHONE_REGEX = "^$|^[+]?[(]?[0-9]{1,4}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";

    private static void validateEmail(String email) {
        if(email.length() > MAX_EMAIL_LENGTH)
            throw new BusinessException("Invalid email length");
    }

    private static void validatePhone(String phone) {
        if(phone.length() > MAX_PHONE_LENGTH)
            throw new BusinessException("Invalid phone length");
        
    }


}
