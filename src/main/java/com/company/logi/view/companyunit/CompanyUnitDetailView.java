package com.company.logi.view.companyunit;

import com.company.logi.entity.CompanyUnit;

import com.company.logi.entity.User;
import com.company.logi.view.main.MainView;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "company-units/:id", layout = MainView.class)
@ViewController(id = "CompanyUnit.detail")
@ViewDescriptor(path = "company-unit-detail-view.xml")
@EditedEntityContainer("companyUnitDc")
public class CompanyUnitDetailView extends StandardDetailView<CompanyUnit> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DialogWindows dialogWindows;
    @ViewComponent
    private DataGrid<User> fillersDataGrid;
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private DataContext dataContext;
    @ViewComponent
    private CollectionContainer<User> fillersDc;
    @Autowired
    private Notifications notifications;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<CompanyUnit> event) {
        CompanyUnit companyUnit = event.getEntity();
        companyUnit.setManager((User) currentAuthentication.getUser());
    }

    @Subscribe("fillersDataGrid.add")
    public void onFillersDataGridAdd(final ActionPerformedEvent event) {
        dialogWindows.lookup(fillersDataGrid)
                .withSelectHandler(users -> {
                    for (User u : users) {
                        u.setCompanyUnit(getEditedEntity());
                        fillersDc.getMutableItems().add(u);
                        dataManager.save(u);
                    }
                })
                .open();

        notifications.create("Something wrong", "description")
                .withType(Notifications.Type.WARNING)
                .withPosition(Notification.Position.BOTTOM_STRETCH)
                .show();
    }

    @Subscribe("fillersDataGrid.exclude")
    public void onFillersDataGridExclude(final ActionPerformedEvent event) {
        User selected = fillersDataGrid.getSingleSelectedItem();
        selected.setCompanyUnit(null);
        fillersDc.getMutableItems().remove(selected);
        dataManager.save(selected);
    }


}