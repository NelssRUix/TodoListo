package com.nelson.ruiz.ToDoListo.model.payload;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class TaskPayload {

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 100, message = "caracteres max 100")
    private  String title;

    @NotBlank(message = "la descripcion es requerida")
    @Size(max = 500)
    private  String description;

    @NotBlank
    private  String statusTask;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dueDate;
}
