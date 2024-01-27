package com.karthislab.todoplannerapp.services;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import com.karthislab.todoplannerapp.repositories.ToDoRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ToDoService {

    final ToDoRepositories toDoRepositories;

    public List<ToDoModel> getAll() {
        return toDoRepositories.findAll();
    }

    public ToDoModel save(ToDoModel newToDo) {
        if(newToDo.getId() == null) {
            newToDo.setCreatedAt(LocalDateTime.now());
        }
        newToDo.setModifiedOn(LocalDateTime.now());
        return toDoRepositories.save(newToDo);
    }

    public List<ToDoModel> getAllByStatus(StatusType status) {
        return toDoRepositories.findByStatus(status);
    }

    public ToDoModel getById(long id) {
        return toDoRepositories.findById(id).orElseThrow();
    }
}
