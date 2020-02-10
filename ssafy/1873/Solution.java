import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    static int T, H, W, N, x, y, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            board = new char[H][W];
            
            boolean isTank = false;
            x = y = d = 0;
            for(int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();
                if(!isTank) {
                    for(int j = 0; j < W; j++) {
                        switch(board[i][j]) {
                            case '^':
                                x = i;
                                y = j;
                                d = 0;
                                isTank = true;
                                break;
                            case '>':
                                x = i;
                                y = j;
                                d = 3;
                                isTank = true;
                                break;
                            case 'v':
                                x = i;
                                y = j;
                                d = 2;
                                isTank = true;
                                break;
                            case '<':
                                x = i;
                                y = j;
                                d = 1;
                                isTank = true;
                                break;
                        }
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            int x_, y_;
            for(char command : br.readLine().toCharArray()) {
                switch(command) {
                    case 'U':
                        d = 0;
                        board[x][y] = '^';
                        x_ = x + dx[d];
                        y_ = y + dy[d];
                        if(x_ < 0 || y_ < 0 || H <= x_ || W <= y_ || board[x_][y_] != '.') break;

                        board[x][y] = '.';
                        board[x_][y_] = '^';
                        x = x_;
                        y = y_;

                        break;
                    case 'D':
                        d = 2;
                        board[x][y] = 'v';
                        x_ = x + dx[d];
                        y_ = y + dy[d];
                        if(x_ < 0 || y_ < 0 || H <= x_ || W <= y_ || board[x_][y_] != '.') break;

                        board[x][y] = '.';
                        board[x_][y_] = 'v';
                        x = x_;
                        y = y_;

                        break;
                    case 'L':
                        d = 1;
                        board[x][y] = '<';
                        x_ = x + dx[d];
                        y_ = y + dy[d];
                        if(x_ < 0 || y_ < 0 || H <= x_ || W <= y_ || board[x_][y_] != '.') break;

                        board[x][y] = '.';
                        board[x_][y_] = '<';
                        x = x_;
                        y = y_;

                        break;
                    case 'R':
                        d = 3;
                        board[x][y] = '>';
                        x_ = x + dx[d];
                        y_ = y + dy[d];
                        if(x_ < 0 || y_ < 0 || H <= x_ || W <= y_ || board[x_][y_] != '.') break;
                        
                        board[x][y] = '.';
                        board[x_][y_] = '>';
                        x = x_;
                        y = y_;

                        break;
                    case 'S':
                        x_ = x;
                        y_ = y;

                        while(true) {
                            x_ += dx[d];
                            y_ += dy[d];

                            if(x_ < 0 || y_ < 0 || H <= x_ || W <= y_ || board[x_][y_] == '#') break;
                            if(board[x_][y_] == '*') {
                                board[x_][y_] = '.';
                                break;
                            }
                        }
                }
            }

            System.out.print("#" + t + " ");
            for(char[] row : board) {
                for(int i = 0; i < row.length; i++) System.out.print(row[i]);
                System.out.println();
            }
        }
    }   
}