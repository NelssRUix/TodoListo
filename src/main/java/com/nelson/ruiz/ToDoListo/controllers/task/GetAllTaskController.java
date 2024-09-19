package com.nelson.ruiz.ToDoListo.controllers.task;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/task")
public class GetAllTaskController {

    private final ITaskService taskService;

    @GetMapping("/getAllByStatus")
    public ResponseEntity<Page<TaskDTO>> getAllTaskByStatus(Pageable pageable , @RequestParam StatusEntity statusEntity){

        if (statusEntity != null) {

          Page<TaskDTO> taskDTO = taskService.findAllByStatusEntity(pageable,statusEntity);

            return new ResponseEntity<>(taskDTO , HttpStatus.OK);
        } else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
