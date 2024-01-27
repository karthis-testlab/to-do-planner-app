package com.karthislab.todoplannerapp.controllers;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import com.karthislab.todoplannerapp.services.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PageController {

    final ToDoService toDoService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newTodo", new ToDoModel());
        modelAndView.addObject("backlog", toDoService.getAllByStatus(StatusType.BACKLOG));
        modelAndView.addObject("doing", toDoService.getAllByStatus(StatusType.DOING));
        modelAndView.addObject("done", toDoService.getAllByStatus(StatusType.DONE));
        return modelAndView;
    }

}
