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

    Pawn(String name,Position p, String color) {
        super(name,p, color);
    }

    @Override
    public List<Position> aviableMove() {
        List<Position> positionList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            if (getColor().equalsIgnoreCase("White")) {
                if (p.getX() >= 1 && f[p.getX() - i][p.getY()] != null) {
                    break;
                } else positionList.add(new Position((p.getX() - i), p.getY()));
            } else {
                if (p.getX() <= 6 && f[p.getX() + i][p.getY()] != null) {
                    break;
                } else positionList.add(new Position((p.getX() + i), p.getY()));
            }
        }
        return positionList;
    }

    @Override
    public List<Position> aviableEat() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            if (i == 0) continue;
            if ((p.getY() + i) == -1 || (p.getY() + i) == 8) continue;
            if (getColor().equalsIgnoreCase("White")) {
                if (p.getX() >= 1 && f[p.getX() - 1][p.getY() + i] != null && !getColor().equals(f[p.getX() - 1][p.getY() + i].getColor())) {
                    positionList.add(new Position((p.getX() - 1), (p.getY() + i)));
                }
            }
            if (getColor().equalsIgnoreCase("Black")) {
                if (p.getX() <= 6 && f[p.getX() + 1][p.getY() + i] != null && !getColor().equals(f[p.getX() + 1][p.getY() + i].getColor())) {
                    positionList.add(new Position((p.getX() + 1), (p.getY() + i)));
                }
            }
        }
        return positionList;
    }
}
