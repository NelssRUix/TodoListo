package com.nelson.ruiz.ToDoListo.util.mapper;

import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import com.nelson.ruiz.ToDoListo.model.payload.TaskPayload;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper modelMapper;

    public Task task(TaskPayload taskPayload) {

        return modelMapper.map(taskPayload, Task.class);
    }

    public TaskDTO taskDTO(Task task) {

        return TaskDTO.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .statusTask(task.getStatusTask())
                .createDate(task.getCreateDate())
                .updateDate(task.getUpdateDate())
                .statusEntity(task.getStatusEntity())
                .build();
    }


    public void updateTaskFromPayload(Task currentTask, TaskPayload taskPayload) {

        modelMapper.map(taskPayload, currentTask);
    }

}
