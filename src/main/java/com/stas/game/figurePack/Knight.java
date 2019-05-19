package com.stas.game.figurePack;

import com.stas.game.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс ,реализующий фигуру Конь.
 */
public class Knight extends Figure {

    public String getCh() {
        return (getColor().equalsIgnoreCase("White")) ? ch : ch.toLowerCase();
    }

    private String ch = "K";

    Knight(String name,Position p, String color) {
        super(name,p, color);
    }
    @Override
    public void iterateMove(Set<Position> positions, int px, int py) {
        for (int i = -1; i <2; i++) {
            if(i==0)continue;
            int mx = p.getX() + px;
            int my = p.getY() + py;
            if(px==0){
                mx=mx+i;
            }else my=my+i;

            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] == null)
                positions.add(new Position(mx, my));
        }

    } @Override
    public void iterateEat(Set<Position> positions, int px, int py) {
        for (int i = -1; i <2; i++) {
            if(i==0)continue;
            int mx = p.getX() + px;
            int my = p.getY() + py;
            if(px==0){
                mx=mx+i;
            }else my=my+i;

            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] != null&&!getColor().equals(f[mx][my].getColor()))
                positions.add(new Position(mx, my));
        }

    }
    public List<Position> aviableMove() {
        Set<Position> positionList = new HashSet<>();
        iterateMove(positionList, 2, 0);
        iterateMove(positionList, -2, 0);
        iterateMove(positionList, 0, 2);
        iterateMove(positionList, 0, -2);
        List<Position> positionList1 = new ArrayList<>(positionList);
        return positionList1;

    }  public List<Position> aviableEat() {
        Set<Position> positionList = new HashSet<>();
        iterateEat(positionList, 2, 0);
        iterateEat(positionList, -2, 0);
        iterateEat(positionList, 0, 2);
        iterateEat(positionList, 0, -2);
        List<Position> positionList1 = new ArrayList<>(positionList);
        return positionList1;

    }


}

