package sandeep.relationship.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandeep.relationship.Entity.OneToOne.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
