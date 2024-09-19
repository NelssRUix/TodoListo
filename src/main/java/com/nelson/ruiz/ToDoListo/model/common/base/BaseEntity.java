package com.nelson.ruiz.ToDoListo.model.common.base;

import com.nelson.ruiz.ToDoListo.model.common.enums.StatusEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    private StatusEntity statusEntity = StatusEntity.ACTIVE;


    @PrePersist
    public void generateUuid() {
        uuid = UUID.randomUUID();
    }

    @PreUpdate
    public  void preUpdate(){
        updateDate = new Date();
    }

}
