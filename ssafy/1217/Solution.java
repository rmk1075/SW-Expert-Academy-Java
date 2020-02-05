import java.util.Scanner;

public class Solution {

    static int N, M, T = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t;
        while(0 < T--) {
            t = sc.nextInt();
            
            N = sc.nextInt();
            M = sc.nextInt();

            System.out.println("#" + t + " " + recursion(N, M, 1));
        }

        sc.close();
    }

    public static int recursion(int n, int m, int val) {
        if(m == 0) return val;

        return recursion(n, m - 1, n * val);
    }
}