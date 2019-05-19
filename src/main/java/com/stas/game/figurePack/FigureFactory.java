package com.stas.game.figurePack;

import com.stas.game.Position;

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

    public Figure createFigure(FigureList figureList, String name, Position p, String color) {
        Figure figure = null;
        switch (figureList) {
            case KING:
                figure = new King(name,p, color);
                break;
            case QUEEN:
                figure = new Queen(name, p, color);
                break;
            case PAWN:
                figure = new Pawn(name, p, color);
                break;
            case BISHOP:
                figure = new Bishop(name, p, color);
                break;
            case KNIGHT:
                figure = new Knight(name,p, color);
                break;
            case ROOK:
                figure = new Rook(name,p, color);
                break;
        }
        return figure;
    }
}
