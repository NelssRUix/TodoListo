package com.nelson.ruiz.ToDoListo.model.entity;

import com.nelson.ruiz.ToDoListo.model.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tareas")

public class Task extends BaseEntity {

    private  String title;

    private  String description;

    @Column(name = "estado_tarea")
    private  String statusTask;

    private LocalDateTime dueDate;

}
