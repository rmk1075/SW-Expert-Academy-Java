import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Cell implements Comparable<Cell> {
    int x, y, k, rest;
 
    Cell(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.rest = k * 2;
    }
 
    @Override
    public int compareTo(Cell o) {
        return o.k - this.k;
    }
}
 
public class Solution {
    static int T, N, M, K, map[][];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static PriorityQueue<Cell> queue1 = new PriorityQueue();
    static PriorityQueue<Cell> queue2 = new PriorityQueue();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[2*K + 2 + N][2*K + 2 + M];
            queue1.clear();
            for(int i = K; i < K + N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = K; j < K + M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0) queue1.offer(new Cell(i, j, map[i][j]));
                }
            }
             
            int x, y;
            while(0 < K--) {
                while(!queue1.isEmpty()) {
                    Cell current = queue1.poll();
                    if(current.rest == current.k) {
                        for(int d = 0; d < 4; d++) {
                            x = current.x + dx[d];
                            y = current.y + dy[d];
                            if(map[x][y] != 0) continue;
                            map[x][y] = current.k;
                            queue2.offer(new Cell(x, y, current.k));
                        }
                    }
                    current.rest--;
                    if(current.rest != 0) queue2.offer(current);
                }
                queue1.addAll(queue2);
                queue2.clear();
            }
            sb.append("#" + t + " " + queue1.size() + "\n");
        }
        System.out.println(sb);
    }
}