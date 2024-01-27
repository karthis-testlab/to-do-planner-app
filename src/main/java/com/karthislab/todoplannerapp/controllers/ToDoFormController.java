package com.karthislab.todoplannerapp.controllers;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import com.karthislab.todoplannerapp.services.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ToDoFormController {

    final ToDoService toDoService;

    @PostMapping("/todos/new")
    public String createNewToDo(@Valid ToDoModel newTodo) {
        newTodo.setStatus(StatusType.BACKLOG);
        toDoService.save(newTodo);
        return "redirect:/";
    }

}