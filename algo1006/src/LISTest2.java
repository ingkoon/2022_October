import java.util.Arrays;
import java.util.Scanner;

public class LISTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];  // 수열의 수들
        int[] C = new int[n]; // 동적 테이블 C[k] : 해당 (k) 길이를 만족하는 자리에 오는 수의 최소값

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int size = 0;
        for (int i = 0; i < n; i++) {
           int pos = Arrays.binarySearch(arr, 0, size, arr[i]);
           if(pos >= 0) continue;

           int insertPose = Math.abs(pos)-1;
           C[insertPose] = arr[i];

           if(insertPose == size) size++;
        }

        System.out.println(size);
        System.out.println("hello world!");
    }
}
