import java.util.Scanner;

public class Solution {
    static int T, N, M;
    static int[] snacks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            snacks = new int[N];

            for(int i = 0; i < N; i++) {
                snacks[i] = sc.nextInt();
            }

            int maxVal = -1;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(snacks[i] + snacks[j] <= M) {
                        maxVal = Math.max(maxVal, snacks[i] + snacks[j]);
                    }
                }
            }

            System.out.println("#" + (t+1) + " " + maxVal);
        }

        sc.close();
    }
}