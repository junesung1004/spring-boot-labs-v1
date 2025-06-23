package com.example.ch4labs.repository;

import com.example.ch4labs.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
