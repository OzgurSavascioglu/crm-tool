package ozgur.crmTool.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ozgur.crmTool.entities.concretes.Customer;

import java.util.List;

/**
 * Data Access Layer for Customer entities.
 * Extends Spring Data JPA's JpaRepository.
 *
 * Includes both derived queries and custom JPQL queries for customer data retrieval.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Finds all active customers in the system.
     * Uses a custom JPQL query to filter customers by their active status.
     *
     * @return List of active Customer entities
     */
    @Query("SELECT c FROM Customer c WHERE c.isActive= true")
    List<Customer> findAllActive();

    boolean existsByEmail(String email);
}
