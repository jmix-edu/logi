package com.company.logi.view.resourcerolemodellist;

import com.company.viewaudit.annotation.IgnoreViewAudit;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.DefaultMainViewParent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import io.jmix.securityflowui.view.resourcerole.ResourceRoleModelListView;

@Route(value = "sec/resourcerolemodels", layout = DefaultMainViewParent.class)
@ViewController(id = "sec_ResourceRoleModel.list")
@ViewDescriptor(path = "ext-resource-role-model-list-view.xml")
@IgnoreViewAudit
public class ExtResourceRoleModelListView extends ResourceRoleModelListView {
}