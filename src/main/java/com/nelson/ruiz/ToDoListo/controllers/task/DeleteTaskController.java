package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/task")
public class DeleteTaskController {

    private final ITaskService taskService;

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID uuid, @RequestParam StatusEntity statusEntity) {

        if (statusEntity != null) {

            taskService.deleteTask(uuid, statusEntity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
