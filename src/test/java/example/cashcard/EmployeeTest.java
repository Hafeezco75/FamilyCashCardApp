package example.cashcard;

import example.cashcard.dtos.request.CreateEmployeeRequest;
import example.cashcard.dtos.request.DeleteEmployeeRequest;
import example.cashcard.dtos.response.CreateEmployeeResponse;
import example.cashcard.dtos.response.DeleteEmployeeResponse;
import example.cashcard.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(EmployeeParameterResolver.class)
@SpringBootTest
//@AllArgsConstructor
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testThatEmployeeCanBeCreated() {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmployeeId(2L);
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john@doe.com");
        request.setTitle("Asset Manager");
        CreateEmployeeResponse response = employeeService.createEmployee(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("New Employee created successfully");
    }


    @Test
    public void testThatEmployeeCanBeDeleted(DeleteEmployeeRequest deleteRequest) {
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest();
        deleteEmployeeRequest.setEmployeeId(3L);
        DeleteEmployeeResponse employeeResponse = employeeService.deleteEmployee(deleteEmployeeRequest);
        assertNotNull(employeeResponse);
        assertThat(employeeResponse.getEmployeeId()).isNotNull();
        assertThat(employeeResponse.getMessage()).isEqualTo("Employee deleted successfully");
    }

}
