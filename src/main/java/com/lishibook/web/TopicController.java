package com.lishibook.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lishibook.entity.ResourceTopic;
import com.lishibook.exception.NoSuchPageException;
import com.lishibook.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController{
	
	private static Logger logger = LoggerFactory
			.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/{topicId}")
	public ModelAndView showTopic(@PathVariable("topicId") int topicId) throws NoSuchPageException{

		logger.debug("Enter TopicController.showTopic");

		ModelAndView modelView = new ModelAndView();

		modelView.setViewName("topic");
		ResourceTopic topic = topicService.getTopicByID(topicId);

		if (topic == null) {
			throw new NoSuchPageException();
		}
		modelView.addObject("topic", topic);

		logger.debug("Exit TopicController.showTopic");
		return modelView;
	}
	
}
