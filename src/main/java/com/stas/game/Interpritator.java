package com.stas.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс,интерпретирующий координаты игрового поля.
 */
public class Interpritator {
    /**
     * Метод ,преобразующий координаты игрового поля и возвращающий их в шахматном стандарте.
     *
     * @param x координата оси Х.
     * @param y координата оси У.
     * @return возвращает строковый список в виде [е 2],[b 7].
     */

    public static List<String> inter(int x, int y) {
        List<String> listCords = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(0, "a");
            put(1, "b");
            put(2, "c");
            put(3, "d");
            put(4, "e");
            put(5, "f");
            put(6, "g");
            put(7, "h");
        }};
        listCords.add(map.get(y));
        listCords.add(String.valueOf((8 - x)));
        return listCords;
    }

    /**
     * Метод,преобразующий введенные пользователем координаты в щахматном формате в кординаты игрового поля.
     *
     * @param s строка координат,введенная пользователем.
     * @return возвращает список Integer где первое значениие координата Х,второе значение координата У.
     */
    public static List<Integer> reverseInter(String s) {
        List<Integer> listCords = new ArrayList<>();
        listCords.add(8 - Integer.valueOf("" + s.charAt(1)));
        Map<Character, Integer> mapReverse = new HashMap<Character, Integer>() {{
            put('a', 0);
            put('b', 1);
            put('c', 2);
            put('d', 3);
            put('e', 4);
            put('f', 5);
            put('g', 6);
            put('h', 7);
        }};
        listCords.add(mapReverse.get(s.charAt(0)));
        return listCords;
    }
}
