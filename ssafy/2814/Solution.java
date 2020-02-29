import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M, maxDistance;
    static boolean[] visited;
    static boolean[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new boolean[N][N];

            int a, b;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken())-1;
                b = Integer.parseInt(st.nextToken())-1;

                graph[a][b] = graph[b][a] = true;
            }

            maxDistance = 1;
            for(int i = 0; i < N; i++) {
                visited = new boolean[N];
                visited[i] = true;
                dfs(i,1);
            }

            sb.append("#" + t + " " + maxDistance + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int index, int count) {
        maxDistance = Math.max(maxDistance, count);

        for(int i = 0; i < N; i++) {
            if(graph[index][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, count+1);
                visited[i] = false;
            }
        }
    }
}