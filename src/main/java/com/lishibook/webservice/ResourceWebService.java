package com.lishibook.webservice;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import com.lishibook.exception.InternalException;
import com.lishibook.exception.PermissionException;
import com.lishibook.output.BaseResult;
import com.lishibook.output.ResourceInfoOutput;
import com.lishibook.service.ResourceFocusService;
import com.lishibook.service.ResourceService;
import com.lishibook.web.BaseController;

@Controller
@RequestMapping("/ws/resource")
public class ResourceWebService extends BaseController {

	private static Logger logger = LoggerFactory
			.getLogger(ResourceWebService.class);

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
	/*
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Resource> search(@RequestParam("key")String key) throws InternalException{
		
		try {
			String urlKey = new String(key.getBytes("ISO-8859-1"),"UTF-8");
			return resourceService.search(urlKey);
		} catch (UnsupportedEncodingException e) {
			throw new InternalException();
		}
	}
	*/
	/**
	 * 查询的时候根据当前所在资源页面，用于获取是否是当前资源好友等信息
	 * @param key
	 * @param resourceId
	 * @return
	 * @throws InternalException
	 */
	@RequestMapping(value = "/search/{fromid}", method = RequestMethod.GET)
	@ResponseBody
	public List<ResourceInfoOutput> searchResources(@RequestParam("key")String key, @PathVariable("fromid") int resourceId) throws InternalException{
		
		List<ResourceInfoOutput> info = new ArrayList<ResourceInfoOutput>();
		
		try {
			List<Resource> list = new ArrayList<Resource>();
			String urlKey = new String(key.getBytes("ISO-8859-1"),"UTF-8");
			list = resourceService.search(urlKey);
			
			for(Resource resource: list){
				ResourceInfoOutput output = new ResourceInfoOutput();
				output.setId(resource.getId());
				output.setIconurl(resource.getIconurl());
				output.setDescription(resource.getDescription());
				output.setName(resource.getName());
				output.setViews(resource.getViews());
				if(resourceFocusService.exists(resourceId, resource.getId())){
					output.setIsfocus(true);
				}else{
					output.setIsfocus(false);
				}
				info.add(output);
			}
		} catch (UnsupportedEncodingException e) {
			throw new InternalException();
		}
		
		return info;
	}
}
