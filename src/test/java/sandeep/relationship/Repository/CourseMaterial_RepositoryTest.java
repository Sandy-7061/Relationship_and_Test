package sandeep.relationship.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sandeep.relationship.Entity.OneToOne.Course;
import sandeep.relationship.Entity.OneToOne.CourseMaterial;

import java.util.List;


@SpringBootTest
class CourseMaterial_RepositoryTest {

    @Autowired    public CourseMaterial_Repository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("Operationg System")
                .credit(7)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.operating.com")
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void findalldata(){
        List<CourseMaterial> data = repository.findAll();
        System.out.println("Course Data \n"+data);
    }

}