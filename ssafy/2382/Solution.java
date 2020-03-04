import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Micro implements Comparable<Micro> {
    int x, y, cnt, d;

    Micro(int x, int y, int cnt, int d) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.d = d;
    }

    @Override
    public int compareTo(Micro o) {
        return o.cnt <= this.cnt ? 1 : -1;
    }
}

public class Solution {
    static int T, N, M, K;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];            
            PriorityQueue<Micro> micros = new PriorityQueue<>();
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                Micro micro = new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
                micros.offer(micro);
                map[micro.x][micro.y] = micro.cnt;
            }
            
            int[][] tempMap = new int[N][N];
            int count = 0;
            while(!micros.isEmpty()) {
                if(count == M) break;

                PriorityQueue<Micro> tempQ = new PriorityQueue<>();
                while(!micros.isEmpty()) {
                    Micro micro = micros.poll();
                    if(micro.cnt < map[micro.x][micro.y]) continue;

                    micro.x += dx[micro.d];
                    micro.y += dy[micro.d];

                    // if wall
                    if(micro.x == 0 || micro.y == 0 || micro.x == N-1 || micro.y == N-1) {
                        micro.cnt /= 2;
                        if(micro.d % 2 == 0) micro.d++;
                        else micro.d--;

                        tempMap[micro.x][micro.y] = micro.cnt;
                        tempQ.offer(micro);
                        continue;
                    }

                    // single or not
                    if(tempMap[micro.x][micro.y] == 0) {
                        tempMap[micro.x][micro.y] = micro.cnt;
                        tempQ.offer(micro);
                        continue;
                    }

                    micro.cnt += tempMap[micro.x][micro.y];
                    tempMap[micro.x][micro.y] = micro.cnt;
                    tempQ.offer(micro);
                }

                for(int i = 0; i < N; i++) {
                    map[i] = Arrays.copyOf(tempMap[i], N);
                    Arrays.fill(tempMap[i], 0);
                }

                while(!tempQ.isEmpty()) micros.offer(tempQ.poll());
                count++;
            }

            int sum = 0;
            for(Micro micro : micros) {
                if(micro.cnt < map[micro.x][micro.y]) continue;
                sum += micro.cnt;
            }
            sb.append("#" + t + " " + sum + "\n");
        }

        System.out.println(sb.toString());
    }
}