package com.company.logi.view.storage;

import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "storages/:id", layout = MainView.class)
@ViewController(id = "Storage.detail")
@ViewDescriptor(path = "storage-detail-view.xml")
@EditedEntityContainer("storageDc")
public class StorageDetailView extends StandardDetailView<Storage> {
}