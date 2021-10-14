package lphung.dxc.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lphung.dxc.vn.entity.PolicyEntity;
import lphung.dxc.vn.service.IPolicyService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private IPolicyService policyService;

	@GetMapping
	public String homePage(ModelMap map) {
		
		List<PolicyEntity> list=policyService.findAll();
		
		map.addAttribute("listPolicy", list);
	
		return "home";
	}

}
