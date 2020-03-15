import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, N, numOfSpace, bomb[][];
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1}, dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            bomb = new int[N][N];
            numOfSpace = 0;
            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    bomb[i][j] = -1;
                    if(map[i][j] == '.') numOfSpace++;
                }
            }

            if(numOfSpace == 0) {
                sb.append("#" + t + " 0\n");
                continue;
            }

            Queue<Location> zeros = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '*') continue;
                    bomb[i][j] = count(i, j);
                    if(bomb[i][j] == 0) zeros.offer(new Location(i, j));
                }
            }

            int ans = 0, cnt = 0;
            boolean[][] visited = new boolean[N][N];
            while(!zeros.isEmpty()) {
                Location zero = zeros.poll();
                if(visited[zero.x][zero.y]) continue;
                
                visited[zero.x][zero.y] = true;
                Queue<Location> queue = new LinkedList<>();
                queue.offer(new Location(zero.x, zero.y));
                ans++;
                cnt++;

                while(!queue.isEmpty()) {
                    Location current = queue.poll();
                    for(int d = 0; d < 8; d++) {
                        int x = current.x + dx[d], y = current.y + dy[d];
                        if(x < 0 || y < 0 || x == N || y == N || map[x][y] == '*' || visited[x][y]) continue;
                        visited[x][y] = true;
                        cnt++;
                        if(bomb[x][y] == 0) queue.offer(new Location(x, y));
                    }
                }
            }

            ans += (numOfSpace - cnt);
            sb.append("#" + t + " " + ans + "\n");
        }

        System.out.println(sb);
    }

    public static int count(int x, int y) {
        int cnt = 0;
        for(int d = 0; d < 8; d++) {
            int x_ = x + dx[d], y_ = y + dy[d];
            if(x_ < 0 || y_ < 0 || x_ == N || y_ == N || map[x_][y_] == '.') continue;
            cnt++;
        }

        return cnt;
    }
}