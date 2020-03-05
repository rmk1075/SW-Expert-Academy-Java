import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, maxVal, srcX, srcY;
    static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxVal = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    visited = new boolean[101];
                    srcX = i;
                    srcY = j;
                    simulation(i, j, 0, 0);
                }
            }

            sb.append("#" + t + " " + maxVal + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void simulation(int curX, int curY, int sum, int d) {
        if(srcX == curX && srcY == curY && d == 3) {
            maxVal = Math.max(maxVal, sum);
            return ;
        }

        int x = curX + dx[d], y = curY + dy[d];
        if(x < 0 || y < 0 || x == N || y == N || visited[map[x][y]]) return ;

        visited[map[x][y]] = true;
        simulation(x, y, sum+1, d);
        if(d != 3) simulation(x, y, sum+1, d+1);
        visited[map[x][y]] = false;
    }
}