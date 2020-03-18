// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.HashMap;
// import java.util.StringTokenizer;

// public class Solution {
//     static int T;
//     static HashMap<Long, Long> m = new HashMap<Long, Long>();
//     public static void main(String[] args) throws IOException {
//         m.clear();
//         for(int i = 1; i < 17; i++) {
//             long v = pow10(0L + i);
//             m.put((v - 1L), h(v - 1L));
//         }

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             long A = Long.parseLong(st.nextToken());
//             long B = Long.parseLong(st.nextToken());

//             sb.append("#" + t + " " + cal(B, A) + "\n");
//         }
//         System.out.println(sb);
//     }

//     public static long cal(long b, long a) {
//         if(a <= 1) return f(b);
//         else if(a == b) return f(b) - f(a-1);
//         else return f(b)-f(a-1);
//     }

//     public static long g(long n) {
//         if(n <= 9) return e(n);
//         long v = pow10(len(n));
//         return (n / v) * (n % v + 1L) + f(n % v);
//     }

//     private static long f(long n) {
//         if(m.containsKey(n)) return m.get(n);
//         else if(n <= 9) return e(n);
//         long v = pow10(len(n));
//         m.put(n, f(n-1L-n%v) + g(n));
//         return m.get(n);
//     }

//     public static long h(long n) {
//         long len = len(n) + 1L;
//         return ((45L)*(len)*(1L+n)) / 10L;
//     }

//     public static long e(long n) {
//         return n*(n+1L) / 2L;
//     }

//     public static long len(long n) {
//         return 0L + (n + "").length()-1;
//     }

//     public static long pow10(long n) {
//         return (long)Math.pow(10, n);
//     }
// }

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