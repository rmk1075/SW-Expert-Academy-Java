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

            Integer[] len = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) len[i] = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
            Arrays.sort(len, Collections.reverseOrder());

            Queue<Tile> rest = new LinkedList<>();
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                int size = rest.size();
                while(0 < size--) {
                    Tile r = rest.poll();
                    if(len[i] <= r.w && len[i] <= r.h) {
                        if(len[i] < r.w) rest.offer(new Tile(r.w - len[i], len[i]));
                        if(len[i] < r.h) rest.offer(new Tile(r.w, r.h - len[i]));

                        len[i] = 0;
                        break;
                    } else rest.offer(r);
                }

                if(len[i] == 0) continue;
                cnt++;
                if(len[i] == M) continue;
                rest.offer(new Tile(M - len[i], len[i]));
                rest.offer(new Tile(M, M - len[i]));
            }

            sb.append("#" + t + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}