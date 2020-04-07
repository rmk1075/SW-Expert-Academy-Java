import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, K, magnets[][] = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            for(int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 8; j++) magnets[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                rotate(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), true, true);
            }

            // cal points
            int ans = 0;
            if(magnets[0][0] == 1) ans += 1;
            if(magnets[1][0] == 1) ans += 2;
            if(magnets[2][0] == 1) ans += 4;
            if(magnets[3][0] == 1) ans += 8;
            sb.append("#" + t + " " + ans +"\n");
        }
        System.out.println(sb);
    }

    /** 0: 12 -> [idx-1][2] != [idx][6] || [idx][2] != [idx+1][6] */
    public static void rotate(int idx, int direction, boolean l, boolean r) {
        // left
        if(l && idx != 0) {
            if(magnets[idx-1][2] != magnets[idx][6]) rotate(idx-1, direction * -1, true, false);
        }

        // right
        if(r && idx != 3) {
            if(magnets[idx+1][6] != magnets[idx][2]) rotate(idx+1, direction * -1, false, true);
        }
        
        // clockwise
        if(direction == 1) {
            int temp = magnets[idx][7];
            for(int i = 7; 0 < i; i--) magnets[idx][i] = magnets[idx][i-1];
            magnets[idx][0] = temp;
        } else { // counterclockwise
            int temp = magnets[idx][0];
            for(int i = 0; i < 7; i++) magnets[idx][i] = magnets[idx][i+1];
            magnets[idx][7] = temp;
        }
    }
}