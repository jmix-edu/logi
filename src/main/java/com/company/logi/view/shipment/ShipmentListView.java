package com.company.logi.view.shipment;

import com.company.logi.entity.Shipment;

import com.company.logi.view.main.MainView;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "shipments", layout = MainView.class)
@ViewController(id = "Shipment.list")
@ViewDescriptor(path = "shipment-list-view.xml")
@LookupComponent("shipmentsDataGrid")
@DialogMode(width = "64em")
public class ShipmentListView extends StandardListView<Shipment> {
}