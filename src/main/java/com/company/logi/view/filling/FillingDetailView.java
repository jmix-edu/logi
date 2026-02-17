package com.company.logi.view.filling;

import com.company.logi.entity.Filling;

import com.company.logi.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "fillings/:id", layout = MainView.class)
@ViewController(id = "Filling.detail")
@ViewDescriptor(path = "filling-detail-view.xml")
@EditedEntityContainer("fillingDc")
public class FillingDetailView extends StandardDetailView<Filling> {
}