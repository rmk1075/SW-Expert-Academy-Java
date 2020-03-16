import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, half, limit, order, minDiff, S[][];    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) S[i][j] = Integer.parseInt(st.nextToken());
            }

            half = N/2;
            limit = half-1;
            order = 0;
            minDiff = Integer.MAX_VALUE;
            dfs(0, 0);

            sb.append("#" + t + " " + minDiff + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int index, int count) {
        if(count == half) {
            int[] sum = {0, 0};
            for(int i = 0; i < N; i++) {
                boolean c = ((order & (1 << i)) == 0);
                for(int j = 0; j < N; j++) {
                    if(c == (((order & (1 << j)) == 0))) sum[c ? 0 : 1] += S[i][j];
                }
            }

            minDiff = Math.min(minDiff, Math.abs(sum[0] - sum[1]));
            return ;
        }

        if(index == limit) return ;

        for(int i = index; i < N; i++) {
            order |= (1 << i);
            dfs(i+1, count+1);
            order &= ~(1 << i);
        }
    }
}