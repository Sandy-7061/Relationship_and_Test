package sandeep.relationship.Entity.OneToOne;

import jakarta.persistence.*;
import lombok.*;
import sandeep.relationship.Entity.OneToMany.Teacher;
import sandeep.relationship.Entity.studentEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courseMaterial")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private long course_id;
    private String title;
    private int credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "tacher_Ki_id",
            referencedColumnName = "teacher_id"
    )
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "joined_table",
            joinColumns = @JoinColumn(
                    name = "course_Id",
                    referencedColumnName = "course_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<studentEntity> studentEntityList;

    public void addstudent(studentEntity student) {
        if (studentEntityList == null) {

            studentEntityList = new ArrayList<>();
        }
        studentEntityList.add(student);
    }
}

