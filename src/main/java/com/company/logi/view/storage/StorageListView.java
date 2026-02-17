package com.company.logi.view.storage;

import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "storages", layout = MainView.class)
@ViewController(id = "Storage.list")
@ViewDescriptor(path = "storage-list-view.xml")
@LookupComponent("storagesDataGrid")
@DialogMode(width = "64em")
public class StorageListView extends StandardListView<Storage> {
}