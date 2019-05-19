package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс, реализующий фигуру Король.
 */
public class King extends Figure {

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "Z";


    King(String name,Position p, String color) {
        super(name,p, color);
    }

    public Set<Position> aviableMove() {
        Set<Position> positionList = new HashSet<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if ((p.getX() + i) == -1 || (p.getX() + i) == 8) continue;
                if ((p.getY() + j) == -1 || (p.getY() + j) == 8) continue;

                if (f[p.getX() + i][p.getY() + j] == null)

                    positionList.add(new Position((p.getX() + i), (p.getY() + j)));
            }
        }
        return positionList;
    }

    public Set<Position> aviableEat() {
        Set<Position> positionList = new HashSet<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if ((p.getX() + i) == -1 || (p.getX() + i) == 8) continue;
                if ((p.getY() + j) == -1 || (p.getY() + j) == 8) continue;
                if (f[p.getX() + i][p.getY() + j] != null && !f[p.getX()][p.getY()].getColor().equals(f[p.getX() + i][p.getY() + j].getColor()))
                    positionList.add(new Position((p.getX() + i), (p.getY() + j)));
            }
        }
        return positionList;
    }
}



