package com.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_17471_게리맨더링 {
    static int n, result;
    static int[] size;
    static boolean[] visited;
    static List<List<Integer>> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = sc.nextInt();
        }
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                list.add(sc.nextInt());
            }
            map.add(list);
        }
    }

    static void subSet(int cnt){
        if(cnt == n){
            int tmp = comp();
            result = Math.max(tmp , result);
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1);
        visited[cnt] = false;
        subSet(cnt+1);

    }

    static int comp(){

        return 0;
    }
}
