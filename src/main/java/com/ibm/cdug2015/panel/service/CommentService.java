package com.ibm.cdug2015.panel.service;

import org.springframework.stereotype.Service;

import com.ibm.cdug2015.panel.domain.Comment;

@Service
public class CommentService {
	private static String COMMENT_COLLECTION = "comment";

	public void saveComment(Comment comment) {

	}

	public Comment findCommentsByUserName(String userName) {
		return null;
	}
}
