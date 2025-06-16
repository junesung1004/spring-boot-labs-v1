package com.example.ch2labs.labs07.service;

import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.dto.CreateTodoRequestDto;
import com.example.ch2labs.labs07.dto.TodoResponseDto;
import com.example.ch2labs.labs07.dto.UpdateTodoRequestDto;
import com.example.ch2labs.labs07.exception.TodoNotFoundException;
import com.example.ch2labs.labs07.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    //todoList 아이템 모두 조회 메서드
    public List<TodoResponseDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> toResponse(todo))
                .collect(Collectors.toList());
    }

    //타입 변환 로직 메서드
    private TodoResponseDto toResponse(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getCompleted());
    }


    //투두 아이템 단건 조회 메서드
    public TodoResponseDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("해당 ID를 가진 Todo 아이템이 존재하지 않습니다. id = " + id, HttpStatus.NOT_FOUND.toString()));

        return toResponse(todo);
    }

    //투두 아이템 추가 메서드
    public TodoResponseDto createTodo(CreateTodoRequestDto createTodo) {
        Todo todo = new Todo(null, createTodo.getTitle(), createTodo.getCompleted());
        Todo saveTodo = todoRepository.save(todo);
        return toResponse(saveTodo);
    }

    //투두 아이템 수정 메서드
    public TodoResponseDto updateTodo(Long id, UpdateTodoRequestDto updateTodo) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("해당 ID를 가진 Todo 아이템이 존재하지 않습니다. id = " + id, HttpStatus.NOT_FOUND.toString()));

        todo.setTitle(updateTodo.getTitle());
        todo.setCompleted(updateTodo.getCompleted());

        return toResponse(todo);
    }


    //투두 아이템 삭제 메서드
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).
                orElseThrow(() -> new TodoNotFoundException("해당 ID를 가진 Todo 아이템이 존재하지 않습니다. id = " + id, HttpStatus.NOT_FOUND.toString()));

        todoRepository.delete(todo);
    }
}
