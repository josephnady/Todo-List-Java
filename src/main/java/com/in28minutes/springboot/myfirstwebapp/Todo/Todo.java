package com.in28minutes.springboot.myfirstwebapp.Todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    private String username;
    @Size(min = 3, max = 500)
    private String description;
    @FutureOrPresent
    private LocalDate dueDate = LocalDate.now();
    private boolean done;
}
