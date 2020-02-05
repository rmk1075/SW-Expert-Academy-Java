import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int T = 10, N = 8;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        while(0 < T--) {
            t = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                queue.offer(Integer.parseInt(st.nextToken()));

            int val = 1;
            int current = 0;
            while(true) {

                current = queue.poll();
                current -= val++;

                if(val == 6) val = 1;

                if(current <= 0) break;

                queue.offer(current);
            }

            queue.offer(0);
            System.out.print("#" + t + " ");
            while(!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}