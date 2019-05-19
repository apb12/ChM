package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * Класс,реализующий фигуру Ладья.
 */
public class Rook extends Figure {

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "Л";

    Rook(String name,Position p, String color) {
        super(name, p, color);
    }

    public Set<Position> aviableMove() {
        Set<Position> positionList = new HashSet<>();
        iterateMove(positionList, 1, 0);
        iterateMove( positionList,0, 1);
        iterateMove(positionList,-1, 0);
        iterateMove( positionList,0, -1);
        return positionList;

    }

    public Set<Position> aviableEat() {
        Set<Position> positionList = new HashSet<>();
        iterateEat(positionList, 1, 0);
        iterateEat(positionList, 0, 1);
        iterateEat(positionList, -1, 0);
        iterateEat(positionList, 0, -1);
        return positionList;

    }
}


