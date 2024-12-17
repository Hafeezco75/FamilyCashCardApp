package example.cashcard;

import example.cashcard.dtos.request.CreateEmployeeRequest;
import example.cashcard.dtos.request.DeleteEmployeeRequest;
import example.cashcard.dtos.response.CreateEmployeeResponse;
import example.cashcard.dtos.response.DeleteEmployeeResponse;
import example.cashcard.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AllArgsConstructor
public class CardCashJsonTest {

    private EmployeeService employeeService;


    @ParameterizedTest
    public void testThatEmployeeCanBeCreated() {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john@doe.com");
        request.setTitle("Asset Manager");
        CreateEmployeeResponse response = employeeService.createEmployee(request);
        assertNotNull(response);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Employee created successfully");
    }


    @Test
    public void testThatEmployeeCanBeDeleted(DeleteEmployeeRequest deleteRequest) {
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest();
        deleteEmployeeRequest.setEmployeeId(deleteRequest.getEmployeeId());
        DeleteEmployeeResponse employeeResponse = employeeService.deleteEmployee(deleteEmployeeRequest);
        assertNotNull(employeeResponse);
        assertThat(employeeResponse.getEmployeeId()).isNotNull();
        assertThat(employeeResponse.getMessage()).isEqualTo("Employee deleted successfully");
    }

}
