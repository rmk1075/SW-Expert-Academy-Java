import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T = 10, N;
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N + 1][3]; // [0]: val, [1]: left, [2]: right

            String[] line;
            for(int i = 1; i < N + 1; i++) {
                line = br.readLine().split(" ");

                for(int j = 1; j < line.length; j++) {
                    arr[i][j - 1] = line[j];
                }
            }

            sb.append("#" + t + " " + check(1) + "\n");
            // System.out.println("#" + t + " " + check(1));
        }

        System.out.println(sb.toString());
    }

    public static int check(int index) {

        // is operand
        if(Character.isDigit(arr[index][0].toCharArray()[0])) {

            if(arr[index][1] != null || arr[index][2] != null) {
                return 0;
            }

        } else {
            // is operator
            if(arr[index][1] == null || arr[index][2] == null) {
                return 0;
            }  
        }

        int left = 1, right = 1;
        if(arr[index][1] != null) left = check(Integer.parseInt(arr[index][1]));
        if(arr[index][2] != null) right = check(Integer.parseInt(arr[index][2]));

        return left * right;
    }
}