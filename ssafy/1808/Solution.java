import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, X, buttons, size, minCount;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            minCount = Integer.MAX_VALUE;
            buttons = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                if(Integer.parseInt(st.nextToken()) == 1) buttons |= (1 << i);
            }

            X = Integer.parseInt(br.readLine());
            size = (int)Math.sqrt(X);
            dp = new int[size];
            dfs(X, 0);

            if(minCount == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
            else sb.append("#" + t + " " + minCount + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int dfs(int x, int count) {
        if(x < size && dp[x] != 0) {
            if(count == 0) minCount = dp[x];
            return dp[x];
        }

        if(check(x + "")) {
            int c = (int)Math.log10(x) + 2;
            if(count == 0) minCount = c;

            if(x < size) dp[x] = c;
            return c;
        }

        int result = -1;
        for(int i = 2; i < (int)Math.sqrt(x) + 1; i++) {
            if(x % i == 0 && check(i + "")) {
                int len1 = (int)Math.log10(i) + 2;
                int len2 = dfs(x/i, count + 1);
                if(-1 < len2) {
                    result = len1 + len2;
                    if(x == X) minCount = Math.min(minCount, result);
                }
            }
        }

        if(x < size) dp[x] = result;
        return result;
    }

    public static boolean check(String x) {
        for(char ch : x.toCharArray()) {
            if((buttons & (1 << (ch - '0'))) == 0) return false;
        }

        return true;
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class Solution {
//     static int T, X, buttons, minCount;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb =new StringBuilder();

//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             minCount = Integer.MAX_VALUE;
//             buttons = 0;

//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for(int i = 0; i < 10; i++) {
//                 if(Integer.parseInt(st.nextToken()) == 1) buttons |= (1 << i);
//             }

//             X = Integer.parseInt(br.readLine());
//             dfs(X, 0);

//             if(minCount == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
//             else sb.append("#" + t + " " + minCount + "\n");
//         }

//         System.out.println(sb.toString());
//     }

//     public static int dfs(int x, int count) {
//         if(check(x + "")) {
//             if(count == 0) minCount = (int)Math.log10(x) + 2;
//             return (int)Math.log10(x) + 2;
//         }

//         int result = -1;
//         for(int i = 2; i < (int)Math.sqrt(x) + 1; i++) {
//             if(x % i == 0 && check(i + "")) {
//                 int len1 = (int)Math.log10(i) + 2;
//                 int len2 = dfs(x/i, count + 1);
//                 if(-1 < len2) {
//                     result = len1 + len2;
//                     if(x == X) minCount = Math.min(minCount, result);
//                 }
//             }
//         }
//         return result;
//     }

//     public static boolean check(String x) {
//         for(char ch : x.toCharArray()) {
//             if((buttons & (1 << (ch - '0'))) == 0) return false;
//         }

//         return true;
//     }
// }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class Solution {
//     static int T, X, buttons;
//     static int[] nums;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         StringTokenizer st;

//         T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             buttons = 0;
//             st = new StringTokenizer(br.readLine());
//             for(int i = 0; i < 10; i++) {
//                 if(Integer.parseInt(st.nextToken()) == 1) buttons |= (1 << i);
//             }

//             X = Integer.parseInt(br.readLine());
//             nums = new int[X+1];
//             Arrays.fill(nums, Integer.MAX_VALUE);

//             dfs(0, 1);

//             for(int i = 1; i < nums.length; i++) {
//                 if(nums[i] == Integer.MAX_VALUE) continue;

//                 for(int j = i+1; j < nums.length; j++) {
//                     if(nums[j] == Integer.MAX_VALUE) continue;
//                     if(X < i*j || i*j < 0) break;

//                     nums[i*j] = Math.min(nums[i*j], nums[i] + nums[j]);
//                 }
//             }
//             if(nums[X] == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
//             else sb.append("#" + t + " " + nums[X] + " \n");
//         }
//         System.out.println(sb.toString());
//     }

//     public static void dfs(int val, int count) {
//         for(int i = 0; i < 10; i++) {
//             if(((buttons & (1 << i)) == 0) || (X < (val*10 + i)) || nums[val*10 + i] <= count+1)continue;
//             nums[val*10 + i] = count+1;
//             dfs(val*10 + i, count+1);
//         }
//     }
// }