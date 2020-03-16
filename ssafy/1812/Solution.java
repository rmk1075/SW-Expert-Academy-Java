import java.io.*;
import java.util.*;

class Tile {
    int w, h;
    Tile(int w, int h) {
        this.w = w;
        this.h = h;
    }
}

public class Solution {
    static int T, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> len = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) len.offer((int)Math.pow(2, Integer.parseInt(st.nextToken())));

            ArrayList<Tile> rest = new ArrayList<>();
            int cnt = 0;
            while(!len.isEmpty()) {
                int tile = len.poll();
                int size = rest.size();
                for(int i = 0; i < size; i++) {
                    Tile r = rest.get(i);
                    if(tile <= r.w && tile <= r.h) {
                        rest.remove(r);
                        if(tile < r.w) rest.add(new Tile(r.w - tile, tile));
                        if(tile < r.h) rest.add(new Tile(r.w, r.h - tile));

                        tile = 0;
                        break;
                    }
                }

                if(tile == 0) continue;
                cnt++;
                if(tile == M) continue;
                rest.add(new Tile(M - tile, tile));
                rest.add(new Tile(M, M - tile));
            }
            // Queue<Tile> rest = new LinkedList<>();
            // int cnt = 0;
            // while(!len.isEmpty()) {
            //     int tile = len.poll();
            //     int size = rest.size();
            //     while(0 < size--) {
            //         Tile r = rest.poll();
            //         if(tile <= r.w && tile <= r.h) {
            //             if(tile < r.w) rest.offer(new Tile(r.w - tile, tile));
            //             if(tile < r.h) rest.offer(new Tile(r.w, r.h - tile));

            //             tile = 0;
            //             break;
            //         } else rest.offer(r);
            //     }

            //     if(tile == 0) continue;
            //     cnt++;
            //     if(tile == M) continue;
            //     rest.offer(new Tile(M - tile, tile));
            //     rest.offer(new Tile(M, M - tile));
            // }

            sb.append("#" + t + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}