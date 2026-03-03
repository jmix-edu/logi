package com.company.logi.view.overrides.viewauditrecordlist;

import com.company.logi.view.main.MainView;
import com.company.viewaudit.annotation.IgnoreViewAudit;
import com.company.viewaudit.view.viewauditrecord.ViewAuditRecordListView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "view-audit-records", layout = MainView.class)
@ViewController(id = "va_ViewAuditRecord.list")
@ViewDescriptor(path = "ext-view-audit-record-list-view.xml")
@IgnoreViewAudit
public class ExtViewAuditRecordListView extends ViewAuditRecordListView {
}