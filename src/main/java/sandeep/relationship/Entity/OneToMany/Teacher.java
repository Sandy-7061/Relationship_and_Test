package sandeep.relationship.Entity.OneToMany;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sandeep.relationship.Entity.OneToOne.Course;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_Seuence_generator",
            sequenceName = "teacher_Seuence_generator",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "teacher_Seuence_generator")
    private long teacher_id;

    @Column(name = "teacher_first_name")
    private String first_name;

    @Column(name = "teacher_last_name")
    private String last_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacherid",
            referencedColumnName = "teacher_id"
    )
    private List<Course> courses;

}
