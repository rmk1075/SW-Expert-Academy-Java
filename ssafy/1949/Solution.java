import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
    int x, y, h;
    boolean k;

    Location(int x, int y, int h, boolean k) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
    }
}

public class Solution {
    static int T, N, K, height, ans, visited[], map[][];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static ArrayList<Location> top = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new int[N];
            map = new int[N][N];
            ans = height = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(height == map[i][j]) {
                        top.add(new Location(i, j, map[i][j], false));
                    } else if(height < map[i][j]) {
                        height = map[i][j];
                        top.clear();
                        top.add(new Location(i, j, map[i][j], false));
                    }
                }
            }

            for(Location loc : top) {
                visited[loc.x] |= (1 << loc.y);
                dfs(loc, 1);
                visited[loc.x] &= ~(1 << loc.y);
            }

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(Location cur, int count) {
        
        int x, y;
        boolean bottom = true;
        for(int d = 0; d < 4; d++) {
            x = cur.x + dx[d];
            y = cur.y + dy[d];
            if(x < 0 || y < 0 || x == N || y == N || (visited[x] & (1 << y)) != 0) continue;
            if(map[x][y] < cur.h) {
                visited[x] |= (1 << y);
                dfs(new Location(x, y, map[x][y], cur.k), count + 1);
                bottom = false;
                visited[x] &= ~(1 << y);
            } else if(map[x][y] - K < cur.h) {
                if(cur.k) continue;
                visited[x] |= (1 << y);
                dfs(new Location(x, y, cur.h-1, true), count+1);
                bottom = false;
                visited[x] &= ~(1 << y);
            }
        }

        if(bottom) ans = Math.max(ans, count);
    }
}