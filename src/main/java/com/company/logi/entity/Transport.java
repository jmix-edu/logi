package com.company.logi.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "TRANSPORT")
@Entity
public class Transport {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "OWNER_NAWME")
    private String ownerNawme;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "CAPACITY", nullable = false)
    @NotNull
    private Double capacity;

    @NotNull
    @Column(name = "IS_FILLED", nullable = false)
    private Boolean isFilled = false;

    @Column(name = "TARE_WEIGHT")
    private Double tareWeight;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Double getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(Double tareWeight) {
        this.tareWeight = tareWeight;
    }

    public void setIsFilled(Boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Boolean getIsFilled() {
        return isFilled;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerNawme() {
        return ownerNawme;
    }

    public void setOwnerNawme(String ownerNawme) {
        this.ownerNawme = ownerNawme;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}