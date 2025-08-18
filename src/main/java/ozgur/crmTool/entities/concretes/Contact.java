package ozgur.crmTool.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a contact person associated with a customer in the CRM system.
 * Each contact must be linked to exactly one customer and contains
 * business contact information and communication preferences.
 *
 * <p>Maps to the 'contacts' table in the database with appropriate
 * constraints and relationships.</p>
 */
@Table(name="contacts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    /**
     * Unique identifier for the contact record.
     * Auto-incremented by the database using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * The customer to whom this contact belongs.
     * This establishes a many-to-one relationship where:
     * - Many contacts can belong to one customer
     * - Uses customer_id as the foreign key column
     * - Relationship is mandatory.
     */
    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    /**
     * Full name of the contact person.
     * Required field.
     */
    @Column(name="name", nullable = false)
    private String name;

    /**
     * Primary contact phone number.
     */
    @Column(name="phone")
    private String phone;

    /**
     * Business email address for the contact.
     */
    @Column(name="email")
    private String email;

    /**
     * Professional title
     */
    @Column(name="title")
    private String title;

    /**
     * Job position or role within the company.
     */
    @Column(name="position")
    private String position;

    /**
     * Preferred communication methods and notes.
     * Free-text field for special instructions about
     * how and when to contact this person.
     */
    @Column(name="contact_preferences")
    private String contactPreferences;

    /**
     * Active status flag indicating whether this contact
     * is currently engaged with the company.
     * Defaults to true (active) when created.
     */
    @Column(name="is_active", nullable = false)
    private boolean isActive=true;
}
