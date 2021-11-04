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
		Employee employee = new Employee();
		employee.setId(25);
		employee.setName("工藤新一");
		emp.update(employee);
		
		return "/administrator/finished";
	}
}
