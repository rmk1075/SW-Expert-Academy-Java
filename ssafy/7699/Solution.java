import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, R, C, maxCount, alphabets;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];

            for (int i = 0; i < R; i++) {
                int j = 0;
                for(char ch : br.readLine().toCharArray()) {
                    map[i][j++] = ch - 'A';
                }
            }

            alphabets = 0;
            maxCount = 1;
            alphabets |= (1 << map[0][0]);
            dfs(0, 0, 1);

            sb.append("#" + t + " " + maxCount + "\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);
        if(maxCount == 26) return true;
        
        int x_, y_;
        for (int d = 0; d < 4; d++) {
            x_ = x + dx[d];
            y_ = y + dy[d];

            if (x_ < 0 || y_ < 0 || x_ == R || y_ == C || (alphabets & (1 << map[x_][y_])) != 0) continue;
            alphabets |= (1 << map[x_][y_]);

            if(dfs(x_, y_, count + 1)) return true;
            alphabets &= ~(1 << map[x_][y_]);
        }

        return false;
    }
}