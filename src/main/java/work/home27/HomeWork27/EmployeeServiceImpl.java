package work.home27.HomeWork27;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            throw new EmployAlreadyAddException();
        }
        employeeList.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundExceptions();
    }

    @Override
    public Employee findEmployee (String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);

        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.get(employee.getFullName());
        }
        throw new EmployAlreadyAddException();
    }


    @Override
    public Collection<Employee> findAllEmployee() {
        return Collections.unmodifiableCollection(employeeList.values());
    }

}
