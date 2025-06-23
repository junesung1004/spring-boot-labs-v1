package com.example.ch4labs.repository;


import com.example.ch4labs.domain.QReview;
import com.example.ch4labs.domain.Review;
import com.example.ch4labs.dto.review.ReviewSearchRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Review> searchByConditions(ReviewSearchRequest request, Pageable pageable) {

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        if (request.getTitle() != null) {
            builder.and(review.title.containsIgnoreCase(request.getTitle()));
        }

        if (request.getBookTitle() != null) {
            builder.and(review.bookTitle.containsIgnoreCase(request.getBookTitle()));
        }

        if (request.getBookAuthor() != null) {
            builder.and(review.bookAuthor.containsIgnoreCase(request.getBookAuthor()));
        }

        if (request.getAuthor() != null) {
            builder.and(review.author.containsIgnoreCase(request.getAuthor()));
        }

        if (request.getStartDate() != null) {
            builder.and(review.createdAt.goe(request.getStartDate().atStartOfDay()));
        }

        if (request.getBookTitleContains() != null) {
            builder.and(review.bookTitle.containsIgnoreCase(request.getBookTitleContains()));
        }

        if (request.getMinRating() != null) {
            builder.and(review.rating.goe(request.getMinRating()));
        }

        if (request.getMaxRating() != null) {
            builder.and(review.rating.loe(request.getMaxRating()));
        }

        if (request.getEndDate() != null) {
            builder.and(review.createdAt.loe(request.getEndDate().atTime(LocalTime.MAX)));
        }

        List<Review> content = queryFactory
                .selectFrom(review)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.createdAt.desc())
                .fetch();

        long total = queryFactory
                .select(review.count())
                .from(review)
                .where(builder)
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }
}
