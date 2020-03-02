import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T, H, W;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1}, dy = {0, 1, 0, -1, 1, -1, -1, 1 };
    static int[][] castle;
    static int[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            castle = new int[H][W];
            checked = new int[H][W];
            
            Queue<Location> queue = new LinkedList<>();
            for(int i = 0; i < H; i++) {
                int j = 0;
                for(char ch : br.readLine().toCharArray()) {
                    if(ch == '.') castle[i][j++] = 0;
                    else castle[i][j++] = ch - '0';
                }
            }

            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(castle[i][j] != 0) {
                        checked[i][j] = check(i, j);
                        if((castle[i][j]) <= checked[i][j]) queue.offer(new Location(i, j));
                    }
                }
            }

            if(queue.size() == 0) {
                sb.append("#" + t + " 0\n");
                continue;
            }

            int count = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(0 < size--) {
                    Location current = queue.poll();

                    for(int d = 0; d < 8; d++) {
                        int x = current.x + dx[d], y = current.y + dy[d];
                        if(castle[x][y] == 0 || (castle[x][y] <= checked[x][y])) continue;
                        if(++checked[x][y] < castle[x][y]) continue;
                        
                        queue.offer(new Location(x, y));
                    }
                }
                count++;
            }

            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int check(int x, int y) {
        int sum = 0;
        for(int d = 0; d < 8; d++) {
            if(castle[x+dx[d]][y+dy[d]] == 0) sum++;
        }

        return sum;
    }
}