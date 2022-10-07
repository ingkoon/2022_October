package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

    static int r, c;
    static boolean visited[][];
    static int[][] dish;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dish = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < c; j++) {
                dish[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int tmp = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(dish[i][j] == 1)  tmp ++;
            }
        }

        while(true){
            cnt ++;
            visited = new boolean[r][c];
            //공기 바꾸기
            bfsv2(0,0);

            // 치즈 녹이기
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(dish[i][j] == 1 && !visited[i][j]) bfs(i, j);
                }
            }

            // 남은 치즈조각 개수 세기
            int val = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(dish[i][j] == 1)  val ++;
                }
            }

            // 치즈가 다 녹아 사라졌다면
            if(val == 0){
                System.out.println(cnt);
                System.out.println(tmp);
                break;
            }else{
                tmp = val;
            }

        }
    }


    // 외부 공기에 닿는 치즈를 판별하기 위한 bfs
    static void bfs(int pr, int pc){
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(pr, pc));
        visited[pr][pc] = true;
//
//        int[][] cloneDish = new int[r][c];
//        for (int i = 0; i < r; i++) {
//            cloneDish[i] = dish[i].clone();
//        }
        if(!isWhole(pr, pc)){
            dish[pr][pc] = 0;
        }
        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            int tr = loc.r;
            int tc = loc.c;
            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc = tc + dc[i];
                if(isWhole(nr, nc) || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dish[nr][nc] = 0;
                queue.offer(new Loc(nr, nc));
            }
        }

//        for (int i = 0; i < r; i++) {
//            dish[i] = cloneDish[i].clone();
//        }
    }

    // 외부의 공기가 닿지않는 지점을 판별하기 위한 bfs
    static void bfsv2(int pr, int pc){
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(pr, pc));
        dish[pr][pc]= 2;
        visited[pr][pc] = true;

        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            int tr = loc.r;
            int tc = loc.c;
            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc = tc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || dish[nr][nc]== 1) continue;
                dish[nr][nc] = 2;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc));
            }
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
    static boolean isCheckCheese(int nr, int nc){
        return 1<= nr && nr < r-1 && 1 <= nc && nc < c-1;
    }
    static boolean isWhole(int tr, int tc){
        for (int i = 0; i < 4; i++) {
            int nr = tr + dr[i];
            int nc = tc + dc[i];
            if(!isCheckCheese(tr, tc) || dish[nr][nc] == 2) return false;
        }
        return true;
    }
    static class Loc {
        int r;
        int c;
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/*
5 5
0 0 0 0 0
0 1 1 0 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0


3 3
0 0 0
0 0 0
0 0 0
 */