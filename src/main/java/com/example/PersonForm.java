package com.example;

import com.vaadin.ui.*;
import org.vaadin.addon.leaflet.util.PointField;
import org.vaadin.viritin.fields.EmailField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;

/**
 * Created by romuald on 20/05/2016.
 */
public class PersonForm extends AbstractForm<Person> {

    TextField name = new MTextField("name");
    TextField email = new EmailField("email");
    DateField birthday = new DateField("birthday");
    PointField location = new PointField("");

    @Override
    protected Component createContent() {

        location.setHeight("200px");
        location.setWidth("200px");
        return new FormLayout(name, email, birthday, location, getToolbar());
    }
}
