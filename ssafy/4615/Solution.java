import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N + 1][N + 1];
            board[N / 2][N / 2] = 2;
            board[N / 2][N / 2 + 1] = 1;
            board[N / 2 + 1][N / 2] = 1;
            board[N / 2 + 1][N / 2 + 1] = 2;

            int x, y, c;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                board[x][y] = c;
                for(int d = 0; d < 8; d++) {
                    boolean check = false;
                    int x_ = x, y_ = y;
                    while(true) {
                        x_ += dx[d];
                        y_ += dy[d];

                        if(x_ < 1 || y_ < 1 || N < x_ || N < y_ || board[x_][y_] == 0) break;
                        
                        if(board[x_][y_] == c) {
                            check = true;
                            break;
                        }
                    }

                    
                    if(check) {
                        x_ = x + dx[d];
                        y_ = y + dy[d];
                        while(true) {
                            if(board[x_][y_] == c) break;
                            board[x_][y_] = c;
                            x_ += dx[d];
                            y_ += dy[d];
                        }
                    }
                }

                // TODO:
                // for(int k = 1; k < N + 1; k++) {
                //     System.out.println(Arrays.toString(board[k]));
                // }
                // System.out.println();

            }

            int black = 0;
            int white = 0;
            for(int i = 1; i < N + 1; i++) {
                for(int j = 1; j < N + 1; j++) {
                    if(board[i][j] == 1) black++;
                    else if(board[i][j] == 2) white++;
                }
            }

            System.out.println("#" + t + " " + black + " " + white);
        }
    }
}