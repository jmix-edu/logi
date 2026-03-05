package com.company.logi.view.demo;


import com.company.logi.component.ColorPicker;
import com.company.logi.component.composite.ColorComponent;
import com.company.logi.view.main.MainView;
import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import com.vaadin.flow.server.streams.DownloadResponse;
import io.jmix.core.Resources;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;

@Route(value = "demo-view", layout = MainView.class)
@ViewController(id = "DemoView")
@ViewDescriptor(path = "demo-view.xml")
public class DemoView extends StandardView {
    @Autowired
    private Notifications notifications;

    @Autowired
    private Resources resources;

    @Subscribe
    public void onInit(final InitEvent event) {

        PdfViewer pdfViewer = new PdfViewer();
        pdfViewer.setSizeFull();

        Resource resource = resources.getResource("META-INF/resources/files/example.pdf");

        DownloadHandler handler = DownloadHandler.fromInputStream(downloadEvent ->
            new DownloadResponse(
                    new ByteArrayInputStream(resource.getContentAsByteArray()),
                    "example.pdf",
                    "application/octet-stream",
                    resource.contentLength()
            )
        );

        pdfViewer.setSrc(handler);
        getContent().add(pdfViewer);



//        ColorPicker colorPicker = new ColorPicker();
//        getContent().add(colorPicker);
//
//        colorPicker.addValueChangeListener(e ->
//                notifications.show(e.getValue()));

        ColorComponent colorComponent = new ColorComponent();
        getContent().add(colorComponent);
    }
}