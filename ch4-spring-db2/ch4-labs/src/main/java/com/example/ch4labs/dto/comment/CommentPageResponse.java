package com.example.ch4labs.dto.comment;

import com.example.ch4labs.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentPageResponse {

    private int page;
    private int size;
    private Long totalElements;
    private int totalPages;
    private List<CommentResponse> comments;

    public static CommentPageResponse from(Page<CommentResponse> page) {
        return CommentPageResponse.builder()
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .comments(page.getContent())
                .build();
    }
}
