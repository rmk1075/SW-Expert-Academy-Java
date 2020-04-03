import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, R, MOD = 1234567891;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        fact = new long[1000001];
        fact[0] = 1;
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            
            long a = fact(N), b = (fact(R) * fact(N-R)) % MOD;
            long result = a * pow(b, MOD-2) % MOD;
            sb.append("#" + t + " " + result + "\n");
        }

        System.out.println(sb);
    }

    public static long fact(int n) {
        if(fact[n] != 0) return fact[n];
        for(int i = 1; i <= n; i++) {
            if(fact[i] != 0) continue;
            fact[i] = (i * fact[i-1]) % MOD;
        }
        return fact[n];
    }

    public static long pow(long a, long b) {
        long result = 1, temp = a;
        while(0 < b) {
            if(b % 2 == 1) result = (result * temp) % MOD;
            b = b / 2;
            temp = (temp * temp) % MOD;
        }
        return result;
    }
}