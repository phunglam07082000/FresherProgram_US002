package lphung.dxc.vn.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lphung.dxc.vn.entity.PolicyEntity;
import lphung.dxc.vn.service.IPolicyService;

@Controller
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private IPolicyService policyService;

	@GetMapping()
	public String addPage() {

		return "add";
	}

	@GetMapping("/create")
	public String createPage() {

		return "create";
	}

	@GetMapping("/issue")
	public String issuePage() {

		return "issue";
	}

	@PostMapping
	public String addPolicy(@ModelAttribute("policy") PolicyEntity policy, ModelMap map) {

		if (policy.getExpiryDate().equals("") || policy.getExpiryDate().equals("") || policy.getPolicyOwner().equals("")
				|| policy.getEngineNo().equals("") || policy.getChassisNo().equals("")
				|| policy.getVehicleNo().equals("") || policy.getBillingCurrency().equals("")
				|| policy.getSumInsured() < 0 || policy.getRate() < 0) {

			map.addAttribute("mesage", "Error message is displayed.");
			return "add";

		}
		List<PolicyEntity> list = policyService.findAll();

		for (PolicyEntity policyEntity : list) {

			if (policyEntity.getChassisNo().equalsIgnoreCase(policy.getChassisNo())
					|| policyEntity.getEngineNo().equalsIgnoreCase(policy.getEngineNo())) {

				map.addAttribute("mesage", "Add Duplicate Chassis Or Engine");
				return "add";
			}

		}

		if (policy.getStartDate().after(policy.getExpiryDate())) {

			map.addAttribute("mesage", "Expiry Date must > Inception Date");
			return "add";
		}

		policy.setStatus("PN");
		boolean check = policyService.createPolicy(policy);

		if (!check) {

			map.addAttribute("mesage", "Create Sucess");
		}

		return "add";

	}

	@PostMapping("/create")
	public String createPolicy(@ModelAttribute("policy") PolicyEntity policy, ModelMap map) {

		if (policy.getExpiryDate().equals("") || policy.getExpiryDate().equals("") || policy.getPolicyOwner().equals("")
				|| policy.getEngineNo().equals("") || policy.getChassisNo().equals("")
				|| policy.getVehicleNo().equals("") || policy.getBillingCurrency().equals("")
				|| policy.getSumInsured() < 0 || policy.getRate() < 0) {

			map.addAttribute("mesage", "Error message is displayed.");
			return "create";

		}
		DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String startDate = simpleDateFormat.format(policy.getStartDate());

		String endDate = simpleDateFormat.format(policy.getExpiryDate());

		try {
			Date date1 = simpleDateFormat.parse(startDate);
			Date date2 = simpleDateFormat.parse(endDate);

			long getDiff = date2.getTime() - date1.getTime();

			long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

			double annualPremium = policy.getSumInsured() * policy.getRate() / 100;
			policy.setAnnualPremium(annualPremium);

			double postedPremium = annualPremium * getDaysDiff / 365;
			policy.setPostedPremium(postedPremium);

			List<PolicyEntity> list = policyService.findAll();

			for (PolicyEntity policyEntity : list) {

				if (policyEntity.getChassisNo().equalsIgnoreCase(policy.getChassisNo())
						|| policyEntity.getEngineNo().equalsIgnoreCase(policy.getEngineNo())) {

					map.addAttribute("mesage", "Add Duplicate Chassis Or Engine");
					return "create";
				}

			}

			if (policy.getStartDate().after(policy.getExpiryDate())) {

				map.addAttribute("mesage", "Expiry Date must > Inception Date");
				return "create";
			}

			policy.setStatus("PN");
			boolean check = policyService.createPolicy(policy);

			if (!check) {

				map.addAttribute("mesage", "Create Sucess");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "create";

	}

	@PostMapping("/issue")
	public String isuePolicy(@ModelAttribute("policy") PolicyEntity policy, ModelMap map) {

		if (policy.getExpiryDate().equals("") || policy.getExpiryDate().equals("") || policy.getPolicyOwner().equals("")
				|| policy.getEngineNo().equals("") || policy.getChassisNo().equals("")
				|| policy.getVehicleNo().equals("") || policy.getBillingCurrency().equals("")
				|| policy.getSumInsured() < 0 || policy.getRate() < 0) {

			map.addAttribute("mesage", "Error message is displayed.");
			return "create";

		}
		DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String startDate = simpleDateFormat.format(policy.getStartDate());

		String endDate = simpleDateFormat.format(policy.getExpiryDate());

		try {
			Date date1 = simpleDateFormat.parse(startDate);
			Date date2 = simpleDateFormat.parse(endDate);

			long getDiff = date2.getTime() - date1.getTime();

			long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

			double annualPremium = policy.getSumInsured() * policy.getRate() / 100;
			policy.setAnnualPremium(annualPremium);

			double postedPremium = annualPremium * getDaysDiff / 365;
			policy.setPostedPremium(postedPremium);

			List<PolicyEntity> list = policyService.findAll();

			for (PolicyEntity policyEntity : list) {

				if (policyEntity.getChassisNo().equalsIgnoreCase(policy.getChassisNo())
						|| policyEntity.getEngineNo().equalsIgnoreCase(policy.getEngineNo())) {

					map.addAttribute("mesage", "Add Duplicate Chassis and Engine");
					return "issue";
				}

			}

			if (policy.getStartDate().after(policy.getExpiryDate())) {

				map.addAttribute("mesage", "Expiry Date must > Inception Date");
				return "issue";
			}

			policy.setStatus("IF");
			boolean check = policyService.createPolicy(policy);

			if (!check) {

				map.addAttribute("mesage",
						"New Motor policy is issued and saved successfully with ‘In force’ status");
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return "issue";

	}

	@GetMapping("/search")
	public String searchPolicy(@RequestParam int id, ModelMap map) {

		try {
			PolicyEntity policy = policyService.findById(id);
			map.addAttribute("policy", policy);

		} catch (Exception e) {
			map.addAttribute("mesage", " Client not exist’ error message.");
		}

		return "detail";
	}

	// Fail
	@PostMapping("/update")
	public String updatePolicy(@RequestParam int id, @RequestParam double rate, @RequestParam double sumInsured,
			ModelMap map) {

		PolicyEntity policy1 = policyService.findById(id);
		policy1.setSumInsured(sumInsured);

		return "home";
	}
}
