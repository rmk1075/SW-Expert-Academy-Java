import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T + 1; t++) {
            N = Integer.parseInt(br.readLine());

            int mid = N / 2;
            int val = 0;
            String[] temp;
            for(int i = 0; i < mid; i++) {
                temp = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    if(mid - i <= j && j <= mid + i) {
                        val += Integer.parseInt(temp[j]);
                    }
                }
            }

            for(int i = mid; 0 <= i; i--) {
                temp = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    if(mid - i <= j && j <= mid + i) {
                       val += Integer.parseInt(temp[j]); 
                    }
                }
            }

            System.out.println("#" + t + " " + val);
        }
    }
}