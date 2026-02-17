package com.company.logi.view.companyunit;

import com.company.logi.entity.CompanyUnit;

import com.company.logi.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "company-units", layout = MainView.class)
@ViewController(id = "CompanyUnit.list")
@ViewDescriptor(path = "company-unit-list-view.xml")
@LookupComponent("companyUnitsDataGrid")
@DialogMode(width = "64em")
public class CompanyUnitListView extends StandardListView<CompanyUnit> {
}