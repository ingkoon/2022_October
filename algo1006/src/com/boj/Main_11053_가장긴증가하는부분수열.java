package com.boj;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_11053_가장긴증가하는부분수열 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
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
                System.out.println(Arrays.toString(lis));
                max = Math.max(max, lis[i]);
            }
            System.out.println(max);
        }
}
