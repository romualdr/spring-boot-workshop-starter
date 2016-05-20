package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
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

        PersonForm form = new PersonForm();

        header.addComponent(searchByName);

        listContainer.addComponent(header);
        listContainer.addComponent(table);

        table.addMValueChangeListener(e -> {
            Person value = e.getValue();
            form.setEntity(value);
        });

        form.setSavedHandler(person -> {
            form.setEntity(repo.save(person));
            table.setBeans(repo.findAll());
        });

        this.addComponent(listContainer);
        this.add(form);

    }

}
