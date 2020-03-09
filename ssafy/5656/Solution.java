import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x, y, val;

    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Solution {
    static int T, N, W, H;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];

            int cnt = 0;
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0) cnt++;
                }
            }

            int maxDistroy = 0;
            for(int i = 0; i < W; i++) maxDistroy = Math.max(maxDistroy, dfs(i, 0, 0, map));

            sb.append("#" + t + " " + (cnt - maxDistroy) + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int dfs(int index, int count, int bricks, int[][] field) {
        if (count == N) return bricks;


        int[][] tempMap = new int[H][W];
        for(int i = 0; i < H; i++) tempMap[i] = Arrays.copyOf(field[i], W);

        // shoot from [0][index]
        int broken = shoot(index, tempMap), rest = 0;
        for(int i = 0; i < W; i++) rest = Math.max(rest, dfs(i, count+1, bricks+broken, tempMap));

        return rest;
    }

    public static int shoot(int index, int[][] tempMap) {
        Location src = new Location(0, index, tempMap[0][index]);
        while(src.x < H && tempMap[src.x][src.y] == 0) src.x++;

        if(src.x == H) return 0;

        src.val = tempMap[src.x][src.y];
        tempMap[src.x][src.y] = 0;
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(src.x, src.y, src.val));

        // find broken bricks
        int count = 1;
        while(!queue.isEmpty()) {
            Location current = queue.poll();

            int distance = current.val;
            for(int d = 0; d < 4; d++) {
                int x = current.x, y = current.y;
                for(int i = 1; i < distance; i++) {
                    x += dx[d];
                    y += dy[d];
                    if(x < 0 || y < 0 || H <= x || W <= y) break;
                    if(tempMap[x][y] == 0) continue;

                    count++;
                    if(tempMap[x][y] != 1) queue.add(new Location(x, y, tempMap[x][y]));
                    tempMap[x][y] = 0;
                }
            }
        }

        // move to down the bricks on the empty space
        for(int i = H-1; -1 < i; i--) {
            for(int j = 0; j < W; j++) {
                if(i == H-1 || tempMap[i+1][j] != 0) continue;

                Location current = new Location(i, j, tempMap[i][j]);
                tempMap[current.x][current.y] = 0;
                while(current.x < H && tempMap[current.x][current.y] == 0) current.x++;
                tempMap[current.x-1][current.y] = current.val;
            }
        }

        return count;
    }
}