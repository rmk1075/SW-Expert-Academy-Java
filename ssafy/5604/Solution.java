import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long point = 1;
            long[] ans = new long[10];
            while(A <= B) {
                while(B % 10 != 9 && A <= B) {
                    cal(B, ans, point);
                    B--;
                }

                if(B < A) break;

                while(A % 10 != 0 && A <= B) {
                    cal(A, ans, point);
                    A++;
                }

                A /= 10;
                B /= 10;
                for(int i = 0; i < 10; i++) {
                    ans[i] += (B - A + 1) * point;
                }

                point *= 10;
            }
            long sum = 0;
            for(int i = 1; i < 10; i++) sum += ans[i] * i;

            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.println(sb);
    }

    public static void cal(long num, long[] ans, long point) {
        while(0 < num) {
            ans[(int)(num % 10)] += point;
            num /= 10;
        }       

    }
}