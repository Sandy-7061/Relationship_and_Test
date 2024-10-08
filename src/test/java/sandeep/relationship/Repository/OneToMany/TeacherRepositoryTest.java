package sandeep.relationship.Repository.OneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sandeep.relationship.Entity.OneToMany.Teacher;
import sandeep.relationship.Entity.OneToOne.Course;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveteacher(){

        Course course = Course.builder()
                .title("Maths")
                .credit(1)
                .build();

        Course courseHindi = Course.builder()
                .title("Hindi")
                .credit(2)
                .build();

        Course courseEnglish = Course.builder()
                .title("English")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .courses(List.of(course,courseEnglish,courseHindi))
                .first_name("Harshita")
                .last_name("Mittal")
                .build();

        repository.save(teacher);
    }
}