package ozgur.crmTool.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="categories")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    /**
     * Primary key for the Category entity.
     * Auto-incremented by the database using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * Full name of the category.
     * Required field.
     */
    @Column(name="name", nullable = false)
    private String name;
}
