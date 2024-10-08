package sandeep.relationship.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sandeep.relationship.Entity.studentEntity;


import java.util.List;

@Repository
public interface Student_repository extends JpaRepository<studentEntity,Long> {

     public List<studentEntity> findByFirstname(String firstname);
     public List<studentEntity> findByFirstnameContaining(String name);
     public List<studentEntity> findByGuardian_Name(String guardianName);
     public List<studentEntity> findByFirstnameAndLastname(String firstname, String lastname);


    @Query("select s from studentEntity s where s.email = ?1")
    public List<studentEntity> findByEmail(String email);

    @Query("select s.firstname from studentEntity s where s.email= ?1")
    public String findfirstnameByemail(String email);


    @Query(
            value = "select * from Student_tbl s where s.email_address = ?1",
            nativeQuery = true
    )
    public studentEntity findstudentbyemailnativenamedparameter(String email);

    @Modifying
    @Transactional
    @Query(
            value = "update pagal@gmail.com set firstname = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updatefirstnamebyemail(String firstname,String Email);

    @Modifying
    @Transactional
    @Query(
            value = "delete from Student_tbl where email_address = ?1",
            nativeQuery = true
    )
    public int deletebyemail(String email);
}
