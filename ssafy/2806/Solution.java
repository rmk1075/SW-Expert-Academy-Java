import java.util.Scanner;

public class Solution {
    static int T, N, count;
    static int[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N];
            count = 0;
            find(0);

            sb.append("#" + t + " " + count + "\n");
        }

        sc.close();
        System.out.println(sb.toString());
    }

    public static void find(int level) {
        if(level == N) {
            count++;
            return ;
        }

        for(int i = 0; i < N; i++) {
            map[level] = i;

            if(check(level)) find(level+1);

            map[level] = 0;
        }
    }

    public static boolean check(int level) {
        for(int i = 0; i < level; i++) {
            if(map[i] == map[level]) return false;
            if(Math.abs(level-i) == Math.abs(map[level]-map[i])) return false;
        }

        return true;
    }
}