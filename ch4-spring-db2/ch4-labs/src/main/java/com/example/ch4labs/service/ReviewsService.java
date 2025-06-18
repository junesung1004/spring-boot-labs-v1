package com.example.ch4labs.service;


import com.example.ch4labs.domain.Reviews;
import com.example.ch4labs.dto.*;
import com.example.ch4labs.repository.ReviewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsResponse createPost(ReviewsCreateReqeust reqeust) {
        Reviews reviews = reqeust.toDomain();
        Reviews savedReviews = reviewsRepository.save(reviews);
        return ReviewsResponse.from(savedReviews);
    }

    public List<ReviewsResponse> getAllReviews() {
        return reviewsRepository.findAll().stream().map(ReviewsResponse::from).collect(Collectors.toList());
    }

    public ReviewsResponse getPostById(Long id) {
        return reviewsRepository.findById(id)
                .map(reviews -> ReviewsResponse.from(reviews))
                .orElseThrow(()-> new NoSuchElementException("리뷰가 존재하지 않습니다."));
    }

    public ReviewsResponse updateById(Long id, ReviewsUpdateRequest reqeust) {
        Reviews reviews = reviewsRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("게시글이 존재하지 않습니다."));

        reviews.setTitle(reqeust.getTitle());
        reviews.setContent(reqeust.getContent());
        reviews.setRating(reqeust.getRating());
        reviews.setBookAuthor(reqeust.getBookAuthor());
        reviews.setBookTitle(reqeust.getBookTitle());
        reviews.setAuthor(reqeust.getAuthor());

        return ReviewsResponse.from(reviews);
    }

    public void deleteById(Long id) {
        Reviews reviews = reviewsRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("리뷰가 존재하지 않습니다."));

        reviewsRepository.delete(reviews);

    }

    public ReviewsPageResponse search(ReviewsSearchRequest search) {
        Pageable pageable = PageRequest.of(search.getPage(), search.getSize());
        Page<ReviewsResponse> page = reviewsRepository.findByTitleContaining(search.getKeyword(), pageable)
                .map(ReviewsResponse::from);

        return ReviewsPageResponse.from(page.getContent(), search, page.getTotalElements());
    }
}
