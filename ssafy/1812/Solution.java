import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Rect implements Comparable<Rect> {
    int min, max;
    Rect(int w, int h) {
        this.min = (w < h) ? w : h;
        this.max = (w < h) ? h : w;
    }

    @Override
    public int compareTo(Rect o) {
        return o.min - this.min;
    }
}

public class Solution {
    static int T, N, M, count, tiles[];
    static PriorityQueue<Rect> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            tiles = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) tiles[i] = Integer.parseInt(st.nextToken());

            count = 0;
            cut();

            sb.append("#" + t  + " " + count + "\n");
        }
        System.out.println(sb);
    }

    public static void cut() {
        Arrays.sort(tiles);
        queue = new PriorityQueue<>();

        for(int i = N-1; 0 <= i; i--) {
            int len = (1 << tiles[i]);
            if(queue.isEmpty()) {
                count++;
                queue.offer(new Rect(M, M));
            }

            Rect r = queue.poll();
            if(len <= r.min) {
                if(len < r.min) queue.offer(new Rect(r.min - len, len));
                if(len < r.max) queue.offer(new Rect(r.min, r.max - len));
            } else {
                queue.offer(r);
                count++;
                if(len == M) return ;
                queue.offer(new Rect(M-len, len));
                queue.offer(new Rect(M, M-len));
            }
        }
    }
}

// import java.io.*;
// import java.util.*;

// class Tile {
//     int w, h;
//     Tile(int w, int h) {
//         this.w = w;
//         this.h = h;
//     }
// }

// public class Solution {
//     static int T, N, M;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());

//             PriorityQueue<Integer> len = new PriorityQueue<>(Collections.reverseOrder());
//             st = new StringTokenizer(br.readLine());
//             for(int i = 0; i < N; i++) len.offer((int)Math.pow(2, Integer.parseInt(st.nextToken())));

//             ArrayList<Tile> rest = new ArrayList<>();
//             int cnt = 0;
//             while(!len.isEmpty()) {
//                 int tile = len.poll();
//                 int size = rest.size();
//                 for(int i = 0; i < size; i++) {
//                     Tile r = rest.get(i);
//                     if(tile <= r.w && tile <= r.h) {
//                         rest.remove(r);
//                         if(tile < r.w) rest.add(new Tile(r.w - tile, tile));
//                         if(tile < r.h) rest.add(new Tile(r.w, r.h - tile));

//                         tile = 0;
//                         break;
//                     }
//                 }

//                 if(tile == 0) continue;
//                 cnt++;
//                 if(tile == M) continue;
//                 rest.add(new Tile(M - tile, tile));
//                 rest.add(new Tile(M, M - tile));
//             }
//             // Queue<Tile> rest = new LinkedList<>();
//             // int cnt = 0;
//             // while(!len.isEmpty()) {
//             //     int tile = len.poll();
//             //     int size = rest.size();
//             //     while(0 < size--) {
//             //         Tile r = rest.poll();
//             //         if(tile <= r.w && tile <= r.h) {
//             //             if(tile < r.w) rest.offer(new Tile(r.w - tile, tile));
//             //             if(tile < r.h) rest.offer(new Tile(r.w, r.h - tile));

//             //             tile = 0;
//             //             break;
//             //         } else rest.offer(r);
//             //     }

//             //     if(tile == 0) continue;
//             //     cnt++;
//             //     if(tile == M) continue;
//             //     rest.offer(new Tile(M - tile, tile));
//             //     rest.offer(new Tile(M, M - tile));
//             // }

//             sb.append("#" + t + " " + cnt + "\n");
//         }
//         System.out.println(sb);
//     }
// }