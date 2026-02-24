package com.company.logi.view.storedproduct;

import com.company.logi.entity.StoredProduct;
import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "stored-products/:id", layout = MainView.class)
@ViewController(id = "StoredProduct.detail")
@ViewDescriptor(path = "stored-product-detail-view.xml")
@EditedEntityContainer("storedProductDc")
public class StoredProductDetailView extends StandardDetailView<StoredProduct> {
}