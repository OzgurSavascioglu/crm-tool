package ozgur.crmTool.core.utilities.validation;

import ozgur.crmTool.business.requests.contact.CreateContactRequest;
import ozgur.crmTool.business.requests.contact.UpdateContactRequest;
import ozgur.crmTool.core.utilities.exception.BusinessException;

import java.util.regex.Pattern;

public class ContactValidationUtility {
    private static final int MAX_EMAIL_LENGTH=100;
    private static final int MAX_NAME_LENGTH=100;
    private static final int MAX_PHONE_LENGTH=20;
    private static final int MAX_TITLE_LENGTH=100;
    private static final int MAX_POSITION_LENGTH=100;
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PHONE_REGEX = "^$|^[+]?[(]?[0-9]{1,4}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";

    private static void validateName(String name) throws BusinessException {
        if(name.isEmpty())
            throw new BusinessException("Contact name cannot be empty");
        else if(name.length()>MAX_NAME_LENGTH)
            throw new BusinessException("Contact name is too long");
    }

    private static void validateEmail(String email) throws BusinessException {
        if(email.isEmpty())
            throw new BusinessException("Contact email cannot be empty");

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

    private static void validateTitle(String companyName) throws BusinessException {
        if(companyName.length() > MAX_TITLE_LENGTH)
            throw new BusinessException("Title length is too long");
    }

    private static void validatePosition(String companyName) throws BusinessException {
        if(companyName.length() > MAX_POSITION_LENGTH)
            throw new BusinessException("Position length is too long");
    }

    public static void validateCreateContact(CreateContactRequest contactRequest) throws BusinessException {
        validateName(contactRequest.getName());
        validateEmail(contactRequest.getEmail());
        validatePhone(contactRequest.getPhone());
        validateTitle(contactRequest.getTitle());
        validatePosition(contactRequest.getPosition());
    }

    public static void validateUpdateContact(UpdateContactRequest contactRequest) throws BusinessException {
        validateName(contactRequest.getName());
        validateEmail(contactRequest.getEmail());
        validatePhone(contactRequest.getPhone());
        validateTitle(contactRequest.getTitle());
        validatePosition(contactRequest.getPosition());
    }
}
