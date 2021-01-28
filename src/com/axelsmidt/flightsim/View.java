package com.axelsmidt.flightsim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends JPanel implements ActionListener {
    private Timer timer;
    private Model model;

    public View() {
        this.model = new Model();
        this.timer = new Timer(0, this);
        this.timer.start();
        this.setBackground(Color.BLACK);
    }

    public void drawGrid(Graphics g, int interval) {
        g.setColor(new Color(30, 30, 30));

        int screenWidth = this.getWidth();
        int screenHeight = this.getHeight();

        // Drawing a vertical line for every "interval" degrees of longitude
        int lonLineInterval = screenWidth / (360 / interval);

        // Drawing a horizontal line for every "interval" degrees of latitude
        int latLineInterval = screenHeight / (180 / interval);

        // Drawing longitudinal lines, western hemisphere
        for (int i = (screenWidth / 2); i > 0; i = i - lonLineInterval) {
            g.drawLine(i, 0, i, screenHeight);
        }

        // Drawing longitudinal lines, eastern hemisphere
        for (int i = ((screenWidth / 2) + lonLineInterval); i < screenWidth; i = i + lonLineInterval) {
            g.drawLine(i, 0, i, screenHeight);
        }

        // Drawing latitudinal lines, northern hemisphere
        for (int i = (screenHeight / 2); i > 0; i = i - latLineInterval) {
            g.drawLine(0, i, screenWidth, i);
        }

        // Drawing latitudinal lines, southern hemisphere
        for (int i = ((screenHeight / 2) + latLineInterval); i < screenHeight; i = i + latLineInterval) {
            g.drawLine(0, i, screenWidth, i);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawGrid(g, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        this.repaint();
    }
}
