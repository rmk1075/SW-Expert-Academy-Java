import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, K, base;
    static char nums[];
    static Set<String> candidates = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            base = N / 4;
            nums = br.readLine().toCharArray();

            candidates.clear();
            
            // divide
            divide();

            for(int i = 1; i < N; i++) {
                // rotate
                char tmp = nums[N-1];
                for(int j = N-1; 0 < j; j--) nums[j] = nums[j-1];
                nums[0] = tmp;

                // divide
                divide();
            }

            int idx = 0, ans[] = new int[candidates.size()];
            for(String candidate : candidates) ans[idx++] = Integer.parseInt(candidate, 16);
            Arrays.sort(ans);
            sb.append("#" + t + " " + ans[ans.length - K] + "\n");
        }
        System.out.println(sb);
    }

    public static void divide() {
        for(int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < base; j++) sb.append(nums[base*i + j]);
            candidates.add(sb.toString());
        }
    }
}