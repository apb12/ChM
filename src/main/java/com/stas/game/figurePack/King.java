package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий фигуру Король.
 */
public class King extends Figure {

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "Z";


    King(String name, int x, int y, String color) {
        super(name, x, y, color);
    }

    public List<Position> aviableMove() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if ((x + i) == -1 || (x + i) == 8) continue;
                if ((y + j) == -1 || (y + j) == 8) continue;

                if (f[x + i][y + j] == null)

                    positionList.add(new Position((x + i), (y + j)));
            }
        }
        return positionList;
    }

    public List<Position> aviableEat() {
        List<Position> positionList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if ((x + i) == -1 || (x + i) == 8) continue;
                if ((y + j) == -1 || (y + j) == 8) continue;
                if (f[x + i][y + j] != null && !f[x][y].getColor().equals(f[x + i][y + j].getColor()))
                    positionList.add(new Position((x + i), (y + j)));
            }
        }
        return positionList;
    }
}



