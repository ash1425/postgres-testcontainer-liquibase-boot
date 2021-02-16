package com.ashay.explore.postgrestc.dto;

import com.ashay.explore.postgrestc.view.TodoView;
import lombok.Data;

@Data
public class Todo {
    private final Long id;
    private final String description;

    public TodoView todoView() {
        return new TodoView(id, description);
    }

    public static Todo from(TodoView todoView) {
        return new Todo(todoView.getId(), todoView.getDescription());
    }
}
