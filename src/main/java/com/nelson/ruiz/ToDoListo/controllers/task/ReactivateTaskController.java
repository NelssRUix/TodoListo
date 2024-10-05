package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tasks")
public class ReactivateTaskController {

    private final ITaskService taskService;

    @PutMapping("/reactivate/{uuid}")
    public ResponseEntity<Optional<TaskDTO>> reactivateTask(@PathVariable UUID uuid) {
        Optional<TaskDTO> taskDTO = taskService.reactivateTask(uuid);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

}
