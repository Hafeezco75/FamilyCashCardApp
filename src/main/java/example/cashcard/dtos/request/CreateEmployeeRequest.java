package example.cashcard.dtos.request;

import lombok.*;

@Getter
@Setter
@ToString
public class CreateEmployeeRequest {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
}
