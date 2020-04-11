import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, N, M, R, C, L, map[][] = new int[50][50];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] dir = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {3, 0}};
    static boolean visited[][] = new boolean[50][50];
    static Queue<Location> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            queue.clear();
            queue.offer(new Location(R, C));
            
            for(int i = 0; i < 50; i++) Arrays.fill(visited[i], false);
            visited[R][C] = true;

            int size, x, y, ans = 1;
            for(int l = 1; l < L; l++) {
                size = queue.size();
                while(0 < size--) {
                    Location current = queue.poll();
                    for(int d : dir[map[current.x][current.y]]) {
                        x = current.x + dx[d];
                        y = current.y + dy[d];
                        if(x < 0 || y < 0 || x == N || y == M || map[x][y] == 0 || visited[x][y] || check(d, map[x][y])) continue;
                        visited[x][y] = true;
                        queue.offer(new Location(x, y));
                        ans++;
                    }
                }
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static boolean check(int d, int val) {
        int c;
        switch (d) {
            case 0:
                c = 2;
                break;
            case 1:
                c = 3;
                break;
            case 2:
                c = 0;
                break;
            default:
                c = 1;
        }
        for(int c_ : dir[val]) if(c == c_) return false;
        return true;
    }
}