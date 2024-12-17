package example.cashcard.services;

import example.cashcard.data.models.Employee;
import example.cashcard.dtos.request.CreateEmployeeRequest;
import example.cashcard.dtos.request.DeleteEmployeeRequest;
import example.cashcard.dtos.request.ModifyEmployeeRequest;
import example.cashcard.dtos.response.CreateEmployeeResponse;
import example.cashcard.dtos.response.DeleteEmployeeResponse;
import example.cashcard.dtos.response.ModifyEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    CreateEmployeeResponse createEmployee(CreateEmployeeRequest createEmployeeRequest);

    ModifyEmployeeResponse modifyEmployee(ModifyEmployeeRequest modifyEmployeeRequest);

    List<Employee> getAllEmployees();

    DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteRequest);
}
