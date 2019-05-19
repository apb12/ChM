package com.stas.game;

import java.util.List;

/**
 * Класс,реализующий методы распечатки ходов.
 */
public class Printer {
    /**
     * Метод распечатывает доступные ходы из списка.
     *
     * @param p список доступных ходов.
     */
    public static void printPosition(List<Position> p) {
        if (p.size() >= 1) {
            for (Position aP : p) {
                System.out.println("Доступные ходы :" + Interpritator.inter(aP.getX(), aP.getY()));
            }
        } else System.out.println("Нет доступных ходов");
    }

    public static void printEat(List<Position> p) {
        /**
         * Метод распечатывает имена фигур,доступных для битья.
         * @param p список фигур,доступных для битья.
         */
        for (Position aP : p) {
            System.out.println("Вы можете съесть фигуру: " + Field.getInstance().getFigure(aP).getName());
        }
    }
}