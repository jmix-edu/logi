package com.company.logi.view.storage;

import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.company.logi.view.storagesmap.StoragesMapView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "storages", layout = MainView.class)
@ViewController(id = "Storage.list")
@ViewDescriptor(path = "storage-list-view.xml")
@LookupComponent("storagesDataGrid")
@DialogMode(width = "64em")
public class StorageListView extends StandardListView<Storage> {
    @ViewComponent
    private DataGrid<Storage> storagesDataGrid;
    @Autowired
    private DialogWindows dialogWindows;

    @Subscribe("storagesDataGrid.showOnMap")
    public void onStoragesDataGridShowOnMap(final ActionPerformedEvent event) {
        Storage selected = storagesDataGrid.getSingleSelectedItem();
        dialogWindows.view(this, StoragesMapView.class)
                .withViewConfigurer(storagesMapView -> {
                    storagesMapView.setSelectedStorage(selected);
                })
                .open();
    }
}