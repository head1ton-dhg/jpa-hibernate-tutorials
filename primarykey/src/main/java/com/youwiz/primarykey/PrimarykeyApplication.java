package com.youwiz.primarykey;

import com.youwiz.primarykey.model.Employee;
import com.youwiz.primarykey.model.EmployeeIdentity;
import com.youwiz.primarykey.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimarykeyApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(PrimarykeyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAllInBatch();

        Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
                "Rajeev Kumar Signh",
                "head1ton@gmail.com",
                "+82-1092090179");

        employeeRepository.save(employee);

        employeeRepository.findById(new EmployeeIdentity("E-123", "D-457"));

        employeeRepository.findByEmployeeIdentityCompanyId("D-457");
    }
}
