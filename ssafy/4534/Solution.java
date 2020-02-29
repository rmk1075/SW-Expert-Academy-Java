import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static long MOD = 1000_000_007;
    static long[][] visited;
    static boolean[][] checked;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            checked = new boolean[N][2];
            visited = new long[N][2];
            tree = new ArrayList[N];
            for (int i = 0; i < N; i++)
                tree[i] = new ArrayList<Integer>();

            int a, b;
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;

                tree[a].add(b);
                tree[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    visited[i][j] = -1;
                }
            }

            long count = (cal(0, 0, new ArrayList<Integer>()) + cal(0, 1, new ArrayList<Integer>())) % MOD;

            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb.toString());
    }

    public static long cal(int index, int color, ArrayList<Integer> parent) {
        if (visited[index][color] != -1)
            return visited[index][color];
        checked[index][color] = true;

        visited[index][color] = 1;
        parent.add(Integer.valueOf(index));
        if (color == 0) {
            for (int t : tree[index]) {
                if (parent.contains(t))
                    continue;

                visited[index][color] = (visited[index][color] * (cal(t, 0, parent) + cal(t, 1, parent)) % MOD) % MOD;
            }
        } else {
            for (int t : tree[index]) {
                if (parent.contains(t))
                    continue;

                visited[index][color] = (visited[index][color] * ((cal(t, 0, parent)) % MOD)) % MOD;
            }
        }

        parent.remove(Integer.valueOf(index));
        return visited[index][color];
    }
}