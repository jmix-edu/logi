package com.company.logi.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "SHIPMENT", indexes = {
        @Index(name = "IDX_SHIPMENT_PRODUCT", columnList = "PRODUCT_ID"),
        @Index(name = "IDX_SHIPMENT_ORIGIN_STORAGE", columnList = "ORIGIN_STORAGE_ID"),
        @Index(name = "IDX_SHIPMENT_DESTINATION_STORAGE", columnList = "DESTINATION_STORAGE_ID")
})
@Entity
public class Shipment {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "SHIPMENT_DATE", nullable = false)
    @NotNull
    private OffsetDateTime shipmentDate;

    @Column(name = "VOLUME", precision = 19, scale = 2)
    private BigDecimal volume;

    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @JoinColumn(name = "ORIGIN_STORAGE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Storage originStorage;

    @JoinColumn(name = "DESTINATION_STORAGE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Storage destinationStorage;

    @Composition
    @OneToMany(mappedBy = "shipment")
    private List<Filling> fillings;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    public Storage getDestinationStorage() {
        return destinationStorage;
    }

    public void setDestinationStorage(Storage destinationStorage) {
        this.destinationStorage = destinationStorage;
    }

    public Storage getOriginStorage() {
        return originStorage;
    }

    public void setOriginStorage(Storage originStorage) {
        this.originStorage = originStorage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public OffsetDateTime getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(OffsetDateTime shipmentDate) {
        this.shipmentDate = shipmentDate;
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