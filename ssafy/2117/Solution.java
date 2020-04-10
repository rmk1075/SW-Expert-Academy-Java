import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
    int x, y;
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, N, M, numOfHouses, visited[], map[][] = new int[20][20];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
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
            numOfHouses = 0;
            // map = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) numOfHouses++;
                }
            }

            visited = new int[N];
            int size, x, y, cnt, ans = 0;
            loop: for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(ans == numOfHouses) break loop;
                    for(int k = 0; k < N; k++) visited[k] = 0;
                    cnt = 0;
                    queue.clear();
                    queue.offer(new Location(i, j));
                    visited[i] |= (1 << j);
                    if(map[i][j] == 1) cnt++;

                    int k = 1;
                    if (k * k + (k - 1) * (k - 1) <= cnt * M) ans = Math.max(ans, cnt);
                    while(cnt < numOfHouses) {
                        size = queue.size();
                        while(0 < size--) {
                            Location current = queue.poll();
                            for(int d = 0; d < 4; d++) {
                                x = current.x + dx[d];
                                y = current.y + dy[d];
                                if(x < 0 || y < 0 || x == N || y == N || (visited[x] & (1 << y)) != 0) continue;
                                visited[x] |= (1 << y);
                                queue.offer(new Location(x, y));
                                if(map[x][y] == 1) cnt++;
                            }
                        }
                        k++;
                        if(k*k + (k-1)*(k-1) <= cnt * M) ans = Math.max(ans, cnt);
                    }
                }
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}