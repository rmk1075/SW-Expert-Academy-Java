import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), count = 0;
            if(b == 1) {
                if((t-s) % a == 0) count = (t-s) / a;
                else count = -1;

                sb.append("#" + tc + " " + count + "\n");
                continue;
            }

            while(s < t) {
                if(t % b == 0) {
                    if(t/b < s) t -= a;
                    else t /= b;
                } else t -= a;
                count++;
            }
            sb.append("#" + tc + " " + ((t < s) ? -1 : count) + "\n");
        }
        System.out.println(sb);
    }
}