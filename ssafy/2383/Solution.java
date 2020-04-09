import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, ans = Integer.MAX_VALUE, map[][] = new int[10][10], distance[][] = new int[2][101], stairs[][] = new int[2][2];
    static ArrayList<int[]> person = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            person.clear();
            for(int i = 0, s = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) person.add(new int[] {i, j});
                    else if(1 < map[i][j]) {
                        stairs[s][0] = i;
                        stairs[s++][1] = j;
                    }
                }
            }
            ans = Integer.MAX_VALUE;
            dfs(0, person.size());
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int len) {
        if(len < 0) {
            int[] cnt = new int[2];
            for(int i = 0; i < person.size(); i++) {
                int c = ((n & (1 << i)) == 0) ? 0 : 1;
                distance[c][Math.abs(stairs[c][0] - person.get(i)[0]) + Math.abs(stairs[c][1] - person.get(i)[1])]++;
                cnt[c]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            int time[] = {0, 0};
            for(int d = 0; d < 2; d++) {
                int K = map[stairs[d][0]][stairs[d][1]];
                queue.clear();
                while(0 < cnt[d]) {
                    // stair
                    int size = queue.size();
                    for(int i = 0; i < size; i++) {
                        int cur = queue.poll();
                        if(K <= ++cur) cnt[d]--;
                        else queue.offer(cur);
                    }
    
                    // stair entrance
                    while(queue.size() < 3 && 0 < distance[d][0]) {
                        queue.offer(0);
                        distance[d][0]--;
                    }
    
                    distance[d][0] += distance[d][1];
                    for(int i = 1; i < 100; i++) distance[d][i] = distance[d][i+1];
                    time[d]++;
                }
            }
            ans = Math.min(ans, Math.max(time[0], time[1]));
            return ;
        }

        dfs(n | (1 << len), len-1);
        dfs(n, len-1);
    }
}