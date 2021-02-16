package com.ashay.explore.postgrestc.web;

import com.ashay.explore.postgrestc.dto.Todo;
import com.ashay.explore.postgrestc.repository.TodoRepository;
import com.ashay.explore.postgrestc.view.TodoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<TodoView> getAll() {
        return todoRepository.getAll()
                .stream()
                .map(Todo::todoView)
                .collect(Collectors.toList());
    }
}
