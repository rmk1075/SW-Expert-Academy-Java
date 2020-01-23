import java.util.Scanner;

public class Solution {
    static int T;
    static int N = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            String[][] lines = new String[N][];

            int maxLength = 0;
            for(int i = 0; i < N; i++) {
                lines[i] = sc.next().split("");
                maxLength = Math.max(maxLength, lines[i].length);
            }

            System.out.print("#" + (t+1) + " ");
            for(int i = 0; i < maxLength; i++) {
                for(int j = 0; j < N; j++) {
                    if(i < lines[j].length) {
                        System.out.print(lines[j][i]);
                    }
                }
            }
            System.out.println();
        }

        sc.close();
    }
}