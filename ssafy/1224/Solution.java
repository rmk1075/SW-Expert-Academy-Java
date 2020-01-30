import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int T, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = 10;

        for(int t = 1; t < T + 1; t++) {
            N = sc.nextInt();
            char[] str = sc.next().toCharArray();

            String stream = "";
            Stack<Character> stack = new Stack<Character>();
            for(char ch : str) {
                if(Character.isDigit(ch)) {
                    stream += ch;
                } else if(ch == ')') {
                    while(stack.peek() != '(') {
                        stream += stack.pop();
                    }
                    stack.pop();
                } else {
                    while(!stack.isEmpty() && icp(ch) <= isp(stack.peek())) {
                        stream += stack.pop();
                    }

                    stack.push(ch);
                }
            }

            while(!stack.isEmpty()) stream += stack.pop();

            Stack<Integer> stack1 = new Stack<Integer>();
            for(char ch : stream.toCharArray()) {
                if(Character.isDigit(ch)) {
                    stack1.push(ch - '0');
                } else {
                    stack1.push(cal(stack1.pop(), stack1.pop(), ch));
                }
            }

            System.out.println("#" + t + " " + stack1.pop());
        }
        sc.close();
    }

    public static int cal(int a, int b, char ch) {
        if(ch == '*') return a * b;
        else return a + b;
    }

    public static int icp(char ch) {
        switch(ch) {
            case '*':
                return 2;
            case '+':
                return 1;
            case '(':
                return 3;
        }

        return 0;
    }

    public static int isp(char ch) {
        switch(ch) {
            case '*':
                return 2;
            case '+':
                return 1;
            case '(':
                return 0;
        }

        return 0;
    }
}