package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.model.payload.TaskPayload;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tasks")
public class UpdateTaskController {

    private final ITaskService taskService;

    @PutMapping("/update/{uuid}")
    public ResponseEntity<Optional<TaskDTO>> updateTask(@PathVariable UUID uuid, @RequestBody TaskPayload taskPayload){

      Optional<TaskDTO> taskDTO =  taskService.updateTask(uuid,taskPayload);

      return new ResponseEntity<>( taskDTO, HttpStatus.ACCEPTED);
    }
}
