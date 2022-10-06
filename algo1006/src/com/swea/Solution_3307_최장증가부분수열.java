package com.swea;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3307_최장증가부분수열 {
    static int T;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        T = sc.nextInt();

        for (int t = 1; t <= T; t++){
               n = sc.nextInt();
               int[] arr = new int[n];
               int[] lis = new int[n];
               for (int i = 0; i < n; i++) {
                   arr[i] = sc.nextInt();
               }
               int max = 0;
            for (int i = 0; i < n; i++) {
                lis[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(arr[j]<arr[i] && lis[i] < lis[j]+1){
                        lis[i] = lis[j]+1;
                    }
                }
                max = Math.max(max, lis[i]);
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}
