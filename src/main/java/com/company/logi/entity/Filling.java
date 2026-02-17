package com.company.logi.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "FILLING", indexes = {
        @Index(name = "IDX_FILLING_TRANSPORT", columnList = "TRANSPORT_ID"),
        @Index(name = "IDX_FILLING_PRODUCT", columnList = "PRODUCT_ID"),
        @Index(name = "IDX_FILLING_FILLER", columnList = "FILLER_ID"),
        @Index(name = "IDX_FILLING_SHIPMENT", columnList = "SHIPMENT_ID")
})
@Entity
public class Filling {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "TRANSPORT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Transport transport;

    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Column(name = "FILLING_DATE", nullable = false)
    @NotNull
    private OffsetDateTime fillingDate;

    @Column(name = "VOLUME")
    private Double volume;

    @JoinColumn(name = "FILLER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User filler;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SHIPMENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Shipment shipment;

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public User getFiller() {
        return filler;
    }

    public void setFiller(User filler) {
        this.filler = filler;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public OffsetDateTime getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(OffsetDateTime fillingDate) {
        this.fillingDate = fillingDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
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