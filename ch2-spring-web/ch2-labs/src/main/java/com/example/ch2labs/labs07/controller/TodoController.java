package com.example.ch2labs.labs07.controller;


import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.dto.CreateTodoRequestDto;
import com.example.ch2labs.labs07.dto.TodoResponseDto;
import com.example.ch2labs.labs07.dto.UpdateTodoRequestDto;
import com.example.ch2labs.labs07.exception.TodoValidationException;
import com.example.ch2labs.labs07.service.TodoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;



    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto createTodo) {
        if(createTodo == null ||
                createTodo.getTitle() == null ||
                createTodo.getTitle().isEmpty() ||
                createTodo.getCompleted() == null) {
            throw new RuntimeException("title 및 completed 누락되었습니다.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(createTodo));
    }

    @PatchMapping


    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo
            (@PathVariable Long id,
            @RequestBody UpdateTodoRequestDto updateTodo) {

        if(updateTodo == null ||
                updateTodo.getTitle() == null ||
                updateTodo.getTitle().isEmpty() ||
                updateTodo.getCompleted() == null) {
            throw new TodoValidationException("title 및 completed 누락되었습니다.", HttpStatus.BAD_REQUEST.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id, updateTodo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
