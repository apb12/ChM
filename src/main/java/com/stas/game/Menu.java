package com.stas.game;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Класс ,реализующий методы консольного меню.
 */
public class Menu {
    /**
     * Метод ,распечатывающий пукнты меню.
     */

    public void printMenu() {
        out.println("------------------------");
        out.println("        Меню ");
        out.println("0 -Вызов меню ");
        out.println("1 -Вывод поля ");
        out.println("2 -Показать доступные ходы ");
        out.println("3 -Сделать ход");
        out.println("4 -Закончить игру");
        out.println("-------------------------");
    }

    /**
     * Метод,распечатывающий игровое поле
     */
    public void print() {

        String[][] table = new String[8][8];
        for (int i = 0; i < Field.getInstance().getFiguresTable().length; i++) {
            for (int j = 0; j < Field.getInstance().getFiguresTable()[i].length; j++) {
                if (Field.getInstance().getFiguresTable()[i][j] == null) {
                    table[i][j] = " ";
                } else table[i][j] = Field.getInstance().getFiguresTable()[i][j].getCh();
            }
            out.println((8 - i) + Arrays.toString(table[i]));
        }
        out.println("  a  b  c  d  e  f  g  h ");
    }

    /**
     * Метод,распечатывающий доступные ходы/фигуры для битья.
     */
    public void printMove() {
        boolean b;
        out.println("Введите координату");
        Scanner sc1 = new Scanner(in);
        do {
            try {
                String s = sc1.nextLine();
                int tempX = Interpritator.reverseInter(s).get(0);
                int tempY = Interpritator.reverseInter(s).get(1);
                out.println("Для фигуры " + Field.getInstance().getFigure(tempX, tempY).getName());
                Printer.printPosition(Field.getInstance().getFigure(tempX, tempY).aviableMove());
                Printer.printEat(Field.getInstance().getFigure(tempX, tempY).aviableEat());
                b = false;
            } catch (Exception e) {
                e.printStackTrace();
                err.println("неверная координата,повторите ввод");
                b = true;
            }
        } while (b);
    }

    /**
     * Метод,реализующий выход из игры.
     */
    public void exitGameMenu() {
        out.println("Game Over");
        exit(0);
    }
}