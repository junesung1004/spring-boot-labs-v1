package com.example.ch4labs.repository;

import com.example.ch4labs.domain.Reviews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    Page<Reviews> findByTitleContaining(String keyword, Pageable pageable);
}
