package com.sopromadze.blogapi.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sopromadze.blogapi.model.Comment;
import com.sopromadze.blogapi.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(Include.NON_NULL)
public class CommentResponse extends DateAuditPayload {
	private Long id;

	private String name;

	private String body;

	private UserSummary author;

	public static CommentResponse from(Comment comment) {
		CommentResponse response = new CommentResponse();
		response.setId(comment.getId());
		response.setName(comment.getName());
		response.setBody(comment.getBody());
		response.setCreatedAt(comment.getCreatedAt());
		response.setUpdatedAt(comment.getUpdatedAt());

		User user = comment.getUser();
		if (user != null) {
			response.setAuthor(new UserSummary(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName()));
		}

		return response;
	}
}
