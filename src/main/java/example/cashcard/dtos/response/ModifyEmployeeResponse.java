package example.cashcard.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModifyEmployeeResponse {
    private String Employee_Id;
    private String message;
}
