package com.example.ch4labs.service;

import com.example.ch4labs.domain.Review;
import com.example.ch4labs.dto.*;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewResponse createReview(ReviewCreateRequest request) {
        Review review = request.toDomain();
        Review savedReview = reviewRepository.save(review);

        return ReviewResponse.from(savedReview);
    }

//    public ReviewPageResponse getAllReviews(ReviewSearchRequest request) {
//
//        // 몇 페이지를 가져올건지, 몇 개씩 아이템을 가지고 올건지
//        // Pagealble 인터페이스를 사용해서 찾음
//        // 1. 페이징 정보 생성
//        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
//
//        // 2. 페이징된 리뷰 조회
//        Page<Review> pageResult = reviewRepository.findAll(pageable);
//
//        // 3. 엔티티 → DTO 변환
//        List<ReviewResponse> content = pageResult.getContent()
//                .stream()
//                .map(ReviewResponse::from)
//                .toList();
//
//        // 4. 응답 객체로 변환해서 반환
//        return ReviewPageResponse.from(content, request, pageResult.getTotalElements());
//
//    }


    // 위 모든 리뷰를 조회하는 메서드를 검색을 통한 조회로 수정
    public ReviewPageResponse getAllReviews(ReviewSearchRequest request) {

       Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

       Page<Review> pageResult = reviewRepository.searchByConditions(request, pageable);

       List<ReviewResponse> reviews = pageResult.getContent().stream().map(ReviewResponse::from).collect(Collectors.toList());

       return ReviewPageResponse.from(reviews, request, pageResult.getTotalElements());
    }


    public ReviewResponse getByIdReview(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(review -> ReviewResponse.from(review))
                .orElseThrow(()-> new NoSuchElementException("게시글이 존재하지 않습니다."));
    }

    public ReviewResponse updateReview(Long id, ReviewUpdateRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("게시글이 없습니다."));
        review.setTitle(request.getTitle());
        review.setContent(request.getContent());
        review.setRating(request.getRating());

        reviewRepository.save(review);

        return ReviewResponse.from(review);
    }

    public void deleteReview(Long id) {
        if(!reviewRepository.existsById(id)) {
            throw new NoSuchElementException("리뷰가 존재하지 않습니다.");
        }
        reviewRepository.deleteById(id);
    }
}
