package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private AdministratorRepository repo;
	
	@RequestMapping("/execute")
	public String execute() {
		Administrator admini = new Administrator();
		
		admini = repo.findByMailAddressAndPassword("asa@com", "1234567");
		
		System.out.println(admini);
		
		return "/administrator/finished";
	}
}
