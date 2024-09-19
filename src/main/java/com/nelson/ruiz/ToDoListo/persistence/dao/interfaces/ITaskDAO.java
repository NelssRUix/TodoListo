package com.nelson.ruiz.ToDoListo.persistence.dao.interfaces;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITaskDAO {

    Task save(Task task);

    Optional<Task> findByUuidAndStatusEntity(UUID uuid, StatusEntity statusEntity);

    Page<Task> findAllByStatusEntity(Pageable pageable, StatusEntity statusEntity);



}
