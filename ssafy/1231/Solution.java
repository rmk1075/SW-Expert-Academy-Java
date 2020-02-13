import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T = 10, N;
    static String[] data;
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N + 1][3];

            for(int i = 1; i < N + 1; i++) {
                data = br.readLine().split(" ");
                for(int j = 1; j < data.length; j++) arr[i][j - 1] = data[j];
            }

            System.out.print("#" + t + " ");
            traversal(1);
            System.out.println();
        }
    }

    public static void traversal(int index) {
        if(arr[index][1] != null) traversal(Integer.parseInt(arr[index][1]));
        System.out.print(arr[index][0]);
        if(arr[index][2] != null) traversal(Integer.parseInt(arr[index][2]));
    }
}