package com.ibm.cdug2015.panel.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.cdug2015.panel.domain.Comment;
import com.ibm.cdug2015.panel.service.CommentService;

@Controller
@RequestMapping("/mongo")
public class MongoRest {

	private static Logger logger = Logger.getLogger(MongoRest.class.getName());

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody Comment comment) {
		commentService.saveComment(comment);
		logger.info("saved comment:" + comment);
		return "OK";
	}

	@RequestMapping("find/{userName}")
	@ResponseBody
	public String findComment(@PathVariable String userName) {
		logger.info("findComment by userName:" + userName);
		Comment comment = commentService.findCommentsByUserName(userName);
		if (comment == null)
			return "no result found!";
		logger.info("Found comment:" + comment);
		return comment.toString();
	}

	@RequestMapping("find")
	@ResponseBody
	public String findComments() {
		return "none found";
	}

}
