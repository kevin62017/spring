package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leonchen.model.HouseBean;

@Controller
public class JsonCreateController {
 
	@RequestMapping(path = "/houseBeanJson", method = RequestMethod.GET)
	public String processJsonAction(ModelMap model) {
		HouseBean houseBaen = new HouseBean();
		houseBaen.setHouseid(12345);
		houseBaen.setHousename("Happy House");
		
		model.addAttribute("houseBaen", houseBaen);
		
		return "myHouse";
	}
}
