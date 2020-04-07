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
    static int T, M, A, BC[] = new int[8], route[][] = new int[2][101], map[][] = new int[10][10];
    static int[] dx = {0, -1, 0, 1, 0}, dy = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            for(int i = 0; i < 10; i++) Arrays.fill(map[i], 0);

            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) route[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1, y = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
                BC[i] = p;
                bfs(1 << i, y, x, c);
            }

            int ans = 0, a[] = {0, 0}, b[] = {9, 9};
            ans = find(map[a[0]][a[1]], map[b[0]][b[1]]);
            for(int m = 0; m < M; m++) {
                a[0] += dx[route[0][m]];
                a[1] += dy[route[0][m]];
                b[0] += dx[route[1][m]];
                b[1] += dy[route[1][m]];
                ans += find(map[a[0]][a[1]], map[b[0]][b[1]]);
            }

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static int find(int a, int b) {
        int result = 0;
        if(a == 0 && b == 0) return 0;

        if(a == 0) {
            for(int i = 0; i < A; i++) {
                if((b & (1 << i)) == 0) continue;
                result = Math.max(result, BC[i]);
            }
            return result;
        }

        if(b == 0) {
            for(int i = 0; i < A; i++) {
                if((a & (1 << i)) == 0) continue;
                result = Math.max(result, BC[i]);
            }
            return result;
        }

        for(int i = 0; i < A; i++) {
            if((a & (1 << i)) == 0) continue;
            result = Math.max(result, BC[i]);
            for(int j = 0; j < A; j++) {
                if(i == j || (b & (1 << j)) == 0) continue;
                result = Math.max(result, BC[i] + BC[j]);
            }
        }

        return result;
    }

    public static void bfs(int idx, int x, int y, int c) {
        Queue<Location> queue = new LinkedList<>();
        map[x][y] |= idx;
        queue.offer(new Location(x, y));

        while(0 < c--) {
            int size = queue.size();
            while(0 < size--) {
                Location current = queue.poll();
                for(int d = 1; d < 5; d++) {
                    int x_ = current.x + dx[d], y_ = current.y + dy[d];
                    if(x_ < 0 || y_ < 0 || x_ == 10 || y_ == 10 || (map[x_][y_] & idx) == idx) continue;

                    map[x_][y_] |= idx;
                    queue.offer(new Location(x_, y_));
                }
            }
        }
    }
}