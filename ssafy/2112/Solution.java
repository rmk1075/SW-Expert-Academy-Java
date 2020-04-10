import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, D, W, K, ans, map[][], tMap[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K =Integer.parseInt(st.nextToken());
            map = new int[D][W];
            tMap = new int[D][W];
            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) map[i][j] = tMap[i][j] = Integer.parseInt(st.nextToken());
            }

            if(K == 1) {
                sb.append("#" + t + " 0\n");
                continue;
            }

            int cnt;
            boolean isOk = false;
            for(int i = 0; i < W; i++) {
                isOk = false;
                cnt = 1;
                for(int j = 1; j < D; j++) {
                    if(map[j-1][i] == map[j][i]) cnt++;
                    else cnt = 1;
                    
                    if(cnt == K) {
                        isOk = true;
                        break;
                    }
                }
                if(!isOk) break;
            }

            if(isOk) {
                sb.append("#" + t + " 0\n");
                continue;
            }

            ans = D;
            for(int i = 0; i < D; i++) {
                for(int j = 0; j < W; j++) tMap[i][j] = 0;
                find(i, 1);
                for(int j = 0; j < W; j++) tMap[i][j] = map[i][j];
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void find(int d, int count) {
        if(ans <= count) return ;
        for(int val = 0; val < 2; val++) {
            if(val == 1) for(int j = 0; j < W; j++) tMap[d][j] = 1;

            boolean isOk = false;
            for(int i = 0; i < W; i++) {
                isOk = false;
                int cnt = 1;
                for(int j = 1; j < D; j++) {
                    if(tMap[j-1][i] == tMap[j][i]) cnt++;
                    else cnt = 1;
    
                    if(cnt == K) {
                        isOk = true;
                        break;
                    }
                }
                if(!isOk) break;
            }
    
            if(isOk) {
                ans = count;
                return ;
            }
    
            for(int i = d+1; i < D; i++) {
                for(int j = 0; j < W; j++) tMap[i][j] = 0;
                find(i, count + 1);
                for(int j = 0; j < W; j++) tMap[i][j] = map[i][j];
            }
        }
    }
}