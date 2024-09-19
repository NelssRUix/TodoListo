package com.nelson.ruiz.ToDoListo.model.dto;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
public record TaskDTO(

        String title,

        String description,

        String statusTask,

        LocalDateTime dueDate,

        Date createDate,

        Date updateDate,

        StatusEntity statusEntity) {
}
