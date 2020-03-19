import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            list = new int[N+1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1; 
                list[b] |= (1 << a);
            }

            mem = new long[1 << N];
            Arrays.fill(mem, -1);
            mem[(1 << N) - 1] = 1;
            sb.append("#" + t + " " + find(0, 0) + "\n");
        }
        System.out.println(sb);
    }

    public static long find(int order, int cnt) {
        if(mem[order] != -1) return mem[order];

        mem[order] = 0;
        for(int i = 0; i < N; i++) {
            if(((order & (1 << i)) != 0) || ((order & list[i]) != 0)) continue;
            mem[order] += find(order | (1 << i), i);
        }

        return mem[order];
    }
}