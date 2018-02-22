package com.gluonhq.samples.singleviewgvm;

import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BasicView extends View {

    private final CharmListView<USStates, Density.DENSITY> charmListView;
    private boolean ascending = true;

    private final FilteredList<USStates> filteredList;



    public BasicView(String name) {
        super(name);
        filteredList = new FilteredList<>(USStates.statesList, getStatePredicate(null));
        charmListView = new CharmListView<>(filteredList);
        charmListView.setCellFactory(p -> new USStateCell());
        charmListView.setHeadersFunction(Density::getDensity);
        charmListView.setHeaderCellFactory(p -> new CharmListCell<USStates>(){
            private final ListTile tile = new ListTile();
            {
                Avatar avatar = new Avatar(16, USStates.getUSFlag());
                tile.setPrimaryGraphic(avatar);
                setText(null);
            }
            @Override
            public void updateItem(USStates item, boolean empty){
                super.updateItem(item, empty);
                if (item != null && !empty){
                    tile.textProperty().setAll("Density", charmListView.toString(item));
                    setGraphic(tile);
                } else {
                    setGraphic(null);
                }
            }
        });

        charmListView.setConverter(new StringConverter<Density.DENSITY>() {//enum в стринг
            @Override
            public String toString(Density.DENSITY object) {
                return "From " + ((int) object.getIni()) + " up to " + ((int)object.getEnd()) + "pop/km" + "\u00B2";
            }

            @Override
            public Density.DENSITY fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        charmListView.setFloatingHeaderVisible(false);

        setCenter(charmListView);
    }


    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.STAR.button());
        appBar.setTitleText("50States");

        Button sort = MaterialDesignIcon.SORT.button(e -> {
            if (ascending){
                charmListView.setHeaderComparator(Enum::compareTo);
                charmListView.setComparator(Comparator.comparingDouble(USStates::getDensity));
                ascending = false;
            } else {
                charmListView.setHeaderComparator(Comparator.reverseOrder());
                charmListView.setComparator((s1, s2) -> Double.compare(s2.getDensity(), s1.getDensity()));
                ascending = true;
            }
        });
        appBar.getActionItems().add(sort);
        appBar.getMenuItems().setAll(buildFilterMenu());
    }

    private List<MenuItem> buildFilterMenu() {
        final List<MenuItem> menu = new ArrayList<>();

        EventHandler<ActionEvent> menuActionHandler = e -> {
            MenuItem item = (MenuItem) e.getSource();
            Double population = (Double) item.getUserData();
            filteredList.setPredicate(getStatePredicate(population));
        };

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioMenuItem allStates = new RadioMenuItem("All States");
        allStates.setOnAction(menuActionHandler);
        allStates.setSelected(true);
        menu.add(allStates);
        toggleGroup.getToggles().add(allStates);

        List<Double> items = Arrays.asList(0.5, 1.0, 2.5, 5.0);
        for (Double d : items){
            RadioMenuItem item = new RadioMenuItem("Population > " + d + "M");
            item.setUserData(d);
            item.setOnAction(menuActionHandler);
            menu.add(item);
            toggleGroup.getToggles().add(item);
        }
        return menu;
    }

    private Predicate<USStates> getStatePredicate(Double population){
        return states -> population == null || states.getPopulation() >= population * 1_000_000;
    }


}
