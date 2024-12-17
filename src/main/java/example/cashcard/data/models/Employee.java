package example.cashcard.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;


}
