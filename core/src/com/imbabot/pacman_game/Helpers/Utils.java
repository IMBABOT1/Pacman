package com.imbabot.pacman_game.Helpers;

public class Utils {

    public static int getCellIntDistance(int x1, int y1, int x2, int y2){
        return(int) Math.sqrt(x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }


    public static float getCellFloatDistance(int x1, int y1, int x2, int y2){
        return(float) Math.sqrt(x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    public static boolean cellsIsNeighbors(int x1, int y1, int x2, int y2){
        return Math.abs(x2 - x1) + Math.abs(y2 - y1) == 1;
    }
}
