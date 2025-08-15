package ozgur.crmTool.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity class representing a Customer in the CRM system.
 * Maps to the 'customers' table in the database and contains
 * all relevant customer information including contact details
 * and business relationship information.
 *
 * Uses Lombok annotations to reduce boilerplate code for getters/setters and constructors.
 */
@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    /**
     * Primary key for the Customer entity.
     * Auto-incremented by the database using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * Full name of the customer.
     * Required field.
     */
    @Column(name="name", nullable = false)
    private String name;

    /**
     * Email address of the customer.
     * Required field and must be unique across all customers.
     */
    @Column(name="email", nullable = false, unique = true)
    private String email;

    /**
     * Contact phone number of the customer.
     */
    @Column(name="phone")
    private String phone;

    /**
     * Physical address of the customer.
     */
    @Column(name="address")
    private String address;

    /**
     * Name of the company the customer represents.
     */
    @Column(name="company_name")
    private String companyName;

    /**
     * Classification of the customer.
     */
    @Column(name="customer_type")
    private String customerType;

    /**
     * Flag indicating whether the customer account is active.
     * Defaults to true (active) when a new customer is created.
     * Required field.
     */
    @Column(name="is_active", nullable=false)
    private boolean isActive=true;

    @OneToMany(mappedBy ="customer")
    private List<Contact> contacts;

}
