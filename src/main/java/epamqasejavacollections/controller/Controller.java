package epamqasejavacollections.controller;

import epamqasejavacollections.model.Airline;
import epamqasejavacollections.view.View;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    protected static final double STARTFUELCONSUMPTION = 8.7; //litres per km
    protected static final double ENDFUELCONSUMPTION = 9.3;
    protected static Airline airline;
    protected static View view;
    private Scanner scanner = new Scanner(System.in);
    private Map<String, MenuItem> menuItemsMap = new HashMap<>();


    public Controller() {
        this.view = new View();
    }

    public void initController() {
        initAirline();
        menuItemsMap.put("1", MenuItem.ONE);
        menuItemsMap.put("2", MenuItem.TWO);
        menuItemsMap.put("3", MenuItem.THREE);
        menuItemsMap.put("4", MenuItem.FOUR);
        menuItemsMap.put("5", MenuItem.FIVE);
        menuItemsMap.put("Q", MenuItem.QUIT);

        menu();

    }

    private void initAirline() {
        airline = new Airline();
        airline.init();
    }

    private void menu() {
        view.printMenuItems();
        String stringMenuItem = scanner.next();
        try { // My try to use this: https://www.javacodegeeks.com/2019/03/featured-enum-instead-switch.html
            MenuItem menuItem = menuItemsMap.get(stringMenuItem.toUpperCase(Locale.ROOT));
            menuItem.action();
        }catch (NullPointerException e) {
            menu();
        }
        menu();
    }

}
