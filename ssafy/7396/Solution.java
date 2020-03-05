import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int[] dx = {1, 0}, dy = {0, 1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) map[i] = br.readLine().trim().toCharArray();

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});

            StringBuilder ans = new StringBuilder();
            ans.append(map[0][0]);
            visited[0][0] = true;

            ArrayList<int[]> list = new ArrayList<>();
            int size;
            loop: while(!queue.isEmpty()) {
                size = queue.size();
                int candidate = Integer.MAX_VALUE;
                while(0 < size--) {
                    int[] current = queue.poll();
                    if(current[0] == N-1 && current[1] == M-1) break loop;

                    int x, y;
                    for(int d = 0; d < 2; d++) {
                        x = current[0] + dx[d];
                        y = current[1] + dy[d];
                        if(x == N || y == M || visited[x][y]) continue;

                        visited[x][y] = true;
                        int tmp = map[x][y] - 'a';
                        if(tmp <= candidate) {
                            if(tmp < candidate) {
                                candidate = tmp;
                                list.clear();
                            }
                            list.add(new int[] {x, y});
                        }
                    }
                }

                for(int i = 0; i < list.size(); i++) queue.offer(new int[] {list.get(i)[0], list.get(i)[1]});
                ans.append(map[list.get(0)[0]][list.get(0)[1]]);
                list.clear();
            }

            sb.append("#" + t + " " + ans.toString() + "\n");
            queue.clear();
            ans.setLength(0);
        }

        System.out.println(sb.toString());
    }
}