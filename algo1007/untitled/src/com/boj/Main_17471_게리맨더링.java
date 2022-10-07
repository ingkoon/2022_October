package com.boj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        visited = new boolean[n];

        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            size[i] = sc.nextInt();
        }

        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            for (int j = 0; j < tmp; j++) {
                map.get(i).add(sc.nextInt() - 1);
            }
        }
        subSet(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void subSet(int cnt){
        if(cnt == n){
            isCheck();
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1);
        visited[cnt] = false;
        subSet(cnt+1);
    }

    static void isCheck(){
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i] && conn(i, true)){
                tmp1 += size[i];
            }else if(!visited[i] && conn(i, false)){
                tmp2 += size[i];
            }
        }

        System.out.println(tmp1 + " " + tmp2);
        result = Math.min(result, Math.abs(tmp1 - tmp2));
    }
    
    // 배열로 선언해서 작업, true면 1번배열 false면 2번배열
    // 검사시 bfs를 사용해서 하나의 배열에 값이 포함되었나 확인할 것
    static boolean conn(int cnt, boolean flag){
        for (int i = 0; i < n; i++) {
            if(visited[i] && flag){
                if(map.get(i).contains(cnt)) return true;
            }else if (!visited[i] && !flag){
                if(map.get(i).contains(cnt)) return true;
            }
        }
        return false;
    }
}
