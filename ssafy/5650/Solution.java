import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Location {
    int x, y, d, p;

    Location(int x, int y, int d, int p) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.p = p;
    }

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, N, map[][];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] blocks = {{}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 0, 3, 1}, {2, 3, 0, 1}};
    static int holes[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+2][N+2];
            for(int i = 0; i < N+2; i++) {
                map[i][0] = 5;
                map[0][i] = 5;
                map[i][N+1] = 5;
                map[N+1][i] = 5;
            }
            holes = new int[11][2][2];
            for(int i = 6; i < 11; i++) holes[i][0][0] = holes[i][0][1] = holes[i][1][0] = holes[i][1][1] = -1;

            for(int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < N+1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(5 < map[i][j]) {
                        if(holes[map[i][j]][0][0] == -1) {
                            holes[map[i][j]][0][0] = i;
                            holes[map[i][j]][0][1] = j;
                        }
                        else {
                            holes[map[i][j]][1][0] = i;
                            holes[map[i][j]][1][1] = j;
                        }
                    }
                }
            }

            int maxCount = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][j] != 0) continue;
                    for(int d = 0; d < 4; d++) maxCount = Math.max(maxCount, find(i, j, d));
                }
            }
            sb.append("#" + t + " " + maxCount + "\n");
        }
        System.out.println(sb);
    }

    public static int find(int srcX, int srcY, int d) {
        boolean src = true;
        int x = srcX, y = srcY, x_, y_, p = 0;
                while(true) {
            if(!src && x == srcX && y == srcY) return p;
            src = false;

            x_ = x + dx[d];
            y_ = y + dy[d];
            if(x_ == srcX && y_ == srcY) return p;
            
            int val = map[x_][y_];
            switch(val) {
                case -1:
                    return p;
                case 0:
                    x = x_;
                    y = y_;
                    break;
                case 1: case 2: case 3: case 4: case 5:
                    x = x_;
                    y = y_;
                    d = blocks[val][d];
                    p++;
                    break;
                default:
                    if(holes[val][0][0] == x_ && holes[val][0][1] == y_) {
                        x = holes[val][1][0];
                        y = holes[val][1][1];
                    } else {
                        x = holes[val][0][0];
                        y = holes[val][0][1];
                    }
            }
        }
    }
}