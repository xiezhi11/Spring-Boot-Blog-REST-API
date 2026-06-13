package com.sopromadze.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class PostRequest {

	@NotBlank
	@Size(min = 10)
	private String title;

	@NotBlank
	@Size(min = 50)
	private String body;

	@NotNull
	private Long categoryId;

	private List<String> tags;

	public List<String> getTags() {

		if (tags == null) {
			return Collections.emptyList();
		}

		List<String> cleaned = new ArrayList<>(tags.size());
		for (String tag : tags) {
			if (tag == null) {
				continue;
			}
			String trimmed = tag.trim();
			if (!trimmed.isEmpty()) {
				cleaned.add(trimmed);
			}
		}
		return cleaned;
	}

	public void setTags(List<String> tags) {

		if (tags == null) {
			this.tags = null;
		} else {
			this.tags = Collections.unmodifiableList(tags);
		}
	}
}
