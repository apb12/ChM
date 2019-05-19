package com.stas.game;

import com.stas.game.figurePack.Figure;
import com.stas.game.figurePack.FigureFactory;
import com.stas.game.figurePack.FigureList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Field field = Field.getInstance();
        List<Figure>  list = new ArrayList<>(Arrays.asList(
                FigureFactory.getInstance().createFigure(FigureList.KING, "king", new Position(7,3), "White"),
                FigureFactory.getInstance().createFigure(FigureList.QUEEN, "queen", new Position(7, 4), "White"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knightLeft", new Position(7, 1), "White"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knigtRight", new Position(7, 6), "White"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knightLeftB", new Position(0, 6), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knigtRightB", new Position(0, 1), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopLeft", new Position(7, 2), "White"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopRight", new Position(7, 5), "White"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookLeft", new Position(7, 0), "White"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookRight", new Position(7, 7), "White"),
                FigureFactory.getInstance().createFigure(FigureList.KING, "kingB", new Position(0, 3), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.QUEEN, "queenB", new Position(0, 4), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopLeftB", new Position(0, 5), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopRightB", new Position(0, 2), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookLeftB", new Position(0, 7), "Black"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookRightB", new Position(0, 0), "Black")));
        for (int i = 0; i <8 ; i++) {
            list.add(FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawn"+i, new Position(6, i), "White"));
            list.add(FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawn"+(7-i)+"B", new Position(1, i), "Black"));
        }
        list.forEach(field::addFigure);
        Gamer white = new Gamer("White");
        Gamer black = new Gamer("Black");
        Menu menu = new Menu();
        menu.printMenu();
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                switch (sc.nextInt()) {

                    case 0:
                        menu.printMenu();
                        break;
                    case 1:
                        menu.print();
                        break;
                    case 2:
                        menu.printMove();
                        break;
                    case 3:
                        menu.print();
                        white.doMove();
                        menu.print();
                        black.doMove();
                        menu.print();
                        menu.printMenu();
                        break;
                    case 4:
                        menu.exitGameMenu();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Введите корректный пункт меню");
                menu.printMenu();
            }
        }
    }
}
