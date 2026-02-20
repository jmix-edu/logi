package com.company.logi.view.storage;

import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.company.logi.view.storagelocation.StorageLocationView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "storages/:id", layout = MainView.class)
@ViewController(id = "Storage.detail")
@ViewDescriptor(path = "storage-detail-view.xml")
@EditedEntityContainer("storageDc")
public class StorageDetailView extends StandardDetailView<Storage> {

    @Autowired
    private DialogWindows dialogWindows;

    @Subscribe(id = "locationLookupBtn", subject = "clickListener")
    public void onLocationLookupBtnClick(final ClickEvent<JmixButton> event) {
        dialogWindows.view(this, StorageLocationView.class)
                .withViewConfigurer(storageLocationView ->
                        storageLocationView.setItem(getEditedEntity()))
                .open();
    }
}