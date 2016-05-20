package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class VaadinUI extends UI {
    
    @Autowired
    PersonsView personsView;
    
    @Autowired
    UserGroupView groupView;

    @Autowired
    PersonMap personMap;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TabSheet tabSheet = new TabSheet(personsView, groupView, personMap);
        tabSheet.addStyleName(ValoTheme.TABSHEET_CENTERED_TABS);
        tabSheet.setSizeFull();
        setContent(tabSheet);

    }
}
