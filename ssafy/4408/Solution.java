import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static int[] corridor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            corridor = new int[201];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                if(src % 2 == 1) src++;
                if(dest % 2 == 1) dest++;

                if(dest < src) {
                    int temp = src;
                    src = dest;
                    dest = temp;
                }

                for(int s = src / 2; s <= dest / 2; s++) {
                    corridor[s]++;
                }
            }

            int time = 0;
            for(int i = 0; i < corridor.length; i++) {
                time = Math.max(time, corridor[i]);
            }

            sb.append("#" + t + " " + time + "\n");
        }

        System.out.println(sb.toString());
    }
}