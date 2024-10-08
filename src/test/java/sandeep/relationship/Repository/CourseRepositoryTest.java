package sandeep.relationship.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sandeep.relationship.Entity.OneToMany.Teacher;
import sandeep.relationship.Entity.OneToOne.Course;
import sandeep.relationship.Entity.OneToOne.CourseMaterial;
import sandeep.relationship.Entity.studentEntity;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;


    @Test
    public void printalll(){
        List<Course> courses = repository.findAll();
        System.out.println("All data " + courses);

    }

    @Test
    public void savecoursewithTeacher(){

        Teacher teacher = Teacher.builder()
                .first_name("Badnam")
                .last_name("Aurat")
                .build();
        Course course = Course.builder()
                .title("Badnami")
                .credit(60)
                .teacher(teacher)
                .build();
        repository.save(course);

    }

    @Test
    public void addcoursebymanytomany(){

        Teacher teacher = Teacher.builder()
                .first_name("Rakhi")
                .last_name("sikahr")
                .build();

        studentEntity student = studentEntity.builder()
                .firstname("Shivani")
                .lastname("Gupta")
                .email("rakchas.com")
                .build();

        Course course = Course.builder()
                .credit(8)
                .title("Computer")
                .teacher(teacher)
                .build();

        course.addstudent(student);
        repository.save(course);
    }
}