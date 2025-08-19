package com.employee;


import com.employee.modelEmployee;
import com.employee.EmployeeRepository;
import com.employee.EmployeeService;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    @Test
    void testGetAllEmployees() {
        EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
        Mockito.when(repo.findAll()).thenReturn(Collections.singletonList(new modelEmployee("Padma", "QA Engineer")));

        EmployeeService service = new EmployeeService(repo);
        assertEquals(1, service.getAll().size());
        assertEquals("Padma", service.getAll().get(0).getName());
    }
}

