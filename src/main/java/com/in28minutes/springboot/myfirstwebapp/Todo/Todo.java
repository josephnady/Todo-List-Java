package com.in28minutes.springboot.myfirstwebapp.Todo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private UUID id;
    private String username;
    @Size(min = 3, max = 500)
    private String description;
    @FutureOrPresent
    private LocalDate dueDate = LocalDate.now();
    private boolean done;
}
