package ozgur.crmTool.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ozgur.crmTool.core.utilities.exception.BusinessException;
import ozgur.crmTool.core.utilities.exception.NotFoundException;
import ozgur.crmTool.dataAccess.abstracts.CustomerRepository;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    CustomerRepository customerRepository;
    public void checkIfEmailExists(String email) {
        if(customerRepository.existsByEmail(email)) {
            throw new BusinessException("Email already exists");
        }
    }

}
