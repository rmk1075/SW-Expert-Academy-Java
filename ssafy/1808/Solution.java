import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, X, buttons;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            buttons = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                if(Integer.parseInt(st.nextToken()) == 1) buttons |= (1 << i);
            }

            X = Integer.parseInt(br.readLine());
            nums = new int[X+1];
            Arrays.fill(nums, Integer.MAX_VALUE);

            dfs(0, 1);

            for(int i = 1; i < nums.length; i++) {
                if(nums[i] == Integer.MAX_VALUE) continue;

                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] == Integer.MAX_VALUE) continue;
                    if(X < i*j || i*j < 0) break;

                    nums[i*j] = Math.min(nums[i*j], nums[i] + nums[j]);
                }
            }
            if(nums[X] == Integer.MAX_VALUE) sb.append("#" + t + " -1\n");
            else sb.append("#" + t + " " + nums[X] + " \n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int val, int count) {
        for(int i = 0; i < 10; i++) {
            if(((buttons & (1 << i)) == 0) || (X < (val*10 + i)) || nums[val*10 + i] <= count+1)continue;
            nums[val*10 + i] = count+1;
            dfs(val*10 + i, count+1);
        }
    }
}