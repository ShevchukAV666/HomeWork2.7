package work.home27.HomeWork27;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee (String firsName, String lastName);

    Employee removeEmployee(String firsName, String lastName);

    Employee findEmployee (String firsName, String lastName);


    Collection<Employee> findAllEmployee();
}

