import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int T = 10, N, M, x, y;
    static ArrayList<Integer> pwd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            pwd = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) pwd.add(Integer.parseInt(st.nextToken()));

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                if(st.nextToken().equals("I")) {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++) {
                        pwd.add(x + j, Integer.parseInt(st.nextToken()));
                    }

                } else {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++) {
                        pwd.remove(x);
                    }
                }
            }

            System.out.print("#" + t);
            for(int i = 0; i < 10; i++) {
                System.out.print(" " + pwd.get(i));
            }
            System.out.println();
        }

    }
}