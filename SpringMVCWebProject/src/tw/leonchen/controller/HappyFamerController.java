package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HappyFamerController {
	
	@RequestMapping(path = "/happyFarmerAction.controller", method = RequestMethod.GET)
	public String processFarmerAction() {
		return "happyFarmer";
	}
   
	@RequestMapping(path = "/farmer.controller", method = RequestMethod.GET)
	public String processPlant(Model model) {
		model.addAttribute("name", "judy");
		return "result";
	}
	
	@RequestMapping(path = "/myfarmer.controller", method = RequestMethod.POST)
	public String processFuturePlant(@RequestParam(name = "myfarmer") String farmer, Model model) {
		model.addAttribute("name", farmer);
		return "result";
	}
}
