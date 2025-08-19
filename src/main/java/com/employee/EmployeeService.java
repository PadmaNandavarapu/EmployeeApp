package com.employee;


import com.employee.modelEmployee;
import com.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<modelEmployee> getAll() {
        return repo.findAll();
    }

    public modelEmployee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public modelEmployee create(modelEmployee emp) {
        return repo.save(emp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
