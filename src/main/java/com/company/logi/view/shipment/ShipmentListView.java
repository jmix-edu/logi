package com.company.logi.view.shipment;

import com.company.logi.entity.Shipment;

import com.company.logi.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "shipments", layout = MainView.class)
@ViewController(id = "Shipment.list")
@ViewDescriptor(path = "shipment-list-view.xml")
@LookupComponent("shipmentsDataGrid")
@DialogMode(width = "64em")
public class ShipmentListView extends StandardListView<Shipment> {
}