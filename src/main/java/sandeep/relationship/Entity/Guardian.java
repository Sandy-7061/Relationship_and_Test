package sandeep.relationship.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "Guardian_name")),
        @AttributeOverride(name = "email", column = @Column(name = "Guardian_Email")),
        @AttributeOverride(name = "mobile", column = @Column(name = "Guardian_Mobile"))
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}