import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, MOD = 998244353, arr[][];
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1][3];
            dp = new long[N+1];

            for(int i = 2; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            sb.append("#" + t);
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                dp[0] = 1;
                dp[1] = Integer.parseInt(st.nextToken());
                for(int j = 2; j <= N; j++) {
                    switch(arr[j][0]) {
                        case 1:
                            dp[j] = (dp[arr[j][1]] + dp[arr[j][2]]) % MOD;
                            break;
                        case 2:
                            dp[j] = (arr[j][1] * dp[arr[j][2]]) % MOD;
                            break;
                        default:
                            dp[j] = (dp[arr[j][1]] * dp[arr[j][2]]) % MOD;
                    }
                }
                sb.append(" " + dp[N]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}