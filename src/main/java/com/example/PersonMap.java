package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by romuald on 20/05/2016.
 */
@UIScope
@SpringComponent
public class PersonMap extends VerticalLayout {

    @Autowired
    private UserRepository repo;

    LMap map = new LMap();

    public PersonMap() {
        this.setSizeFull();
        map.addLayer(new LOpenStreetMapLayer());
        addComponent(map);
        map.setSizeFull();
        setCaption("Map");
    }

    @PostConstruct
    void init() {
        List<Person> personsList = repo.findAll();
        for (Person person : personsList) {
            LMarker m = new LMarker(person.getLocation());
            m.addClickListener(e -> {

            });
            map.addComponent(m);
        }
        map.zoomToContent();
    }

}
