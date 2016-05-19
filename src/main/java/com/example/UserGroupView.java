package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import javax.annotation.PostConstruct;
import org.vaadin.viritin.layouts.MVerticalLayout;

@UIScope
@SpringComponent
public class UserGroupView extends MVerticalLayout {

    @PostConstruct
    void init() {
        setCaption("Groups");
        addComponents(new Label("TODO!"));

    }

}
