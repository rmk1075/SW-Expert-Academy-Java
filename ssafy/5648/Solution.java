import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Atom {
    int x, y, d, k;
    boolean isDeath = false;

    Atom(int y, int x, int d, int k) {
        this.y = y;
        this.x = x;
        this.d = d;
        this.k = k;
    }
}

public class Solution {
    static int T, N, map[][] = new int[4001][4001];
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static Queue<Atom> atoms = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            for(int i = 0; i < 4001; i++) Arrays.fill(map[i], 0);

            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2, y = (Integer.parseInt(st.nextToken()) + 1000) * 2, d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
                map[y][x] = k;
                atoms.offer(new Atom(y, x, d, k));
            }

            int ans = 0;
            while(1 < atoms.size()) {
                Atom atom = atoms.poll();
                int x = atom.x, y = atom.y;
                if(atom.k < map[y][x]) {
                    ans += map[y][x];
                    map[y][x] = 0;
                    continue;
                }

                map[y][x] -= atom.k;
                y += dy[atom.d];
                x += dx[atom.d];
                if(x < 0 || y < 0 || x == 4001 || y == 4001) continue;

                if(map[y][x] == 0) atoms.offer(new Atom(y, x, atom.d, atom.k));
                map[y][x] += atom.k;
            }

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}