package com.karthislab.todoplannerapp.config;

import com.karthislab.todoplannerapp.models.StatusType;
import com.karthislab.todoplannerapp.models.ToDoModel;
import com.karthislab.todoplannerapp.repositories.ToDoRepositories;
import com.karthislab.todoplannerapp.services.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    final ToDoService toDoService;

    @Override
    public void run(String... args) throws Exception {

        List<ToDoModel> toDoModels = toDoService.getAll();

        if(toDoModels.isEmpty()) {

            ToDoModel toDoModel1 = ToDoModel.builder().description("edit tutorial").status(StatusType.BACKLOG).build();
            ToDoModel toDoModel2 = ToDoModel.builder().description("shoot tutorial").status(StatusType.DOING).build();
            ToDoModel toDoModel3 = ToDoModel.builder().description("tutorial script").status(StatusType.DONE).build();

            toDoService.save(toDoModel1);
            toDoService.save(toDoModel2);
            toDoService.save(toDoModel3);

        }

    }
}