package ozgur.crmTool.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="notes")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false, referencedColumnName = "id")
    private Customer customer;

    @Column(name="content")
    private String content;

    @Column(name="author")
    private String author;

    @Column(name="is_active", nullable = false)
    private boolean isActive=true;
}
