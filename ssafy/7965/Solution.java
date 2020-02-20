import java.util.Scanner;

public class Solution {
    static int T, N;
    static long Mod_Num = 1_000_000_007;
    static long[] dp = new long[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        
        dp[1] = 1;
        for(int i = 2; i <= 1000000; i++) {
            dp[i] = ((dp[i-1] % Mod_Num) + (pow(i, i) % Mod_Num)) % Mod_Num;
        }


        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            sb.append("#" + t + " " + dp[N] + "\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }

    public static long pow(int base, int exp) {
        if (exp == 0)
            return 1;
        if (exp == 1)
            return base;

        long result = pow(base, exp / 2) % Mod_Num;
        result = (result * result) % Mod_Num;
        if (exp % 2 == 1) result = (result * base) % Mod_Num;

        return result % Mod_Num;
    }
}