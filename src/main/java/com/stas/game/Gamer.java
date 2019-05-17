package com.stas.game;

import com.stas.game.figurePack.Figure;

import java.util.Scanner;

import static com.stas.game.Game.eatFigure;
import static com.stas.game.Game.moveFigure;
import static com.stas.game.Game.validAction;

/**
 * Класс,реализующий игрока.
 */
public class Gamer {
    private String color;

    String getColor() {
        return color;
    }

    Gamer(String color) {
        this.color = color;
    }

    /**
     * Метод,проверяющий цвет игрока и фигуры.
     *
     * @param figure проверяемая фигура.
     * @return true, если цвет фигуры и игрока совпадает.
     */
    public boolean checkGamerColor(Figure figure) {
        return getColor().equals(figure.getColor());
    }

    /**
     * Метод ,обрабатывает вводные координаты ,проверяет на валидность и делает ход/битье фигуры ,если это возможно.
     *
     * @param s координата в шахматном формате.
     * @throws Exception выкижывается исключение,если по вводным координатам нет возможности сделать ход/бить фигуру.
     */
    public void move(String s) throws Exception {
        String from = s.split("-", 2)[0].toLowerCase();
        String to = s.split("-", 2)[1].toLowerCase();
        Position a = new Position(Interpritator.reverseInter(from).get(0), Interpritator.reverseInter(from).get(1));
        Position b = new Position(Interpritator.reverseInter(to).get(0), Interpritator.reverseInter(to).get(1));
        if (validAction(a, b, Figure::aviableEat) && checkGamerColor(Field.getInstance().getFigure(a.getX(), a.getY()))) {
            eatFigure(a, b);
        } else if (validAction(a, b, Figure::aviableMove) && checkGamerColor(Field.getInstance().getFigure(a.getX(), a.getY()))) {
            moveFigure(a, b);
        } else {
            throw new Exception();
        }
    }

    /**
     * Метод,реализующий замкнутый цикл,до тех пор,пока не будут введены корректные координаты ,произойдет ход/битье фигуры и
     * ход передастся другому игроку.
     */
    public void doMove() {
        boolean b;
        String clr;
        if (color.equals("White")) {
            clr = "Ход белого игрока";
        } else {
            clr = "Ход черного игрока";
        }
        do {
            try {
                System.out.println(clr);
                System.out.println("Введите координату в формате e2-a4");
                Scanner sc = new Scanner(System.in);
                move(sc.nextLine());
                b = false;
            } catch (Exception e) {
                System.err.println("Введите корректные координаты");
                b = true;
            }
        } while (b);
    }
}

