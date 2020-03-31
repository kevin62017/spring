package tw.leonchen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;

@Controller
public class UploadFileController {
   	
	private PictureService pService;
     
	@Autowired
	public UploadFileController(PictureService pService) {
		this.pService = pService;
	}

	@RequestMapping(path = "/preUploadFile.controller", method = RequestMethod.GET)
	public String processAction() {
		return "FileUpload";
	}

	@RequestMapping(path = "/uploadFile.controller", method = RequestMethod.POST)
	public ResponseEntity<byte[]> processFileUpload(@RequestParam("myFiles") MultipartFile mFile,
			HttpServletRequest request) throws Exception {
		String fileName = mFile.getOriginalFilename();
		String savePath = request.getServletContext().getRealPath("/") + "FileTemp\\" + fileName;
		System.out.println("savePath:" + savePath);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		File saveFile = new File(savePath);
		mFile.transferTo(saveFile);

		if (fileName != null && fileName.length() != 0) {
			savePicture(fileName, savePath);
		}

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
	}

	private void savePicture(String fileName, String savePath) {
		try {
			Picture picture = new Picture();
			picture.setFilename(fileName);

			InputStream is1 = new FileInputStream(savePath);
			byte[] b = new byte[is1.available()];
			is1.read(b);
			is1.close();
			
			picture.setPicture(b);
			
			pService.insert(picture);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


















