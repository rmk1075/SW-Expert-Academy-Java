import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Location o) {
        if(this.x * this.y == o.x * o.y) return this.x - o.x;
        else return this.x * this.y - o.x * o.y;
    }
}

public class Solution {
    static int T, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr, visited;
    static Queue<Location> queue = new LinkedList<Location>();
    static PriorityQueue<Location> matrix = new PriorityQueue<Location>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] != 0 && visited[i][j] == 0) {

                        queue.offer(new Location(i, j));
                        visited[i][j] = 1;

                        int rowMin = i, rowMax = i;
                        int colMin = j, colMax = j;
                        while(!queue.isEmpty()) {
                            Location current = queue.poll();

                            int x, y;
                            for(int d = 0; d < 4; d++) {
                                x = current.x + dx[d];
                                y = current.y + dy[d];

                                if(x < 0 || y < 0 || n <= x || n <= y || visited[x][y] == 1 || arr[x][y] == 0) continue;

                                rowMax = Math.max(rowMax, x);
                                rowMin = Math.min(rowMin, x);
                                colMax = Math.max(colMax, y);
                                colMin = Math.min(colMin, y);

                                visited[x][y] = 1;
                                queue.offer(new Location(x, y));
                            }

                        }
                        
                        matrix.offer(new Location(rowMax - rowMin + 1, colMax - colMin + 1));
                    }
                }
            }

            sb.append("#" + t + " " + matrix.size());
            while(!matrix.isEmpty()) {
                Location mat = matrix.poll();
                sb.append(" " + mat.x + " " + mat.y);
            }
            
            System.out.println(sb.toString());
            sb = new StringBuilder();
        }

    }
}