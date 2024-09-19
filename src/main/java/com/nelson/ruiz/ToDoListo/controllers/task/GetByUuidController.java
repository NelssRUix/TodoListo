package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/task")
public class GetByUuidController {

    private final ITaskService taskService;

    @GetMapping("/getByUuid/{uuid}")
    public ResponseEntity<Optional<TaskDTO>> getByUuid(@PathVariable UUID uuid , @RequestParam StatusEntity statusEntity){

        if (statusEntity != null) {
            Optional<TaskDTO> taskDTO = taskService.findByUuid(uuid,statusEntity);

            return new ResponseEntity<>(taskDTO , HttpStatus.OK);
        } else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
