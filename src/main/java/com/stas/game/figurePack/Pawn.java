package com.stas.game.figurePack;


import com.stas.game.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс,реализующий фигуру Пешка.
 */
public class Pawn extends Figure {

    private String ch = "S";

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    Pawn(String name, int x, int y, String color) {
        super(name, x, y, color);
    }

    @Override
    public List<Position> aviableMove() {
        List<Position> positionList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            if (getColor().equalsIgnoreCase("White")) {
                if (x >= 1 && f[x - i][y] != null) {
                    break;
                } else positionList.add(new Position((x - i), y));
            } else {
                if (x <= 6 && f[x + i][y] != null) {
                    break;
                } else positionList.add(new Position((x + i), y));
            }
        }
        return positionList;
    }

    @Override
    public List<Position> aviableEat() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            if (i == 0) continue;
            if ((y + i) == -1 || (y + i) == 8) continue;
            if (f[x][y].getColor().equalsIgnoreCase("White")) {
                if (x >= 1 && f[x - 1][y + i] != null && !getColor().equals(f[x - 1][y + i].getColor())) {
                    positionList.add(new Position((x - 1), (y + i)));
                }
            }
            if (f[x][y].getColor().equalsIgnoreCase("Black")) {
                if (x <= 6 && f[x + 1][y + i] != null && !getColor().equals(f[x + 1][y + i].getColor())) {
                    positionList.add(new Position((x + 1), (y + i)));
                }
            }
        }
        return positionList;
    }
}
