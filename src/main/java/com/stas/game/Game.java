package com.stas.game;

import com.stas.game.figurePack.Figure;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Класс ,реализующий методы процесса игры.
 */

public class Game {
    /**
     * Метод проверяет координаты ,введенные пользователм  на возможность хода/битья фигуры.
     *
     * @param a      начальная позиция фигуры.
     * @param b      конечная позиция фигуры.
     * @param method aviableMove/aviableEat.
     * @return true ,если по введеным пользователем координатам можно сходить/бить фигуру.
     */
    public static boolean validAction(Position a, Position b, Function<Figure, List> method) {
        Figure fig = Field.getInstance().getFigure(a.getX(), a.getY());
        List list = method.apply(fig);
        return list.stream().anyMatch(a1 -> Objects.equals(a1, b));
    }

    /**
     * Метод ,осуществляющий ход фигуры по игровому полю.
     *
     * @param from начальная позиция.
     * @param to   конечная позиция.
     */
    public static void moveFigure(Position from, Position to) {
        Figure temp;
        temp = Field.getInstance().getFigure(from.getX(), from.getY());
        temp.setX(to.getX());
        temp.setY(to.getY());
        Field.getInstance().addFigure(temp);
        Field.getInstance().getFiguresTable()[from.getX()][from.getY()] = null;
    }

    /**
     * Методо ,реализующий битье фигуры .
     *
     * @param from начальная позиция.
     * @param to   конечная позиция.
     */

    public static void eatFigure(Position from, Position to) {
        Field.getInstance().getFiguresTable()[to.getX()][to.getY()] = null;
        moveFigure(from, to);
    }
}
