import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, X, map1[][] = new int[20][20], map2[][] = new int[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            for(int i = 0; i < N; i++) {
                Arrays.fill(map1[i], 0);
                Arrays.fill(map2[i], 0);
            }
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map1[i][j] = Integer.parseInt(st.nextToken());
                    map2[j][i] = map1[i][j];
                }
            }

            int ans = 0;
            for(int i = 0; i < N; i++) {
                ans += (check(map1, i)) ? 1 : 0;
                ans += (check(map2, i)) ? 1 : 0;
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static boolean check(int[][] map, int idx) {
        int cnt = 0, h = map[idx][0];
        for(int i = 0; i < N; i++) {
            if(map[idx][i] == h) {
                cnt++;
                continue;
            }

            if(1 < Math.abs(map[idx][i] - h)) return false;
            if(map[idx][i] == h+1) {
                if(cnt < X) return false;
                h = map[idx][i];
                cnt = 1;
            } else {
                if(N < X + i) return false;
                h--;
                for(int j = 1; j < X; j++) if(map[idx][++i] != h) return false;
                cnt = 0;
            }
        }

        return true;
    }
}