package com.boj;

import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기 {
    static int T;
    static int n, sR, sC, pR, pC;
    static int SIZE = 32768 * 2;

    static int[][] map;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            sR = sc.nextInt();
            sC = sc.nextInt();
            pR = sc.nextInt();
            pC = sc.nextInt();

        }
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < SIZE && 0 <= nc && nc < SIZE;
    }

    static class Sanggeun{
        int r;
        int c;
        int energy;
        int beer;
        public Sanggeun(int r, int c, int energy, int beer) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.beer = beer;
        }
    }
}
