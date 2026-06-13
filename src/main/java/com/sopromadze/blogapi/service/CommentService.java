package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.CommentRequest;
import com.sopromadze.blogapi.payload.CommentResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.security.UserPrincipal;

public interface CommentService {

	PagedResponse<CommentResponse> getAllComments(Long postId, int page, int size);

	CommentResponse addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	CommentResponse getComment(Long postId, Long id);

	CommentResponse updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
