package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.leonchen.model.Account;
import tw.leonchen.model.AccountService;

@Controller
@SessionAttributes(names = {"name", "pwd", "errors"})
public class CheckLoginSystem {
	
	private AccountService aService;

	@Autowired
	public CheckLoginSystem(AccountService aService) {
		this.aService = aService;
	}
	
	@RequestMapping(path = "/preLoginAction.controller", method = RequestMethod.GET)
	public String processAction() {
		return "loginSystem";
	}

	@RequestMapping(path = "/checkLogin.controller", method = RequestMethod.POST)
	public String processLoginSystemAction(@RequestParam("username") String username, @RequestParam("userpwd") String userpwd, Model model) {
        
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		if(username==null || username.length()==0) {
			errors.put("name", "name is required.");
        }
		
		if(userpwd==null || userpwd.length()==0) {
			errors.put("pwd", "password is required.");
        }
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		model.addAttribute("user", username);
		model.addAttribute("pwd", userpwd);
		
		boolean status = aService.checkLogin(new Account(username, userpwd));
		
		if(status) {
			return "loginSuccess";
		}
		
		errors.put("msg", "username or password is not correct.");		
		
		return "loginSystem";
	}
}









