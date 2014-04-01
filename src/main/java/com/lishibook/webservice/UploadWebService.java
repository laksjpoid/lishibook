package com.lishibook.webservice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

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
	
	public static String PICTURE_DIR = "D:\\Workspaces\\lishibook\\lishibook\\src\\main\\webapp\\pictures\\";
	
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

		String dirName = getDirName();
		String path = PICTURE_DIR + dirName;
		File pathFile = new File(path);
		if(!pathFile.exists() || !pathFile.isDirectory()){
			pathFile.mkdirs();
		}
		
		//生成文件名
		String fileName = getPath(file.getOriginalFilename());
		
		File f = new File(path + "\\" + fileName);
		while(f.exists()){
			fileName = getPath(file.getOriginalFilename());
			f = new File(path + "\\" + fileName);
		}
		
		//写入文件
		InputStream input = file.getInputStream();
		BufferedImage srcImage = ImageIO.read(input);
		int originWidth = srcImage.getWidth();
		int originHeight = srcImage.getHeight();
		
		int destWidth = 100;
		int destHeight = 100;//默认高度为 100 px
		
		//处理并保存图片
		if((originHeight < destHeight) && (originWidth < destWidth)){
			//原图长宽都小于 100px，则维持不变
			destWidth = originWidth;
			destHeight = originHeight;
		}else if(originHeight > originWidth){
			//高度为 100，宽度比100 小
			destWidth = originWidth*destHeight/originHeight;
		}else{
			//宽度为100， 高度比100小
			destHeight = originHeight*destWidth/originWidth;
		}
		BufferedImage destImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
		destImage.getGraphics().drawImage(srcImage, 0, 0, destWidth, destHeight, null);
		ImageIO.write(destImage, "png", f);
		
		output.setName(file.getOriginalFilename());
		output.setSize(file.getSize());
		
		String url = "/lishibook/pictures/" + dirName + "/" + fileName;
		output.setUrl(url);
		output.setThumbnailUrl(url);
		
		list.add(output);
		result.setFiles(list);
		
		return result;
	}
	
	//生成一个文件名
	private String getPath(String originalName){
		//文件名的第一部分：时间戳
		long part1 = new Date().getTime();
		
		//第二部分：随机数
		Random r = new Random();
		int part2 = r.nextInt(100000);
		
		String[] temp = originalName.split("\\.");
		String suffix = temp[temp.length-1];
		
		return part1 + "" + part2 + "" + "." + suffix;
	}
	
	//生成一个日期字符串，用作目录名字
	private String getDirName(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		return String.format("%04d%02d%02d", year, month, day);
	}
	
	public static void main(String[] args){
		String a = "a.jpg";
		System.out.println(new UploadWebService().getPath(a));
		System.out.println(new UploadWebService().getDirName());
	}
}
