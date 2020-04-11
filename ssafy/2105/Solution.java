import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, srcX, srcY, ans, cnt[] = new int[4], map[][] = new int[20][20];
    static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
    static boolean[] dessert = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.fill(cnt, 0);
            Arrays.fill(dessert, false);
            ans = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    srcX = i;
                    srcY = j;
                    search(i, j, 0, 0);
                }
            }

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void search(int x, int y, int d, int count) {
        if(d == 3 && x == srcX && y == srcY) {
            ans = Math.max(ans, count);
            return ;
        }

        if(d == 2 || d == 3) {
            if(cnt[d-2] <= cnt[d]) return;
        }

        int x_ = x + dx[d], y_ = y + dy[d];
        if(x_ < 0 || y_ < 0 || x_ == N || y_ == N || dessert[map[x_][y_]]) return;
        
        dessert[map[x_][y_]] = true;
        cnt[d]++;
        search(x_, y_, d, count+1);
        if(d != 3) search(x_, y_, d+1, count+1);
        cnt[d]--;
        dessert[map[x_][y_]] = false;
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class Solution {
//     static int T, N, maxVal, srcX, srcY;
//     static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
//     static int[][] map;
//     static boolean[] visited;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         T = Integer.parseInt(br.readLine());

//         for(int t = 1; t <= T; t++) {
//             N = Integer.parseInt(br.readLine());
//             map = new int[N][N];

//             StringTokenizer st;
//             for(int i = 0; i < N; i++) {
//                 st = new StringTokenizer(br.readLine());
//                 for(int j = 0; j < N; j++) {
//                     map[i][j] = Integer.parseInt(st.nextToken());
//                 }
//             }

//             maxVal = -1;
//             for(int i = 0; i < N; i++) {
//                 for(int j = 0; j < N; j++) {
//                     visited = new boolean[101];
//                     srcX = i;
//                     srcY = j;
//                     simulation(i, j, 0, 0);
//                 }
//             }

//             sb.append("#" + t + " " + maxVal + "\n");
//         }

//         System.out.println(sb.toString());
//     }

//     public static void simulation(int curX, int curY, int sum, int d) {
//         if(srcX == curX && srcY == curY && d == 3) {
//             maxVal = Math.max(maxVal, sum);
//             return ;
//         }

//         int x = curX + dx[d], y = curY + dy[d];
//         if(x < 0 || y < 0 || x == N || y == N || visited[map[x][y]]) return ;

//         visited[map[x][y]] = true;
//         simulation(x, y, sum+1, d);
//         if(d != 3) simulation(x, y, sum+1, d+1);
//         visited[map[x][y]] = false;
//     }
// }