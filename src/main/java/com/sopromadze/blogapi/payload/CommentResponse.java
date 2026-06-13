package com.sopromadze.blogapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Response DTO for comment queries.
 * Includes author basic info and creation time so callers do not need a separate user lookup.
 * Sensitive user fields (password, roles, address, phone, etc.) are intentionally excluded.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

	private Long id;

	private String name;

	private String email;

	private String body;

	private Instant createdAt;

	/**
	 * Safe author summary — only public-facing identity fields, no sensitive data.
	 */
	private UserSummary author;
}
