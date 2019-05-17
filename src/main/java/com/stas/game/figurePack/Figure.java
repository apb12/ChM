package com.stas.game.figurePack;

import com.stas.game.Field;
import com.stas.game.Position;

import java.util.List;
import java.util.Set;

/**
 * Базовый класс для всех фигур.Инскапсулирует игровое поле.
 */

public abstract class Figure {
    protected Figure[][] f = Field.getInstance().getFiguresTable();
    protected int x, y;
    private String ch;
    private String name;
    private String color;

    public String getCh() {
        return ch;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Figure() {
    }

    public Figure(String name, int x, int y, String color) {

        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод ,возвращающий список доступных ходов.
     */
    abstract public List<Position> aviableMove();

    /**
     * Метод ,возвращающий список доступных фигур для битья.
     */

    abstract public List<Position> aviableEat();

    public void iterateMove(Set<Position> positions, int px, int py) {
        for (int i = 1; i <= 7; i++) {
            int mx = x + px * i;
            int my = y + py * i;
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] == null)
                positions.add(new Position(mx, my));
            else break;
        }
        positions.remove(new Position(x, y));
    }

    public void iterateEat(Set<Position> positions, int px, int py) {
        for (int i = 1; i <= 7; i++) {
            int mx = x + px * i;
            int my = y + py * i;
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] != null && getColor().equals(f[mx][my].getColor())) {
                break;
            }
            if (mx > -1 && mx < 8 && my > -1 && my < 8 && f[mx][my] != null && !getColor().equals(f[mx][my].getColor())) {
                positions.add(new Position(mx, my));
                break;
            }
            positions.remove(new Position(x, y));
        }

    }
}
