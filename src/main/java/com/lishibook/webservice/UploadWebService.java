package com.lishibook.webservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lishibook.exception.PermissionException;
import com.lishibook.output.SuccessOutput;
import com.lishibook.output.UploadResult;
import com.lishibook.output.UploadSuccessResult;
import com.lishibook.web.BaseController;

@Controller
@RequestMapping("/ws")
public class UploadWebService  extends BaseController{
	private static Logger logger = LoggerFactory
			.getLogger(UploadWebService.class);
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public UploadResult upload(@RequestParam("fileupload") MultipartFile file) throws PermissionException, IllegalStateException, IOException {
		logger.debug("Enter UploadWebService.upload");
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}
		
		UploadSuccessResult result = new UploadSuccessResult();
		
		List<SuccessOutput> list = new ArrayList<SuccessOutput>();
		SuccessOutput output = new SuccessOutput();
		
		output.setName(file.getOriginalFilename());
		output.setSize(file.getSize());
		output.setUrl("/lishibook/pictures/zhugeliang.jpg");
		
		list.add(output);
		result.setFiles(list);
		
		return result;
	}
}
