package com.company.logi.view.storagesmap;


import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.company.logi.view.storage.StorageDetailView;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.Dialogs;
import io.jmix.flowui.action.DialogAction;
import io.jmix.flowui.kit.action.BaseAction;
import io.jmix.flowui.view.*;
import io.jmix.mapsflowui.component.GeoMap;
import io.jmix.mapsflowui.component.model.source.DataVectorSource;
import io.jmix.mapsflowui.component.model.source.GeoObjectClickNotifier;
import io.jmix.mapsflowui.kit.component.model.style.Style;
import io.jmix.mapsflowui.kit.component.model.style.image.Anchor;
import io.jmix.mapsflowui.kit.component.model.style.image.IconStyle;
import io.jmix.mapsflowui.kit.component.model.style.text.TextStyle;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "storages-map-view", layout = MainView.class)
@ViewController(id = "StoragesMapView")
@ViewDescriptor(path = "storages-map-view.xml")
@DialogMode(width = "60em", height = "40em")
public class StoragesMapView extends StandardView {
    @ViewComponent
    private GeoMap map;

    @ViewComponent("map.vectorLayer.source")
    private DataVectorSource<Storage> source;
    @Autowired
    private DataManager dataManager;
    private Storage selectedstorage = null;

    private final Coordinate DEFAULT_CENTER = new Coordinate(55.321123, 64.4324234);

    private final Double DEFAULT_ZOOM = 5d;
    private final Double CLOSER_ZOOM = 12d;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private Messages messages;
    @Autowired
    private DialogWindows dialogWindows;

    public void setSelectedStorage(Storage selected) {
        this.selectedstorage = selected;
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (selectedstorage != null && selectedstorage.getLocation() != null) {
            setCenterAndZoom(selectedstorage.getLocation().getCoordinate(), CLOSER_ZOOM);
        } else {
            setCenterAndZoom(DEFAULT_CENTER, DEFAULT_ZOOM);
        }
    }

    @Install(to = "map.vectorLayer.source", subject = "styleProvider")
    private Style mapVectorLayerSourceStyleProvider(final Storage storage) {
        return new Style()
                .withImage(new IconStyle()
                        .withScale(0.15)
                        .withSrc("icons/icon.png")
                        .withAnchor(new Anchor(0.5, 1.2)))
                .withText(new TextStyle()
                        .withText(storage.getName())
                        .withFont("bold 12px sans-serif"));
    }

    @Subscribe("map.vectorLayer.source")
    public void onMapVectorLayerSourceGeoObjectClick(final GeoObjectClickNotifier.GeoObjectClickEvent<Storage> event) {
        Storage selected = event.getItem();
        dialogs.createOptionDialog()
                .withHeader(
                        messages.getMessage("com.company.logi.dialog.click")
                )
                .withActions(
                        new BaseAction("editStorage")
                                .withText("Edit")
                                .withIcon(new Icon(VaadinIcon.PENCIL))
                                .withIcon(new Icon(VaadinIcon.PENCIL))
                                .withHandler(actionPerformedEvent -> {
                                    dialogWindows.detail(this, Storage.class)
                                            .editEntity(selected)
                                            .open();
                                }),
                        new DialogAction(DialogAction.Type.CANCEL)

                )
                .open();
    }

    private void setCenterAndZoom(Coordinate coordinate, Double zoom) {
        map.setCenter(coordinate);
        map.setZoom(zoom);
    }
}