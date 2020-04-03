import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        char[] A, B;
        long ans;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken().toCharArray();
            B = st.nextToken().toCharArray();
            if((A[0] == '-' && B[0] != '-') || (A[0] != '-' && B[0] == '-')) ans = cal(A) + cal(B) - 1;
            else ans = Math.abs(cal(A) - cal(B));
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static long cal(char[] num) {
        int t = (num[0] == '-') ? 0 : -1;
        long val = 0, digit = 1;
        for(int i = num.length-1; t < i; i--) {
            int temp = num[i] - '0';
            if(temp < 5) val += temp * digit;
            else val += (temp - 1) * digit;
            digit *= 9;
        }
        return val;
    }
}