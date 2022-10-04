package com.swea;

public class Solution_1249 {

    static int n;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    private static int dijkstra(int startR, int startC){

        // 출발지에서 자신으로 의 최소비용을 저장할 배열생성
        int[][] minCost = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minCost[i][j] = INF;
            }
        }

        // 출발지에서 출발지로의 최소비용 0처리
        minCost[startR][startC] = 0;
        int r, c, nr, nc, minTime;

        while(true){


        }

        for (int i = 0; i < n; i++) {
            minCost[i][i] = 0;
        }
        return 1;
    }
}
