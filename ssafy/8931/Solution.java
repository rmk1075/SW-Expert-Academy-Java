import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int T, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int t = 1; t < T + 1; t++) {
            K = sc.nextInt();

            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < K; i++) {
                int temp = sc.nextInt();

                if(temp == 0) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }

            int sum = 0;
            while(!stack.isEmpty())
                sum += stack.pop();

            System.out.println("#" + t + " " + sum);
        }

        sc.close();
    }
}