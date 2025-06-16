package com.example.ch2labs.labs07.config;

import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.repository.TodoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DummyData {

    private  final TodoRepository todoRepository;

    @PostConstruct
    public void init() {
        todoRepository.save(new Todo(null, "스프링 연습하기", false));
        todoRepository.save(new Todo(null, "3tier 계층 분리하여 연습하기", false));
        todoRepository.save(new Todo(null, "에러로직 추가하기", false));
    }
}
