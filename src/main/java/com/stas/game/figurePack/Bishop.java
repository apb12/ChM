package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс,реализующий фигуру Слон.
 */

public class Bishop extends Figure {
    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();

    }

    private String ch = "C";

    Bishop(String name, Position p, String color) {
        super(name,p, color);
    }

public List<Position> aviableMove() {
    Set<Position> positionList = new HashSet<>();
    iterateMove(positionList, 1, 1);
    iterateMove(positionList, -1, -1);
    iterateMove(positionList, -1, 1);
    iterateMove(positionList, -1, 1);
    List<Position> positionList1 = new ArrayList<>(positionList);
    return positionList1;

}

    public List<Position> aviableEat() {
        Set<Position> positionList = new HashSet<>();
        iterateEat(positionList, 1, 1);
        iterateEat(positionList, -1, -1);
        iterateEat(positionList, -1, 1);
        iterateEat(positionList, 1, -1);
        List<Position> positionList1 = new ArrayList<>(positionList);
        return positionList1;

    }
}

