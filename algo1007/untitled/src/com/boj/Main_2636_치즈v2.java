package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2636_치즈v2 {

    static int r, c;
    static int[][] dish;
    static int[][] clone;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        dish = new int[r][c];
        clone = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dish[i][j] = sc.nextInt();
            }
        }

        int checking = 0;
        int three = 0;
        while (counting(dish)!=0){
            checking++;
            copyto(dish, clone);
            bounday(0,0,2);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(dish[i][j]==1){
                        go(i, j);
                    }
                }
            }
        }

    }

    private static void go(int pr, int pc) {
        if(!check(pr, pc)) return;
        int tot = 0;
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if(!check(nr, nc))continue;
            if(clone[nr][nc] == 2){
                tot++;
            }
        }
        dish[pr][pc] = tot >=1 ? 3 : 1; // 제거할 위치 C 체크
    }

    private static void bounday(int pr, int pc, int v) {
        clone[pr][pc] = v;
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if(!check(nr, nc))continue;
            if(clone[nr][nc] == 0){
                bounday(nr, nc, v);
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return 0 < nr && nr < r && 0 < nc && nc < c;
    }

    private static void copyto(int[][] dish, int[][] clone) {
        for (int i = 0; i < r; i++) {
            System.arraycopy(dish[i], 0, clone[i], 0, c);
        }
    }


    private static int counting(int[][] dish) {
        int tot = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(dish[i][j] == 1) tot++;
            }
        }
        return tot;
    }
}
