package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import javax.annotation.PostConstruct;
import org.vaadin.viritin.layouts.MVerticalLayout;

@UIScope
@SpringComponent
public class PersonsView extends MVerticalLayout {

    @PostConstruct
    void init() {
        setCaption("Persons");

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            addComponent(new Label("Stop clicking that button " + name.getValue()
                    + ", it works! Create something real!"));
        });

        addComponents(name, button);
    }

}
