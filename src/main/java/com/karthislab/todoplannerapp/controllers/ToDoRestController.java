package com.karthislab.todoplannerapp.controllers;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import com.karthislab.todoplannerapp.services.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ToDoRestController {

    final ToDoService toDoService;

    @PutMapping("/todos/{id}")
    public ToDoModel updateTodoItem(@PathVariable("id") long id) {
        ToDoModel updateToDoItem = toDoService.getById(id);
        if(updateToDoItem.getStatus() == StatusType.BACKLOG) {
            updateToDoItem.setStatus(StatusType.DOING);
        } else if(updateToDoItem.getStatus() == StatusType.DOING) {
            updateToDoItem.setStatus(StatusType.DONE);
        }
        return toDoService.save(updateToDoItem);
    }

}