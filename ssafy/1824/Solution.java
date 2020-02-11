import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    static int T, R, C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] board;
    static int[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new char[R][C];

            for(int i = 0; i < R; i++) {
                board[i] = br.readLine().toCharArray();
            }
            
            visited = new int[R][C][4][16];
            String ans = find(0, 0, 1, 0) ? "YES" : "NO";
            sb.append("#" + t + " " + ans + "\n");
        }

        System.out.println(sb.toString());

    }

    public static boolean find(int x, int y, int d, int mem) {
        while(true) {
            // TODO:
            // System.out.println(x + " " + y + " " + d + " " + mem);

            if(R <= x) x = 0;
            if(C <= y) y = 0;

            if(x < 0) x = R - 1;
            if(y < 0) y = C - 1;

            if(visited[x][y][d][mem] == 1) return false;
            else visited[x][y][d][mem] = 1;
            
            if(board[x][y] == '?') {
                return find(x + dx[0], y + dy[0], 0, mem) || find(x + dx[1], y + dy[1], 1, mem) || find(x + dx[2], y + dy[2], 2, mem) || find(x + dx[3], y + dy[3], 3, mem);
            }
            

            switch(board[x][y]) {
                case '<':
                    d = 0;
                    break;
                case '>':
                    d = 1;
                    break;
                case '^':
                    d = 2;
                    break;
                case 'v':
                    d = 3;
                    break;
                case '_':
                    d = (mem == 0) ? 1 : 0;
                    break;
                case '|':
                    d = (mem == 0) ? 3 : 2;
                    break;
                // case '?':
                //     return find(x, y, 0, mem) || find(x, y, 1, mem) || find(x, y, 2, mem) || find(x, y, 3, mem);

                case '@':
                    return true;

                case '+':
                    mem = (15 < mem + 1) ? 0 : mem + 1;
                    break;

                case '-':
                    mem = (mem - 1 < 0) ? 15 : mem - 1;
                    break;
                
                case '.':
                    break;

                default:
                    mem = board[x][y] - '0';
            }

            x = x + dx[d];
            y = y + dy[d];

            if(R <= x) x = 0;
            if(C <= y) y = 0;

            if(x < 0) x = R - 1;
            if(y < 0) y = C - 1;
        }
    }            
}