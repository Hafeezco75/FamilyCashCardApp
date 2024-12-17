package example.cashcard.web;

import example.cashcard.data.models.Employee;
import example.cashcard.dtos.request.CreateEmployeeRequest;
import example.cashcard.dtos.request.DeleteEmployeeRequest;
import example.cashcard.dtos.request.ModifyEmployeeRequest;
import example.cashcard.dtos.response.CreateEmployeeResponse;
import example.cashcard.dtos.response.DeleteEmployeeResponse;
import example.cashcard.dtos.response.ModifyEmployeeResponse;
import example.cashcard.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@RequestMapping("/v1")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/check")
    public ResponseEntity<Employee> findById(Long requestId) {
        Employee employee = new Employee();
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createEmployee(CreateEmployeeRequest employeeRequest) {
        try {
            CreateEmployeeResponse employeeResponse = employeeService.createEmployee(employeeRequest);
            return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyEmployee(ModifyEmployeeRequest employeeRequest) {
        try {
            ModifyEmployeeResponse employeeResponse = employeeService.modifyEmployee(employeeRequest);
            return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteEmployee(DeleteEmployeeRequest deleteRequest) {
        try {
            DeleteEmployeeResponse deleteResponse = employeeService.deleteEmployee(deleteRequest);
            return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> findAll() {
        try {
            List<Employee> employeeList = employeeService.getAllEmployees();
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
