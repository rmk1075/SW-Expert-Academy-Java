import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M, C, maxProfit = 0;
    static int[][] m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxProfit = 0;
            m = new int[2][M];
            choice(0, 0, 0);

            sb.append("#" + t + " " + maxProfit + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int cal(int index, int count, int sum, int sumC) {
        if (C <= sumC || count == M) return sum;

        int result = Math.max(sum, cal(index, count + 1, sum, sumC));

        if (sumC + m[index][count] <= C) result = Math.max(result, cal(index, count + 1, sum + m[index][count] * m[index][count], sumC + m[index][count]));
        return result;
    }

    public static void choice(int row, int col, int count) {

        if (count == 2) {
            maxProfit = Math.max(maxProfit, cal(0, 0, 0, 0) + cal(1, 0, 0, 0));
            return;
        }

        for (int i = row; i < N; i++) {
            int c = (i == row) ? col : 0;
            for (int j = c; j <= N-M; j++) {
                if (visited[i][j]) continue;

                visited[i][j] = true;
                for (int k = 0; k < M; k++) {
                    m[count][k] = map[i][j + k];
                }
                choice(i, j+M, count + 1);

                visited[i][j] = false;
            }
        }
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class Solution {
//     static int T, N, M, C, maxProfit = 0;
//     static int[][] m;
//     static int[][] map;
//     static boolean[][] visited;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         StringTokenizer st;

//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             C = Integer.parseInt(st.nextToken());
//             map = new int[N][N];
//             visited = new boolean[N][N];

//             for(int i = 0; i < N; i++) {
//                 st = new StringTokenizer(br.readLine());
//                 for(int j = 0; j < N; j++) {
//                     map[i][j] = Integer.parseInt(st.nextToken());
//                 }
//             }
//             maxProfit = 0;
//             m = new int[2][M];
//             choice(0, 0);
            
//             sb.append("#" + t + " " + maxProfit + "\n");
//         }

//         System.out.println(sb.toString());
//     }

//     public static int cal(int index, int count, int sum, int sumC) {
//         if(C <= sumC || count == m[index].length) return sum;

//         int result = Math.max(sum, cal(index, count+1, sum, sumC));

//         if(sumC + m[index][count] <= C) result = Math.max(result, cal(index, count + 1, sum + m[index][count] * m[index][count], sumC + m[index][count]));
//         return result;
//     }

//     public static void choice(int row, int count) {

//         if(count == 2) {
//             int sum = 0;
//             sum = cal(0, 0, 0, 0) + cal(1, 0, 0, 0);

//             maxProfit = Math.max(maxProfit, sum);
//             return ;
//         }

//         for(int i = row; i < N; i++) {
//             for(int j = 0; j < N; j++) {
//                 if(visited[i][j]) continue;
                
//                 boolean isOk = true;
//                 for(int k = 1; k < M; k++) {
//                     if((-1 < j-k && visited[i][j-k]) || (j+k == N || visited[i][j+k])) {
//                         isOk = false;
//                         break;
//                     }
//                 }

//                 if(isOk) {
//                     visited[i][j] = true;
//                     for (int k = 0; k < M; k++) {
//                         m[count][k] = map[i][j+k];
//                     }
//                     choice(i, count+1);

//                     visited[i][j] = false;
//                 }
//             }
//         }
//     }
// }