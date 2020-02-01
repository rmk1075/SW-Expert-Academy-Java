import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static String[] str;
    static Stack<String> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t < 11; t++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            str = st.nextToken().split("");

            stack = new Stack<String>();
            for(String s : str) {
                if(stack.isEmpty() || !stack.peek().equals(s)) stack.push(s);
                else stack.pop();
            }

            String ans = "";
            while(!stack.isEmpty()) {
                ans = stack.pop() + ans;
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.StringTokenizer;
// import java.io.IOException;

// public class Solution {
//     static int T = 10;
//     static Deque<String> queue;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         for(int t = 1; t < T + 1; t++) {
//             st = new StringTokenizer(br.readLine());

//             int N = Integer.parseInt(st.nextToken());
//             String[] str = st.nextToken().split("");

//             queue = new LinkedList<String>();
//             for(int i = 0; i < N; i++) {
//                 if(queue.isEmpty() || !queue.peek().equals(str[i])) queue.push(str[i]);
//                 else queue.pop();
//             }

//             String ans = "";
//             while(!queue.isEmpty()) ans += queue.pollLast();

//             System.out.println("#" + t + " " + ans);
//         }
//     }
// }