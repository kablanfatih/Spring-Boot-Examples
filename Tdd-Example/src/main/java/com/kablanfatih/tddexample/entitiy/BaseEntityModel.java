package com.kablanfatih.tddexample.entitiy;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
public abstract class BaseEntityModel implements Serializable {

    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_At;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
