package ru.skypro.collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final List<Employee> employees = new  ArrayList<>(10);

    public Employee add(String firstName, String lastName)  {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.isNull(employees.get(i))) {
                employees.set(i, new Employee(firstName, lastName));
                break;
            } else if (i >= 11) {
                throw new EmployeeStorageIsFullException();
            } else if (Objects.equals(employees.get(i), employees)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), employee)) {
                employees.remove(i);
            }
        }
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), employee)) {
                return employee;
            }
        }
        throw new EmployeeNotFound();
    }
}
