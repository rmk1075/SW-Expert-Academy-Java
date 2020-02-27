import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, minVal;
    static int[] prices = new int[4], plan = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) prices[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 12; i++) plan[i] = Integer.parseInt(st.nextToken());

            minVal = prices[3];
            cal(0, 0);

            sb.append("#" + t + " " + minVal + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void cal(int month, int sum) {

        if(12 <= month) {
            minVal = Math.min(minVal, sum);
            return ;
        }

        cal(month + 1, sum + prices[0] * plan[month]);
        cal(month + 1, sum + prices[1]);
        cal(month + 3, sum + prices[2]);
    }
}