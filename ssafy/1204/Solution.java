import java.util.Scanner;

public class Solution {
    static int T;
    static int[] points;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(0 < T--) {
            int t = sc.nextInt();
            points = new int[101];
            for(int i = 0; i < 1000; i++) {
                int student = sc.nextInt();
                points[student]++;
            }

            int maxVal = -1;
            int ans = -1;
            for(int i = 0; i < 101; i++) {
                if(maxVal <= points[i]) {
                    maxVal = points[i];
                    ans = i;
                }
            }

            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }
}