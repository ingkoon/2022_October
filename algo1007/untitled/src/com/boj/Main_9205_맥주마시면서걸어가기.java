package com.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기 {
    static int T;
    static List<Loc> list;
    static int SIZE ;
    static int INF = 1000001;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            list = new ArrayList<>();
            SIZE = n + 2;

            for (int i = 0; i < n + 2; i++) list.add(new Loc(sc.nextInt() , sc.nextInt()));

            map = new int [n+2][n+2];

            //INF 초기화
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                   map[i][j] = INF;
                }
            }

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(i == j) {
                        map[i][j] = 0;
                        continue;
                    }
                    int dis = Math.abs(list.get(i).r - list.get(j).r) + Math.abs(list.get(i).c - list.get(j).c);
                    map[i][j] = dis > 1000 ? INF : dis;
                }
            }

            for (int k = 0; k < SIZE; k++) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        map[i][j] = Math.min(map[i][j], map[k][j] + map[i][k]);
                    }
                }
            }

            System.out.println(map[0][n+1] != INF ? "happy" : "sad");
        }
    }

    static class Loc{
        int r, c;
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
