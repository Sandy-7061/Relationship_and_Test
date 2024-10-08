package sandeep.relationship.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandeep.relationship.Entity.OneToOne.CourseMaterial;

@Repository
public interface CourseMaterial_Repository extends JpaRepository<CourseMaterial,Long> {
}
