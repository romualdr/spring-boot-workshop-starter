package com.example;

import com.vaadin.event.FieldEvents;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import java.util.List;

@UIScope
@SpringComponent
public class PersonsView extends MHorizontalLayout {

    @Autowired
    private UserRepository repo;

    @PostConstruct
    void init() {
        setCaption("Persons");

        /**
         * List
         */
        MVerticalLayout listContainer = new MVerticalLayout();

        // Header
        MHorizontalLayout header = new MHorizontalLayout();
        TextField searchByName = new TextField();
        searchByName.setInputPrompt("Search by name");
        Button button = new Button("Add person");

        // List
        List<Person> findAll = repo.findAll();
        MTable<Person> table = new MTable<>(Person.class).addBeans(findAll);
        table.withProperties("name", "email");

        /**
         * Events
         */
        searchByName.addTextChangeListener(e -> {
            List<Person> persons = repo.findByNameLikeIgnoreCase(e.getText() + "%");
            table.setBeans(persons);
        });



        header.addComponent(searchByName);
        header.addComponent(button);

        listContainer.addComponent(header);
        listContainer.addComponent(table);

        this.addComponent(listContainer);

    }

}
