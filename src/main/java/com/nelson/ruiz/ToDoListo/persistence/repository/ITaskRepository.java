package com.nelson.ruiz.ToDoListo.persistence.repository;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import com.nelson.ruiz.ToDoListo.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ITaskRepository extends JpaRepository<Task , UUID> {


    Optional<Task> findByUuidAndStatusEntity(UUID uuid, StatusEntity statusEntity);

    Page<Task> findAllByStatusEntity(Pageable pageable, StatusEntity statusEntity);

}
