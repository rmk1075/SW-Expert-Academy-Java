import java.util.Scanner;

public class Solution {
    static int T, N;
    static int[] H;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            H = new int[N];

            for(int i = 0; i < N; i++) H[i] = sc.nextInt();

            int[] ascending = new int[N], descending = new int[N];
            for(int i = 1; i < N; i++) {
                if(H[i-1] < H[i]) ascending[i] = ascending[i-1]+1;
                if(H[N-i] < H[N-i-1]) descending[N-i-1] = descending[N-i]+1;
            }

            int count = 0;
            for(int i = 0; i < N; i++) {
                count += ascending[i] * descending[i];
            }

            sb.append("#" + t + " " + count + "\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}