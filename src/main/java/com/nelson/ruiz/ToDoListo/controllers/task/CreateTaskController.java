package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.model.payload.TaskPayload;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/task")
public class CreateTaskController {

    private final ITaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskPayload taskPayload){

      TaskDTO taskDTO =  taskService.saveTask(taskPayload);

      return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

}
