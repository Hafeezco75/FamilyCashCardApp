package example.cashcard.services;

import example.cashcard.data.models.Employee;
import example.cashcard.data.repositories.EmployeeRepository;
import example.cashcard.dtos.request.CreateEmployeeRequest;
import example.cashcard.dtos.request.DeleteEmployeeRequest;
import example.cashcard.dtos.request.ModifyEmployeeRequest;
import example.cashcard.dtos.response.CreateEmployeeResponse;
import example.cashcard.dtos.response.DeleteEmployeeResponse;
import example.cashcard.dtos.response.ModifyEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest createRequest) {
        //findEmployee(createRequest.getEmployeeId());
        Employee employee = new Employee();
        employee.setEmployeeId(createRequest.getEmployeeId());
        employee.setFirstName(createRequest.getFirstName());
        employee.setLastName(createRequest.getLastName());
        employee.setEmail(createRequest.getEmail());
        employee.setTitle(createRequest.getTitle());
        employeeRepository.save(employee);

        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        createEmployeeResponse.setMessage("New Employee created successfully");
        return createEmployeeResponse;
    }

    private void findEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee does not exist"));
        employeeRepository.save(employee);
    }

    @Override
    public ModifyEmployeeResponse modifyEmployee(ModifyEmployeeRequest modifyEmployeeRequest){
        Employee employee = employeeRepository.findById(modifyEmployeeRequest.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        assert employee != null;
        employee.setEmployeeId(modifyEmployeeRequest.getEmployeeId());
        employee.setFirstName(modifyEmployeeRequest.getFirstName());
        employee.setLastName(modifyEmployeeRequest.getLastName());
        employee.setEmail(modifyEmployeeRequest.getEmail());
        employee.setTitle(modifyEmployeeRequest.getTitle());
        employeeRepository.save(employee);


        ModifyEmployeeResponse modifyResponse = new ModifyEmployeeResponse();
        modifyResponse.setMessage("Employee details modified successfully");
        return modifyResponse;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteRequest){
        Employee employee = new Employee();
        findEmployee(deleteRequest.getEmployeeId());
        employeeRepository.delete(employee);

        DeleteEmployeeResponse deleteResponse = new DeleteEmployeeResponse();
        deleteResponse.setMessage("Employee details deleted successfully");
        return deleteResponse;
    }
}
