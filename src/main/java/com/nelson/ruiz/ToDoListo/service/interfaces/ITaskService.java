package com.nelson.ruiz.ToDoListo.service.interfaces;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import com.nelson.ruiz.ToDoListo.model.payload.TaskPayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITaskService {

    TaskDTO saveTask(TaskPayload taskPayload);

    Optional<TaskDTO> updateTask(UUID uuid, TaskPayload taskPayload);

    void deleteTask(UUID uuid, StatusEntity statusEntity);

    Page<TaskDTO> findAllByStatusEntity(Pageable pageable, StatusEntity statusEntity);

    Optional<TaskDTO> findByUuid(UUID uuid, StatusEntity  statusEntity);

}
