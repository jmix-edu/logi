package com.company.logi.view.calendar;


import com.company.logi.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "calendar-view", layout = MainView.class)
@ViewController(id = "CalendarView")
@ViewDescriptor(path = "calendar-view.xml")
public class CalendarView extends StandardView {
}