package com.company.logi.view.shipment;

import com.company.logi.entity.Shipment;

import com.company.logi.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "shipments/:id", layout = MainView.class)
@ViewController(id = "Shipment.detail")
@ViewDescriptor(path = "shipment-detail-view.xml")
@EditedEntityContainer("shipmentDc")
public class ShipmentDetailView extends StandardDetailView<Shipment> {
}