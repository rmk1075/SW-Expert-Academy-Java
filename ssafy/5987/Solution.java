import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M, list[];
    static long mem[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new int[N];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1; 
                list[a] |= (1 << b);
            }

            mem = new long[1 << N];
            mem[(1 << N) - 1] = 1;
            sb.append("#" + t + " " + dfs(0) + "\n");
        }
        System.out.println(sb);
    }

    public static long dfs(int n) {
        if(0 < mem[n]) return mem[n];
        for(int i = 0; i < N; i++) {
            if((n & (1 << i)) != 0 || ((n & (list[i])) != list[i])) continue;
            mem[n] += dfs(n | (1 << i));
        }

        return mem[n];
    }
}