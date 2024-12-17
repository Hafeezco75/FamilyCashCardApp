package example.cashcard.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeleteEmployeeResponse {
    private Long employeeId;
    private String message;
}
