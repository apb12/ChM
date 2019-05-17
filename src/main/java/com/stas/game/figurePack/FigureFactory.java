package com.stas.game.figurePack;

/**
 * Класс фабрика по произодству фигур.
 */
public class FigureFactory {
    private FigureFactory() {
    }

    private static FigureFactory instance;

    public static FigureFactory getInstance() {
        if (instance == null)
            instance = new FigureFactory();
        return instance;
    }

    public Figure createFigure(FigureList figureList, String name, int x, int y, String color) {
        Figure figure = null;
        switch (figureList) {
            case KING:
                figure = new King(name, x, y, color);
                break;
            case QUEEN:
                figure = new Queen(name, x, y, color);
                break;
            case PAWN:
                figure = new Pawn(name, x, y, color);
                break;
            case BISHOP:
                figure = new Bishop(name, x, y, color);
                break;
            case KNIGHT:
                figure = new Knight(name, x, y, color);
                break;
            case ROOK:
                figure = new Rook(name, x, y, color);
                break;
        }
        return figure;
    }
}
