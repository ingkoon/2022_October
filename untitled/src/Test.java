import java.util.Scanner;

public class Test {
    static int n, k;
    static int[][] items;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        items = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            items[i][0] = sc.nextInt(); // 첫 번째 열에는 무게
            items[i][1] = sc.nextInt(); //  두 번째 열에는 가치
        }

        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j < k+1; j++) { // 무게가 j인 경우를 고려
                if(items[i][0] > j){ // 무게가 j보다 클 경우
                    dp[i][j] = dp[i-1][j]; // 위의 값을 가져온다.
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - items[i][0]] + dp[i][1]);
                }
            }
        }
    }
}
