package controller;

import Event_Tester_Package.Test_Event;

import java.awt.*;

public class EventHandler {
    Test_Event eventTest;
    Container con;


    public void openShopEvent() {
        this.eventTest = new Test_Event();
        eventTest.test_shop0(con);
    }
}
