package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ,реализующий фигуру Конь.
 */
public class Knight extends Figure {

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "K";

    Knight(String name, int x, int y, String color) {
        super(name, x, y, color);
    }

    public List<Position> aviableMove() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            if (i == 0) continue;
            if ((x + 2) <= 7 && (y + i) <= 7 && (y + i) >= 0 && f[x + 2][y + i] == null) {
                positionList.add(new Position((x + 2), (y + i)));
            }
            if ((x - 2) >= 0 && (y + i) <= 7 && (y + i) >= 0 && f[x - 2][y + i] == null) {
                positionList.add(new Position((x - 2), (y + i)));
            }
            if ((y + 2) <= 7 && (x + i) <= 7 && (x + i) >= 0 && f[x + i][y + 2] == null) {
                positionList.add(new Position((x + i), (y + 2)));
            }
            if ((y - 2) >= 0 && (x + i) >= 0 && (x + i) <= 7 && f[x + i][y - 2] == null) {
                positionList.add(new Position((x + i), (y - 2)));
            }
        }
        return positionList;
    }

    public List<Position> aviableEat() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            if (i == 0) continue;
            if ((x + 2) <= 7 && (y + i) <= 7 && (y + i) >= 0 && f[x + 2][y + i] != null && !getColor().equals(f[x + 2][y + i].getColor())) {
                positionList.add(new Position((x + 2), (y + i)));
            }
            if ((x - 2) >= 0 && (y + i) <= 7 && (y + i) >= 0 && f[x - 2][y + i] != null && !getColor().equals(f[x - 2][y + i].getColor())) {
                positionList.add(new Position((x - 2), (y + i)));
            }
            if ((y + 2) <= 7 && (x + i) <= 7 && (x + i) >= 0 && f[x + i][y + 2] != null && !getColor().equals(f[x + i][y + 2].getColor())) {
                positionList.add(new Position((x + i), (y + 2)));
            }
            if ((y - 2) >= 0 && (x + i) >= 0 && (x + i) <= 7 && f[x + i][y - 2] != null && !getColor().equals(f[x + i][y - 2].getColor())) {
                positionList.add(new Position((x + i), (y - 2)));
            }
        }
        return positionList;
    }
}

