package com.stas.game;

import com.stas.game.figurePack.Figure;

/**
 * Класс,реализующий игровое поле и методы доступа к игровому полю.
 */
public class Field {
    private Field() {
    }

    private static Field instance;

    public static Field getInstance() {
        if (instance == null)
            instance = new Field();
        return instance;
    }

    /**
     * Игровое поле
     */
    private Figure[][] figuresTable = new Figure[8][8];

    public Figure[][] getFiguresTable() {
        return figuresTable;
    }

    public void addFigure(Figure figure) {
        figuresTable[figure.getX()][figure.getY()] = figure;
    }

    public Figure getFigure(int x, int y) {
        return figuresTable[x][y];
    }
}



