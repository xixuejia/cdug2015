package com.ibm.cdug2015.panel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ibm.cdug2015.panel.domain.Comment;

@Service
public class CommentService {
	private static String COMMENT_COLLECTION = "comment";

	@Autowired
	MongoTemplate mongoTemplate;

	public void saveComment(Comment comment) {
		mongoTemplate.save(comment, COMMENT_COLLECTION);
	}

	public Comment findCommentsByUserName(String userName) {
		return mongoTemplate.findOne(
				new Query(Criteria.where("userName").is(userName)),
				Comment.class);

	}
}
