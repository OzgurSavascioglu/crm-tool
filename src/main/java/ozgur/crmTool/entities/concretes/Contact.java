package ozgur.crmTool.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="contacts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="title")
    private String title;

    @Column(name="position")
    private String position;

    @Column(name="contact_preferences")
    private String contactPreferences;

    @Column(name="is_active", nullable = false)
    private boolean isActive=true;
}
