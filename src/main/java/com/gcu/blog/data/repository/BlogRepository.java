package com.gcu.blog.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.blog.data.entity.BlogEntity;

public interface BlogRepository extends CrudRepository <BlogEntity, Long> {
}
