package com.vaadin.testbenchexample;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class Main extends VerticalLayout {
    public Main() {
        final Span label = new Span();
        label.setId("status");
        final Button button = new Button("Click Me", event -> label.setText("Clicked!"));
        button.setId("clickme");
        add(button, label);
    }
}
