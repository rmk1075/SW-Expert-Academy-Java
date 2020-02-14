import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static int[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T + 1; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            people = new int[N + 1];
            for(int i = 1; i < N + 1; i++) {
                people[i] = i;
            }

            int a, b;
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                // union
                people[find(a)] = find(b);
            }

            count = 0;
            for(int i = 1; i < N + 1; i++) {
                if(people[i] == i) count++;
            }

            sb.append("#" + t + " " + count + "\n");
        }

        System.out.println(sb.toString());
    }

    public static int find(int a) {

        if(people[a] == a) return a;

        return people[a] = find(people[a]);
    }
}