package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {
	@RequestMapping(path = "/response/responseBodyMsg.controller", method = RequestMethod.GET)
	public @ResponseBody String processResponseBodyAction() {
		return "This is a ResponseBody Message";
	}

	@RequestMapping(path="/response/image.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void processResponseImagesAsByteArray(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}
}
