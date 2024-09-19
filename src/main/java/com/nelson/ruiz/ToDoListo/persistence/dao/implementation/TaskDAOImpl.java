package com.nelson.ruiz.ToDoListo.persistence.dao.implementation;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import com.nelson.ruiz.ToDoListo.persistence.dao.interfaces.ITaskDAO;
import com.nelson.ruiz.ToDoListo.persistence.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TaskDAOImpl implements ITaskDAO {

    private final ITaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findByUuidAndStatusEntity(UUID uuid, StatusEntity statusEntity) {
        return taskRepository.findByUuidAndStatusEntity(uuid,statusEntity);
    }

    @Override
    public Page<Task> findAllByStatusEntity(Pageable pageable, StatusEntity statusEntity) {
        return taskRepository.findAllByStatusEntity(pageable,statusEntity);
    }
}
