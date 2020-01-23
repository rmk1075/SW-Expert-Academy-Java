import java.util.Scanner;

public class Solution {
    static int T, t;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    static int[][] ladder;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = 10;
        while(0 < T--) {
            t = sc.nextInt();
            ladder = new int[100][100];

            int[] point = new int[2];
            int[] previousPoint = new int[2];
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                    if(ladder[i][j] == 2) {
                        point[0] = i;
                        point[1] = j;
                    }
                }
            }

            while(0 < point[0]) {
                for(int i = 0; i < 3; i++) {
                    int x_ = point[0] + dx[i];
                    int y_ = point[1] + dy[i];
                    if(x_ < 0 || 100 <= x_ || y_ < 0 || 100 <= y_) continue;

                    if(ladder[x_][y_] == 1 && (x_ != previousPoint[0] || y_ != previousPoint[1])) {
                        previousPoint[0] = point[0];
                        previousPoint[1] = point[1];

                        point[0] = x_;
                        point[1] = y_;
                        
                        break;
                    }
                }
            }

            System.out.println("#" + t + " " + point[1]);
        }
        sc.close();
    }
}