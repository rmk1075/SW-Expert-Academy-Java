import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int T, win, lose;
    static int[] card1 = new int[9];
    static int[] visited = new int[9];
    static ArrayList<String> card2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            card2 = new ArrayList<String>();
            for(int i = 1; i < 19; i++) {
                card2.add(String.valueOf(i));
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++) {
                card1[i] = Integer.parseInt(st.nextToken());
                card2.remove(String.valueOf(card1[i]));
            }
            
            win = lose = 0;
            find(0, 0);

            System.out.println("#" + t + " " + win + " " + lose);
        }
    }

    public static void find(int count, int val) {

        if(count == 9) {
            if(0 < val) win++;
            else if (val < 0) lose++;
            return ;
        }

        for(int i = 0; i < 9; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                int temp = Integer.parseInt(card2.get(i));
                if(card1[count] < temp) {
                    find(count + 1, val - card1[count] - temp);
                } else {
                    find(count + 1, val + card1[count] + temp);
                }

                visited[i] = 0;
            }
        }
    }
}