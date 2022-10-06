package com.swea;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
    static int T;
    static int INF = 1000001;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 0 && i != j) arr[i][j] = INF; // 갈 수 없는 곳은 INF로 초기화화                }
                }
            }

            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);

            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 0; j < n; j++) {
                     tmp += arr[i][j];
                }
                result = Math.min(result, tmp);
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}