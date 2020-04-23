import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, K, bag[][] = new int[101][1001], arr[][] = new int[101][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for(int i = 0; i <= N; i++) {
                for(int j = 0; j <= K; j++) bag[i][j] = 0;
            }
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++) {
                for(int j = 0; j <= K; j++) {
                    if(j < arr[i][0]) bag[i][j] = bag[i-1][j];
                    else bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
            
            sb.append("#" + t + " " + bag[N][K] + "\n");
        }
        System.out.println(sb);
    }
}