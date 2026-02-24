package com.company.logi.view.provideresponseform;


import com.company.logi.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.Outcome;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outcomes = {
        @Outcome(id = "provided"),
        @Outcome(id = "not-now")
}, outputVariables = {
        @OutputVariable(name = "message", type = String.class)
})
@Route(value = "provide-response-form", layout = MainView.class)
@ViewController(id = "ProvideResponseForm")
@ViewDescriptor(path = "provide-response-form.xml")
public class ProvideResponseForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "message")
    @ViewComponent
    private TypedTextField<String> messageField;

    @Subscribe(id = "providedBtn", subject = "clickListener")
    protected void onProvidedBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("provided")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }

    @Subscribe(id = "notNowBtn", subject = "clickListener")
    protected void onNotNowBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("not-now")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }
}