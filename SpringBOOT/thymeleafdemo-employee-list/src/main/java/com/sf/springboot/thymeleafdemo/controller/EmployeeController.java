package com.sf.springboot.thymeleafdemo.controller;

import com.sf.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    public List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        Employee emp1 = new Employee(1, "Abi", "V", "abi@gmail.com");
        Employee emp2 = new Employee(2, "Sri", "Nithi", "sri@gmail.com");
        Employee emp3 = new Employee(3, "Priya", "Dharshini", "priya@gmail.com");

        theEmployees=new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        theModel.addAttribute("employees",theEmployees);

        return "list-employees";
    }
}
