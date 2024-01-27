package com.karthislab.todoplannerapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String description;

    @Enumerated(EnumType.STRING)
    StatusType status;

    LocalDateTime createdAt;

    LocalDateTime modifiedOn;

}