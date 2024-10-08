package sandeep.relationship.Repository.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandeep.relationship.Entity.OneToMany.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
