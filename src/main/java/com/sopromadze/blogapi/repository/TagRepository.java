package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
	// Case-insensitive lookup so "Java" and "java" resolve to the same tag,
	// independent of the database's collation (e.g. case-sensitive H2 vs. case-insensitive MySQL).
	Tag findByNameIgnoreCase(String name);
}
