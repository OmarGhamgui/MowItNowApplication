package com.example.mowitnow.entities;

public class Tondeuse {
    private int x;
    private int y;
    private char orientation;


    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void tournerDroite() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    public void tournerGauche() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
    }

    public void avancer(Pelouse pelouse) {
        switch (orientation) {
            case 'N':
                if (y < pelouse.getMaxY()) {
                    y++;
                }
                break;
            case 'E':
                if (x < pelouse.getMaxX()) {
                    x++;
                }
                break;
            case 'S':
                if (y > 0) {
                    y--;
                }
                break;
            case 'W':
                if (x > 0) {
                    x--;
                }
                break;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}