package com.axelsmidt.flightsim;


import javax.swing.*;

public class FlightSim {
    public static void main(String[] args) {
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1800, 900);
        app.setVisible(true);
        View panel = new View();
        app.add(panel);
    }

}
