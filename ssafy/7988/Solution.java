import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, K, idx;
    static int[] group;
    static boolean[][] connection;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            connection = new boolean[200][200];
            map = new HashMap<>();
            
            K = Integer.parseInt(br.readLine());
            idx = 0;
            for(int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();

                int a, b;
                if(map.get(A) == null) {
                    a = idx++;
                    map.put(A, a);
                } else a = map.get(A);

                if(map.get(B) == null) {
                    b = idx++;
                    map.put(B, b);
                } else b = map.get(B);

                connection[a][b] = connection[b][a] = true;
            }

            group = new int[idx];
            if(find()) sb.append("#" + t + " Yes\n");
            else sb.append("#" + t + " No\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean find() {
        int[] visited = new int[idx];
        for(int i = 0; i < idx; i++) {
            if(visited[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = 1;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();

                for(int j = 0; j < idx; j++) {
                    if(!connection[current][j]) continue;

                    if(visited[j] == 0) {
                        visited[j] = -visited[current];
                        queue.offer(j);
                    } else if(visited[j] == visited[current]) return false;
                }
            }
        }

        return true;
    }
}