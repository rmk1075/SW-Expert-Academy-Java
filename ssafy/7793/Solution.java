import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];

            Queue<int[]> SY = new LinkedList<>();
            Queue<int[]> DV = new LinkedList<>(); 
            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 'S') SY.offer(new int[] {i, j});
                    else if(map[i][j] == '*') DV.offer(new int[] {i, j});
                }
            }

            int count = 1;
            boolean isSaved = false;
            loop: while(!SY.isEmpty()) {
                // SY
                int size = SY.size();
                while(0 < size--) {
                    int[] current = SY.poll();
                    if(map[current[0]][current[1]] != 'S') continue;

                    for(int d = 0; d < 4; d++) {
                        int x = current[0] + dx[d], y = current[1] + dy[d];
                        if(x < 0 || y < 0 || x == N || y == M || map[x][y] == '*' || map[x][y] == 'S' || map[x][y] == 'X') continue;
                        if(map[x][y] == 'D') {
                            isSaved = true;
                            break loop;
                        }

                        map[x][y] = 'S';
                        SY.offer(new int[] {x, y});
                    }
                }

                // DV
                size = DV.size();
                while(0 < size--) {
                    int[] current = DV.poll();
                    for(int d = 0; d < 4; d++) {
                        int x = current[0] + dx[d], y = current[1] + dy[d];
                        if(x < 0 || y < 0 || x == N || y == M || map[x][y] == '*' || map[x][y] == 'X' || map[x][y] == 'D') continue;
                        map[x][y] = '*';
                        DV.offer(new int[] {x, y});
                    }
                }

                count++;
            }

            if(isSaved) sb.append("#" + t + " " + count + "\n");
            else sb.append("#" + t + " GAME OVER\n");
        }

        System.out.println(sb.toString());
    }
}