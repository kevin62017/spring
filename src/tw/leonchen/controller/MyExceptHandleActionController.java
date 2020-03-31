package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyExceptHandleActionController {

	@RequestMapping(path = "/except.controller", method = RequestMethod.GET)
	public void processAction() throws Exception {
		//throw new Exception();
		throw new MyOwnException("hi");
	}
}
