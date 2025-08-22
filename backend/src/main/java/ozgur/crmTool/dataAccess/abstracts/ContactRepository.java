package ozgur.crmTool.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ozgur.crmTool.entities.concretes.Contact;

import java.util.List;

/**
 * Data Access Layer for Contact entities.
 * Extends Spring Data JPA's JpaRepository to provide CRUD operations
 * and custom queries for Contact records.
 *
 * <p>Includes both derived queries and custom JPQL queries for contact data retrieval.</p>
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    /**
     * Retrieves all active contacts from the database.
     * Uses a custom JPQL query to filter contacts by their active status.
     *
     * @return List of active Contact entities
     * @see Contact#isActive
     */
    @Query("SELECT c FROM Contact c WHERE c.isActive= true")
    List<Contact> findAllActive();
}
