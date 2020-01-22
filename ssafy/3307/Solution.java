import java.util.Scanner;

class Solution {
    static int T, N;
    static int[] nums, dp;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            nums = new int[N];
            dp = new int[N+1];

            for(int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            int maxVal = 0;            
            dp[0] = 1;
            for(int i = 1; i < N; i++) {
                for(int j = i; -1 < j; j--) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i]++;
                maxVal = Math.max(maxVal, dp[i]);
            }

            System.out.println("#" + test_case + " " + maxVal);
        }
        
        sc.close();
	}
}