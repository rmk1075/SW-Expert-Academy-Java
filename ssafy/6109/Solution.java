import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, visited[] = new int[20], map[][] = new int[20][20];
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = st.nextToken();
            
            for(int i = 0; i < N; i++) {
                visited[i] = 0;
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            switch (S) {
                case "up":
                    for (int i = 1; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (map[i][j] == 0)
                                continue;
                            int i_ = i;
                            while (0 < i_ && map[i_ - 1][j] == 0) {
                                map[i_ - 1][j] = map[i_][j];
                                map[i_--][j] = 0;
                            }
                        }
                    }

                    for (int i = 1; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (map[i][j] == 0)
                                continue;
                            if (map[i - 1][j] == map[i][j] && ((visited[i - 1] & (1 << j)) == 0)) {
                                map[i - 1][j] *= 2;
                                map[i][j] = 0;
                                visited[i - 1] |= (1 << j);
                                for (int k = i; k < N - 1; k++) {
                                    map[k][j] = map[k + 1][j];
                                    map[k + 1][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < N; i++) {
                        for (int j = 1; j < N; j++) {
                            if (map[i][j] == 0) continue;
                            int j_ = j;
                            while (0 < j_ && map[i][j_-1] == 0) {
                                map[i][j_-1] = map[i][j_];
                                map[i][j_--] = 0;
                            }
                        }
                    }

                    for (int i = 0; i < N; i++) {
                        for (int j = 1; j < N; j++) {
                            if (map[i][j] == 0) break;
                            if (map[i][j-1] == map[i][j] && ((visited[i] & (1 << (j-1))) == 0)) {
                                map[i][j-1] *= 2;
                                map[i][j] = 0;
                                visited[i] |= (1 << (j-1));
                                for (int k = j; k < N - 1; k++) {
                                    map[i][k] = map[i][k+1];
                                    map[i][k+1] = 0;
                                }
                            }
                        }
                    }
                    break;
                case "down":
                    for (int i = N-2; -1 < i; i--) {
                        for (int j = 0; j < N; j++) {
                            if (map[i][j] == 0) continue;
                            int i_ = i;
                            while (i_ < N-1 && map[i_ + 1][j] == 0) {
                                map[i_ + 1][j] = map[i_][j];
                                map[i_++][j] = 0;
                            }
                        }
                    }

                    for (int i = N-2; -1 < i; i--) {
                        for (int j = 0; j < N; j++) {
                            if (map[i][j] == 0) continue;
                            if (map[i + 1][j] == map[i][j] && ((visited[i + 1] & (1 << j)) == 0)) {
                                map[i + 1][j] *= 2;
                                map[i][j] = 0;
                                visited[i + 1] |= (1 << j);
                                for (int k = i; 0 < k; k--) {
                                    map[k][j] = map[k - 1][j];
                                    map[k - 1][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                default:
                    for (int i = 0; i < N; i++) {
                        for (int j = N-2; -1 < j; j--) {
                            if (map[i][j] == 0) continue;
                            int j_ = j;
                            while (j_ < N-1 && map[i][j_ + 1] == 0) {
                                map[i][j_ + 1] = map[i][j_];
                                map[i][j_++] = 0;
                            }
                        }
                    }

                    for (int i = 0; i < N; i++) {
                        for (int j = N-2; -1 < j; j--) {
                            if (map[i][j] == 0) break;
                            if (map[i][j + 1] == map[i][j] && ((visited[i] & (1 << (j + 1))) == 0)) {
                                map[i][j + 1] *= 2;
                                map[i][j] = 0;
                                visited[i] |= (1 << (j + 1));
                                for (int k = j; 0 < k; k--) {
                                    map[i][k] = map[i][k - 1];
                                    map[i][k - 1] = 0;
                                }
                            }
                        }
                    }
            }

            sb.append("#" + t + "\n");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) sb.append(map[i][j] + " ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}