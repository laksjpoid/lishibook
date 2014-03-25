package com.lishibook.restservice;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lishibook.entity.Resource;
import com.lishibook.entity.ResourceFocus;
import com.lishibook.exception.PermissionException;
import com.lishibook.output.BaseResult;
import com.lishibook.service.ResourceFocusService;
import com.lishibook.service.ResourceService;
import com.lishibook.web.BaseController;

@Controller
@RequestMapping("/rs/resource")
public class ResourceRestService extends BaseController {

	private static Logger logger = LoggerFactory
			.getLogger(ResourceRestService.class);

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ResourceFocusService resourceFocusService;

	/**
	 * 获取某个资源的关注资源列表
	 * 
	 * @param resourceid
	 * @return
	 * @throws PermissionException
	 */
	@RequestMapping(value = "/{resourceId}/focuses", method = RequestMethod.GET)
	@ResponseBody
	public List<Resource> getFocuses(@PathVariable("resourceId") int resourceid)
			throws PermissionException {

		return resourceFocusService.getFocuses(resourceid);
	}

	/**
	 * 为某个资源增加<strong>一个</strong>关注
	 * @param resourceid
	 * @param focusrid
	 * @param desc
	 * @return
	 * @throws PermissionException
	 */
	@RequestMapping(value = "/{resourceId}/addfocus", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addfocus(@PathVariable("resourceId") int resourceid,
			@RequestParam("focusrid") int focusrid,
			@RequestParam("desc") String desc) throws PermissionException{
		
		logger.debug("Enter ResourceRestService.addfocus");
		
		BaseResult result = new BaseResult();
		Subject currentUser = SecurityUtils.getSubject();

		// 只有管理员具有添加资源的权限
		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}
		ResourceFocus resourceFocus = new ResourceFocus();
		resourceFocus.setFromrid(resourceid);
		resourceFocus.setTorid(focusrid);
		resourceFocus.setDesc(desc);
		
		int i = resourceFocusService.insert(resourceFocus);
		if(i == 1){
			result.setStatus(1);
			result.setMessage("添加成功");
		}else{
			result.setStatus(-1);
			result.setMessage("添加失败");
		}
		
		logger.debug("Exit ResourceRestService.addfocus");
		return result;
	}
	
	/**
	 * 删除一个资源关注
	 * @param focusId
	 * @return
	 * @throws PermissionException
	 */
	@RequestMapping(value = "/removefocus/{focusId}/", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult removefocus(@PathVariable("focusId") int focusId) throws PermissionException{
		
		logger.debug("Enter ResourceRestService.removefocus");
		
		BaseResult result = new BaseResult();
		Subject currentUser = SecurityUtils.getSubject();

		// 只有管理员具有删除资源的权限
		if (!currentUser.hasRole("admin")) {
			throw new PermissionException();
		}
		int i = resourceFocusService.deleteFocus(focusId);
		
		if(i == 1){
			result.setStatus(1);
			result.setMessage("删除成功");
		}else{
			result.setStatus(-1);
			result.setMessage("删除失败");
		}
		
		logger.debug("Exit ResourceRestService.removefocus");
		return result;
	}
}