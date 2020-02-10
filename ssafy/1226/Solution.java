import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

class Location {
    int x, y;
    
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T = 10, N = 16, t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] maze;
    static Queue<Location> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(0 < T--) {
            t = Integer.parseInt(br.readLine());
            queue = new LinkedList<Location>();
            maze = new String[N][N];
            for(int i = 0; i < N; i++) {
                maze[i] = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    if(maze[i][j].equals("2")) queue.offer(new Location(i, j));
                }
            }
            
            boolean check = false;
            while(!queue.isEmpty()) {
                Location current = queue.poll();

                int x, y;
                for(int d = 0; d < 4; d++) {
                    x = current.x + dx[d];
                    y = current.y + dy[d];

                    if(x < 0 || y < 0 || N <= x || N <= y || maze[x][y].equals("1")) continue;

                    if(maze[x][y].equals("3")) {
                        System.out.println("#" + t + " 1");
                        check = true;
                        break;
                    }

                    maze[x][y] = "1";
                    queue.offer(new Location(x, y));
                }
            }

            if(!check)
                System.out.println("#" + t + " 0");
        }
    }
}