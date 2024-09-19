package com.nelson.ruiz.ToDoListo.service.implementation;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.dto.TaskDTO;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import com.nelson.ruiz.ToDoListo.model.payload.TaskPayload;
import com.nelson.ruiz.ToDoListo.persistence.dao.interfaces.ITaskDAO;
import com.nelson.ruiz.ToDoListo.service.interfaces.ITaskService;
import com.nelson.ruiz.ToDoListo.util.mapper.TaskMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private final ITaskDAO taskDAO;

    private final TaskMapper taskMapper;


    @Override
    @Transactional
    public TaskDTO saveTask(TaskPayload taskPayload) {

        try {
            Task task = taskMapper.task(taskPayload);

            Task saveTask = taskDAO.save(task);

            TaskDTO taskDTO = taskMapper.taskDTO(saveTask);

            return taskDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error create a task");
        }
    }

    @Override
    public Optional<TaskDTO> updateTask(UUID uuid, TaskPayload taskPayload) {

        Optional<Task> optionalTask = taskDAO.findByUuidAndStatusEntity(uuid, StatusEntity.ACTIVE);

        if (optionalTask.isPresent()) {

            Task currentTask = optionalTask.get();

            taskMapper.updateTaskFromPayload(currentTask, taskPayload);

            Task taskUpdate = taskDAO.save(currentTask);


            TaskDTO taskDTO = taskMapper.taskDTO(taskUpdate);

            return Optional.of(taskDTO);
        } else {

            throw new UnsupportedOperationException("Error update a task");
        }
    }

    @Override
    public void deleteTask(UUID uuid, StatusEntity statusEntity) {

        Optional<Task> optionalTask = taskDAO.findByUuidAndStatusEntity(uuid, StatusEntity.ACTIVE);

        if (optionalTask.isPresent()) {

           Task task = optionalTask.get();

           task.setStatusEntity(StatusEntity.DELETE);

           taskDAO.save(task);

        } else {

            throw new EntityNotFoundException("Erorr task not found");
        }


    }

    @Override
    public Page<TaskDTO> findAllByStatusEntity(Pageable pageable, StatusEntity statusEntity) {

        try {
            Page<Task> tasks = taskDAO.findAllByStatusEntity(pageable, statusEntity);

            Page<TaskDTO> taskDTOS = tasks.map(taskMapper::taskDTO);

            return taskDTOS;

        } catch (Exception e) {
            throw new RuntimeException("Error al encontrar todas las tareas", e);
        }
    }

    @Override
    public Optional<TaskDTO> findByUuid(UUID uuid, StatusEntity statusEntity) {

        Optional<Task> optionalTask = taskDAO.findByUuidAndStatusEntity(uuid, statusEntity);

        if (optionalTask.isPresent()) {

            Task task = optionalTask.get();

            TaskDTO taskDTO = taskMapper.taskDTO(task);

            return Optional.of(taskDTO);
        } else {
            throw new EntityNotFoundException("Task not found");
        }
    }
}
