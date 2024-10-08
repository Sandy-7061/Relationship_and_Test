package sandeep.relationship.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sandeep.relationship.Entity.Guardian;
import sandeep.relationship.Entity.studentEntity;

import java.util.List;


@SpringBootTest
class Student_repositoryTest {

    @Autowired
    private Student_repository studentRepository;

    @Test
    public void saveStudent(){
        studentEntity student = studentEntity.builder()
                .email("sandeepkush880@gmail.com")
                .firstname("Sandeep")
//                .guardianEmail("Sachinkush7024@gmail.com")
//                .guardianMobile("7024520740")
//                .guardianName("Pata nahi")
                .lastname("KUShwaha")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void savestudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Fatakha")
                .mobile("78416189654")
                .email("fatakha@gmail.com")
                .build();

        studentEntity student = studentEntity.builder()
                .firstname("Pagaliya")
                .email("pagal@gmail.com")
                .lastname("Lal")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudent() {
        List<studentEntity> studentEntities = studentRepository.findAll();

        // Print table header
        System.out.println(String.format("%-10s %-10s %-25s %-15s %-25s %-15s",
                "First Name", "Last Name", "Email",
                "Guardian Name", "Guardian Email", "Guardian Mobile"));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Print each student in a tabular format
        for (studentEntity student : studentEntities) {
            String guardianName = student.getGuardian() != null ? student.getGuardian().getName() : "N/A";
            String guardianEmail = student.getGuardian() != null ? student.getGuardian().getEmail() : "N/A";
            String guardianMobile = student.getGuardian() != null ? student.getGuardian().getMobile() : "N/A";

            System.out.println(String.format("%-10s %-10s %-25s %-15s %-25s %-15s",
                    student.getFirstname(),
                    student.getLastname(),
                    student.getEmail(),
                    guardianName,
                    guardianEmail,
                    guardianMobile));
            System.out.println("-----------------------------------------------------------------------------------------------------");

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }


    @Test
    public void printstudentbyFirstName(){
        List<studentEntity> student_entities = studentRepository.findByFirstname("Rishika");

        System.out.println(student_entities);
    }
    @Test
    public void printstudentbyFirstNameContaining(){
        List<studentEntity> student_entities = studentRepository.findByFirstnameContaining("sh");

        System.out.println(student_entities);
    }
    @Test
    public void printstudentbyGuardianName(){
        List<studentEntity> student_entities = studentRepository.findByGuardian_Name("Fatakha");

        System.out.println(student_entities);
    }
    @Test
    public void printstudentbyfirstNameAndLastname(){
        List<studentEntity> student_entities = studentRepository.findByFirstnameAndLastname("Sandeep","KUShwaha");

        System.out.println(student_entities);
    }

    @Test
    public void printAllStudentEmail() {
        List<studentEntity> studentEntities = studentRepository.findByEmail("sandeepkush880@gmail.com");

        // Print table header
        System.out.println(String.format("%-10s %-10s %-25s %-15s %-25s %-15s",
                "First Name", "Last Name", "Email",
                "Guardian Name", "Guardian Email", "Guardian Mobile"));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Print each student in a tabular format
        for (studentEntity student : studentEntities) {
            String guardianName = student.getGuardian() != null ? student.getGuardian().getName() : "N/A";
            String guardianEmail = student.getGuardian() != null ? student.getGuardian().getEmail() : "N/A";
            String guardianMobile = student.getGuardian() != null ? student.getGuardian().getMobile() : "N/A";

            System.out.println(String.format("%-10s %-10s %-25s %-15s %-25s %-15s",
                    student.getFirstname(),
                    student.getLastname(),
                    student.getEmail(),
                    guardianName,
                    guardianEmail,
                    guardianMobile));
            System.out.println("-----------------------------------------------------------------------------------------------------");

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    @Test
    public void printfirstNameByStudentEmail() {
        String studentEntities = studentRepository.findfirstnameByemail("sandeepkush880@gmail.com");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(studentEntities);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    //Native Query
    @Test
    public void printStudentByNative() {
        // Assuming findstudentbyemailnativenamedparameter returns a list of StudentEntity
        studentEntity studentEntities = studentRepository.findstudentbyemailnativenamedparameter("sandeepkush880@gmail.com");



        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(studentEntities);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    //Native Query
    @Test
    public void updatefirstnamebyemail() {
        // Assuming findstudentbyemailnativenamedparameter returns a list of StudentEntity
        studentRepository.updatefirstnamebyemail("Nandani","pagal@gmail.com");
    }

    //Native Query
    @Test
    public void deletebyemail() {
        // Assuming findstudentbyemailnativenamedparameter returns a list of StudentEntity
        studentRepository.deletebyemail("pagal@gmail.com");
    }

}