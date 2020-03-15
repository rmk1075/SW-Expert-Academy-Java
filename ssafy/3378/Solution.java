import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][][] candidates;
    static int T, P, Q, R2, C2, S2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            candidates = new boolean[21][21][21];
            R2 = C2 = S2 = 0;
            for(int i = 0; i < P; i++) {
                char[] line = br.readLine().toCharArray();
                int cnt = 0;
                for(char ch : line) {
                    if(ch != '.') break;
                    cnt++;                    
                }

                for(int R = 1; R <= 20; R++) {
                    for(int C = 1; C <= 20; C++) {
                        for(int S = 1; S <= 20; S++) {
                            if(candidates[R][C][S]) continue;
                            if(((R*R2) + (C*C2) + (S*S2)) != cnt) candidates[R][C][S] = true;;
                        }
                    }
                }
                count(line);
            }
            
            R2 = C2 = S2 = 0;
            sb.append("#").append(t);
            for(int i = 0; i < Q; i++) {
                char[] line = br.readLine().toCharArray();
                int result = -1;
                loop: for(int R = 1; R < 21; R++) {
                    for(int C = 1; C < 21; C++) {
                        for(int S = 1; S <21; S++) {
                            if(candidates[R][C][S]) continue;

                            int tmp = (R * R2) + (C * C2) + (S * S2);
                            if(result == -1 || result == tmp) result = tmp;
                            else {
                                result = -1;
                                break loop;
                            }
                        }
                    }
                }
                sb.append(" " + result);
                count(line);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void count(char[] line) {
        for (char ch : line) {
            switch (ch) {
                case '(': R2++; break;
                case ')': R2--; break;
                case '{': C2++; break;
                case '}': C2--; break;
                case '[': S2++; break;
                case ']': S2--;
            }
        }
    }
}