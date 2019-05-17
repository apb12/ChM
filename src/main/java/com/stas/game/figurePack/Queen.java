package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий фигуру Ферзь.
 */
public class Queen extends Figure {


    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "Ф";

    Queen(String name, int x, int y, String color) {
        super(name, x, y, color);
    }

    public List<Position> aviableMove() {
        List<Position> positionList = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && f[x + i][y] == null) {
                positionList.add(new Position((x + i), y));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((x - i) >= 0 && f[x - i][y] == null) {
                positionList.add(new Position((x - i), y));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((y + i) <= 7 && f[x][y + i] == null) {
                positionList.add(new Position(x, (y + i)));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((y - i) >= 0 && f[x][y - i] == null) {
                positionList.add(new Position(x, (y - i)));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && (y + i) <= 7 && f[x + i][y + i] == null) {
                positionList.add(new Position((x + i), (y + i)));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((x - i) >= 0 && (y - i) >= 0 && f[x - i][y - i] == null) {
                positionList.add(new Position((x - i), (y - i)));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((x - i) >= 0 && (y + i) <= 7 && f[x - i][y + i] == null) {
                positionList.add(new Position((x - i), (y + i)));
            } else break;
        }
        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && (y - i) >= 0 && f[x + i][y - i] == null) {
                positionList.add(new Position((x + i), (y - i)));
            } else break;
        }
        return positionList;
    }

    @Override
    public List<Position> aviableEat() {
        List<Position> positionList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && f[x + i][y] != null && getColor().equals(f[x + i][y].getColor())) {
                break;
            }
            if ((x + i) <= 7 && f[x + i][y] != null && !getColor().equals(f[x + i][y].getColor())) {
                positionList.add(new Position((x + i), y));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {

            if ((x - i) >= 0 && f[x - i][y] != null && getColor().equals(f[x - i][y].getColor())) {
                break;
            }
            if ((x - i) >= 0 && f[x - i][y] != null && !getColor().equals(f[x - i][y].getColor())) {
                positionList.add(new Position((x - i), y));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if ((y + i) <= 7 && f[x][y + i] != null && getColor().equals(f[x][y + i].getColor())) {
                break;
            }
            if ((y + i) <= 7 && f[x][y + i] != null && !getColor().equals(f[x][y + i].getColor())) {
                positionList.add(new Position(x, (y + i)));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if ((y - i) >= 0 && f[x][y - i] != null && getColor().equals(f[x][y - i].getColor())) {
                break;
            }
            if ((y - i) >= 0 && f[x][y - i] != null && !getColor().equals(f[x][y - i].getColor())) {
                positionList.add(new Position(x, (y - i)));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && (y + i) <= 7 && f[x + i][y + i] != null && getColor().equals(f[x + i][y + i].getColor())) {
                break;
            }
            if ((x + i) <= 7 && (y + i) <= 7 && f[x + i][y + i] != null && !getColor().equals(f[x + i][y + i].getColor())) {
                positionList.add(new Position((x + i), (y + i)));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if ((x - i) >= 0 && (y - i) >= 0 && f[x - i][y - i] != null && getColor().equals(f[x - i][y - i].getColor())) {
                break;
            }
            if ((x - i) >= 0 && (y - i) >= 0 && f[x - i][y - i] != null && !getColor().equals(f[x - i][y - i].getColor())) {
                positionList.add(new Position((x - i), (y - i)));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {

            if ((x - i) >= 0 && (y + i) <= 7 && f[x - i][y + i] != null && getColor().equals(f[x - i][y + i].getColor())) {
                break;
            }
            if ((x - i) >= 0 && (y + i) <= 7 && f[x - i][y + i] != null && !getColor().equals(f[x - i][y + i].getColor())) {
                positionList.add(new Position((x - i), (y + i)));
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if ((x + i) <= 7 && (y - i) >= 0 && f[x + i][y - i] != null && getColor().equals(f[x + i][y - i].getColor())) {
                break;
            }
            if ((x + i) <= 7 && (y - i) >= 0 && f[x + i][y - i] != null && !getColor().equals(f[x + i][y - i].getColor())) {
                positionList.add(new Position((x + i), (y - i)));
                break;
            }
        }
        return positionList;
    }
}
