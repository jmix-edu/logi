package com.company.logi.view.storagesmap;


import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.view.*;
import io.jmix.mapsflowui.component.GeoMap;
import io.jmix.mapsflowui.component.model.source.DataVectorSource;
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
        source.setStyleProvider(storage -> new Style()
                .withImage(new IconStyle()
                        .withScale(0.15)
                        .withSrc("icons/icon.png")
                        .withColor("var(--lumo-primary-color)")
                        .withAnchor(new Anchor(0.5, 1.2)))
                .withText(new TextStyle()
                        .withText(storage.getName())
                        .withFont("bold 12px sans-serif")));
    }

    private void setCenterAndZoom(Coordinate coordinate, Double zoom) {
        map.setCenter(coordinate);
        map.setZoom(zoom);
    }

    @Subscribe
    public void onReady(final ReadyEvent event) {

    }


    
    
}