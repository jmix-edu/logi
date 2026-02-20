package com.company.logi.view.storagelocation;


import com.company.logi.entity.Storage;
import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import io.jmix.mapsflowui.component.GeoMap;
import io.jmix.mapsflowui.component.event.MapClickEvent;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

@ViewController(id = "StorageLocationView")
@ViewDescriptor(path = "storage-location-view.xml")
@DialogMode(width = "60em", height = "40em")
public class StorageLocationView extends StandardView {

    @ViewComponent
    private InstanceContainer<Storage> storageDc;
    @ViewComponent
    private GeoMap map;

    private final Coordinate DEFAULT_CENTER = new Coordinate(26.12, 44.42);
    private final Double DEFAULT_ZOOM = 5d;
    private final Double CLOSER_ZOOM = 12d;
    @ViewComponent
    private TypedTextField<Point> locationField;

    public void setItem(Storage item){
        storageDc.setItem(item);
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        Storage item = storageDc.getItem();
        if (item.getLocation() != null){
            setCenterAndZoom(item.getLocation().getCoordinate(), CLOSER_ZOOM);
        } else {
            setCenterAndZoom(DEFAULT_CENTER, DEFAULT_ZOOM);
        }

    }

    @Subscribe("map")
    public void onMapMapClick(final MapClickEvent event) {
        Coordinate coordinate = event.getCoordinate();
        GeometryFactory factory = new GeometryFactory();
        Point point = factory.createPoint(coordinate);
        locationField.setValue(point.toText());
    }

    private void setCenterAndZoom(Coordinate coordinate, Double zoom) {
        map.setCenter(coordinate);
        map.setZoom(zoom);
    }
    
}