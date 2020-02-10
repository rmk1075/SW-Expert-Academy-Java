import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    static int T, N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] rooms, update;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];
            update = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    update[i][j] = -1;
                }
            }

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(update[i][j] != -1) continue;

                    update[i][j] = 0;
                    for(int d = 0; d < 4; d ++) {
                        update[i][j] = Math.max(update[i][j], count(i, j, d));
                    }
                }
            }

            int maxCount = 0;
            int roomVal = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(maxCount <= update[i][j]) {
                        if(maxCount == update[i][j] && roomVal < rooms[i][j]) continue;

                        maxCount = update[i][j];
                        roomVal = rooms[i][j];
                    }
                }
            }

            sb.append("#" + t + " " + roomVal + " " + maxCount + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int count(int x, int y, int d) {
        int x_ = x + dx[d];
        int y_ = y + dy[d];
        if(x_ < 0 || y_ < 0 || N <= x_ || N <= y_ || rooms[x_][y_] - rooms[x][y] != 1) return 1;
    
        if(update[x_][y_] != -1) return update[x_][y_] + 1;
        
        update[x_][y_] = 0;
        for(int i = 0; i < 4; i++) {
            update[x_][y_] = Math.max(update[x_][y_], count(x_, y_, i));
        }

        return update[x_][y_] + 1;
    }
}