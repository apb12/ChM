package com.stas.game;

import com.stas.game.figurePack.Figure;
import com.stas.game.figurePack.FigureFactory;
import com.stas.game.figurePack.FigureList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Field field = Field.getInstance();
        List<Figure> list = Arrays.asList(
                FigureFactory.getInstance().createFigure(FigureList.KING, "king", 7, 3, "White"),
                FigureFactory.getInstance().createFigure(FigureList.QUEEN, "queen", 7, 4, "White"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knightLeft", 7, 1, "White"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knigtRight", 7, 6, "White"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopLeft", 7, 2, "White"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopRight", 7, 5, "White"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookLeft", 7, 0, "White"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookRight", 7, 7, "White"),
               // FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnOne", 6, 0, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnTwo", 6, 1, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnThree", 6, 2, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnFour", 6, 3, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnFive", 6, 4, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnSix", 6, 5, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnSeven", 6, 6, "White"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnEight", 6, 7, "White"),
                FigureFactory.getInstance().createFigure(FigureList.KING, "kingB", 0, 3, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.QUEEN, "queenB", 0, 4, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knightLeftB", 0, 6, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.KNIGHT, "knigtRightB", 0, 1, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopLeftB", 0, 5, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.BISHOP, "bishopRightB", 0, 2, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookLeftB", 0, 7, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.ROOK, "rookRightB", 0, 0, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnOneB", 1, 7, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnTwoB", 1, 6, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnThreeB", 1, 5, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnFourB", 1, 4, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnFiveB", 1, 3, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnSixB", 1, 2, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnSevenB", 1, 1, "Black"),
                FigureFactory.getInstance().createFigure(FigureList.PAWN, "pawnEightB", 1, 0, "Black"));
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
