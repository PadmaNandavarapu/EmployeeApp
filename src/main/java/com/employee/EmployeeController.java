package com.employee;



import com.employee.modelEmployee;
import com.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<modelEmployee> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public modelEmployee getEmployee(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public modelEmployee addEmployee(@RequestBody modelEmployee employee) {
        return service.create(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }
}

