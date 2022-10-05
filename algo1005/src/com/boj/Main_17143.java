package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17143 {
    static int r, c, m;
    static Shark[][] sea;
    static List<Shark> sharks;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static StringTokenizer st;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sea = new Shark[r][c];
        sharks = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int sr = Integer.parseInt(st.nextToken())-1;
            int sc = Integer.parseInt(st.nextToken())-1;
            int ss = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int sz = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(sr, sc, ss, sd, sz);
            sea[sr][sc] = shark;
            sharks.add(shark);
        }
        work();
        System.out.println(result);
    }

    private static void work() {
        int sR = 0;
        int sC = -1;

        for (int i = 0; i < c; i++) {
            sC++;
            fishing(sC);
            move();
            replace();
        }
    }

    private static void replace() {
        sea = new Shark[r][c];
        for (Shark shark: sharks) {
            if(!shark.live) continue;
            if(sea[shark.sR][shark.sC] != null){
                if(sea[shark.sR][shark.sC].z > shark.z){
                    shark.live = false;
                } else{
                    sea[shark.sR][shark.sC].live = false;
                    sea[shark.sR][shark.sC] = shark;
                }
//                sea[shark.sR][shark.sC] = sea[shark.sR][shark.sC].z > shark.z ? sea[shark.sR][shark.sC] : shark;

            }else{
                sea[shark.sR][shark.sC] = shark;
            }
        }
    }

    private static void fishing(int sC) {
        for (int i = 0; i < r; i++) {
            if(sea[i][sC]!=null){
                Shark shark = sea[i][sC];
                result+= shark.z;
                for (int j = 0; j < sharks.size(); j++) {
                    if(shark.equals(sharks.get(j))) {
                        sharks.remove(shark);
                        return;
                    }
                }
            }
        }
    }

    private static void move() {
        for (Shark shark : sharks) {
            for (int i = 0; i < shark.s; i++) {
                int nr = shark.sR + dr[shark.d-1];
                int nc = shark.sC + dc[shark.d-1];
                if(isCheck(nr, nc)){
                    shark.sR = nr;
                    shark.sC = nc;
                } else{
                    shark.d = shark.d == 1 ? 2 : shark.d == 2 ? 1 : shark.d == 3 ? 4 : shark.d == 4 ? 3 : -1;
                    i--;
                }
            }
        }
    }

    static class Shark{
        /* s는 속력, d는 이동방향, z는 크기 */
        int sR, sC, s, d, z;
        boolean live = true;

        public Shark(int sR, int sC, int s, int d, int z) {
            this.sR = sR;
            this.sC = sC;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0<= nr && nr < r && 0 <= nc && nc < c;
    }
}

/*
1 6 6
1 1 0 4 1
1 2 1 4 2
1 3 2 4 3
1 4 3 4 4
1 5 4 4 5
1 6 5 4 6
 */