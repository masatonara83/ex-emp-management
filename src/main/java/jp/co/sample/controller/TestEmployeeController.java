package jp.co.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

@Controller
@RequestMapping("/test02")
public class TestEmployeeController {

	@Autowired
	private EmployeeRepository emp;
	
	@RequestMapping("/execute")
	public String excute() {
		Employee employees = new Employee();
		employees = emp.load(25);
		
		System.out.println(employees);
		
		employees.setName("工藤新一");
		employees.setId(25);
		System.out.println(employees);
		
		return "/administrator/finished";
	}
}
