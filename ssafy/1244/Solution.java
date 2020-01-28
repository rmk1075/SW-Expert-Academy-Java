import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    static int T, count, maxVal;
    static int[] nums;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T+1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String num = st.nextToken();
            count = Integer.parseInt(st.nextToken());
            visited = new boolean[1000000][count + 1];

            nums = new int[num.length()];
            for(int i = 0; i < num.length(); i++) {
                nums[i] = Integer.parseInt(num.substring(i, i+1));
            }

            maxVal = -1;

            for(int i = 0; i < nums.length; i++) {
                find(i, 0, nums.clone());
            }

            System.out.println("#" + t + " " + maxVal);
        }
    }

    public static void find(int idx, int cnt, int[] stream) {

        if(count == cnt) {
            int val = 0;
            for (int i = 0; i < stream.length; i++) {
                val += stream[i] * Math.pow(10, stream.length - 1 - i);
            }

            maxVal = Math.max(maxVal, val);
            return ;
        }

        for(int i = 0; i < stream.length; i++) {
            for(int j = 0; j < stream.length; j++) {
                if(i == j) continue;

                int temp = stream[i];
                stream[i] = stream[j];
                stream[j] = temp;

                int val = 0;
                for (int k = 0; k < stream.length; k++) {
                    val += stream[k] * Math.pow(10, stream.length - 1 - k);
                }

                if(!visited[val][cnt]) {
                    find(i, cnt + 1, stream.clone());
                    visited[val][cnt] = true;
                }
                
                temp = stream[i];
                stream[i] = stream[j];
                stream[j] = temp;
            }
        }
    }
}
