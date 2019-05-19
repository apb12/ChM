package com.stas.game.figurePack;

import com.stas.game.Field;
import com.stas.game.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Базовый класс для всех фигур.Инскапсулирует игровое поле.
 */

public abstract class Figure {
    protected Figure[][] f = Field.getInstance().getFiguresTable();

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    protected Position p;
    private String ch;
    private String name;
    private String color;

    public String getCh() {
        return ch;
    }

    public String getColor() {
        return color;
    }


    public Figure() {
    }

    public Figure(String name,Position p, String color) {

        this.p=p;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод ,возвращающий список доступных ходов.
     */
    abstract public Set<Position> aviableMove();

    /**
     * Метод ,возвращающий список доступных фигур для битья.
     */

    abstract public Set<Position> aviableEat();

    public void iterateMove(Set<Position> positions,int px, int py) {
        for (int i = 1; i <= 7; i++) {
            int mx = p.getX() + px * i;
            int my = p.getY() + py * i;
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] == null)
                positions.add(new Position(mx, my));
            else break;
        }
        positions.remove(new Position(p.getX(),p.getY()));
    }

    public void iterateEat(Set<Position> positions, int px, int py) {
        for (int i = 1; i <= 7; i++) {
            int mx = p.getX() + px * i;
            int my = p.getY() + py * i;
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] != null && getColor().equals(f[mx][my].getColor())) {
                break;
            }
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] != null && !getColor().equals(f[mx][my].getColor())) {
                positions.add(new Position(mx, my));
                break;
            }
            positions.remove(new Position(p.getX(), p.getY()));
        }

    }
}
