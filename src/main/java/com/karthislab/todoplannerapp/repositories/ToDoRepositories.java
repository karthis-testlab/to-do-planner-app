package com.karthislab.todoplannerapp.repositories;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ToDoRepositories extends ListCrudRepository<ToDoModel, Long> {
    List<ToDoModel> findByStatus(StatusType status);
}
