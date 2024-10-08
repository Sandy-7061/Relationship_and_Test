package sandeep.relationship.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Student_tbl",
uniqueConstraints = @UniqueConstraint(
        name = "email_unique",
        columnNames = "email_address"
))
public class studentEntity {

    @Id
    @SequenceGenerator(
            name = "Sequence_sequence",
            sequenceName = "Sequence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "Sequence_sequence")
    private long studentId;
    private String firstname;
    private String lastname;

    @Column(name = "email_address",
            nullable = false )
    private String email;

    @Embedded
    private Guardian guardian;
}
