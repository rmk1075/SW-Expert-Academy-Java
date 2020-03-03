import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int[] pieces;
    static int[][] A;
    static int[][][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N][M];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N][M][N+1][M+1];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    for(int k = 0; k < N+1; k++) Arrays.fill(dp[i][j][k], -1);
                }
            }
            sb.append("#" + t + " " + cal(0, 0, N, M) + "\n");
        }

        System.out.println(sb.toString());
    }
    public static int cal(int r, int c, int rLen, int cLen) {
        if(rLen == 1 && cLen == 1) return 0;
        
        if(dp[r][c][rLen][cLen] != -1) return dp[r][c][rLen][cLen];

        int sum = 0;
        for(int i = 0; i < rLen; i++) {
            for(int j = 0; j < cLen; j++) sum += A[r+i][c+j];
        }

        int temp = Integer.MAX_VALUE;
        for(int i = 1; i < rLen; i++) temp = Math.min(temp, sum + cal(r, c, i, cLen) + cal(r + i, c, rLen - i, cLen));
        for(int i = 1; i < cLen; i++) temp = Math.min(temp, sum + cal(r, c, rLen, i) + cal(r, c + i, rLen, cLen - i));

        return dp[r][c][rLen][cLen] = temp;
    }
}